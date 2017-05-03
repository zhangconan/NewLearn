package com.zkn.newlearn.lambda;

import java.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by 北京-张烨 on 2016/12/24 0024.
 */
public class P<T> {
    private final Spliterator<T> st;

    public P(Spliterator<T> st) {
        this.st = st;
    }

    public <R> P<R> map(Function<T, R> f) {
        Spliterator<R> stMap = new MapSp<>(st, f);
        return new P(stMap);
    }

    public P<T> filter(Predicate<T> p) {
        Spliterator<T> stFilter = new FilterSp<>(st, p);
        return new P(stFilter);
    }

    class FilterSp<T> implements Spliterator<T> {
        Spliterator<T> sp;
        Predicate<T> filter;

        public FilterSp(Spliterator<T> sp, Predicate<T> filter) {
            this.sp = sp;
            this.filter = filter;
        }

        @Override
        public boolean tryAdvance(Consumer<? super T> action) {
            return sp.tryAdvance((x) -> {
                if (filter.test(x)) {
                    action.accept(x);
                }
            });
        }

        @Override
        public Spliterator<T> trySplit() {
            return new FilterSp<>(sp.trySplit(), filter);
        }

        @Override
        public long estimateSize() {
            return sp.estimateSize();
        }

        @Override
        public int characteristics() {
            return sp.characteristics();
        }
    }

    class MapSp<R> implements Spliterator<R> {
        Spliterator<T> sp;
        Function<T, R> mapper;

        public MapSp(Spliterator<T> sp, Function<T, R> f) {
            this.sp = sp;
            mapper = f;
        }

        @Override
        public boolean tryAdvance(Consumer<? super R> action) {
            return sp.tryAdvance(x -> action.accept(mapper.apply(x)));
        }

        @Override
        public Spliterator<R> trySplit() {
            return new MapSp<R>(sp.trySplit(), mapper);
        }

        @Override
        public long estimateSize() {
            return sp.estimateSize();
        }

        @Override
        public int characteristics() {
            return sp.characteristics();
        }
    }

    public void forEach(Consumer<T> t) {
        if ((st.characteristics() & Spliterator.SIZED) != 0) {
            parEach(t);
        } else {
            while (st.tryAdvance(t)) {
                ;
            }
        }
    }

    void parEach(Consumer<T> action) {
        long targetBatchSize = st.estimateSize() / (ForkJoinPool.getCommonPoolParallelism() * 8);
        new ParEach(null, st, action, targetBatchSize).invoke();
    }

    static class ParEach<T> extends CountedCompleter<Void> {
        final Spliterator<T> spliterator;
        final Consumer<T> action;
        final long targetBatchSize;

        ParEach(ParEach<T> parent, Spliterator<T> spliterator,
                Consumer<T> action, long targetBatchSize) {
            super(parent);
            this.spliterator = spliterator;
            this.action = action;
            this.targetBatchSize = targetBatchSize;
        }

        @Override
        public void compute() {
            Spliterator<T> sub;
            while (spliterator.estimateSize() > targetBatchSize &&
                    (sub = spliterator.trySplit()) != null) {
                addToPendingCount(1);
                new ParEach<>(this, sub, action, targetBatchSize).fork();
            }
            spliterator.forEachRemaining(action);
            propagateCompletion();
        }

    }

    public static void main(String[] args) {
        int size = 10;
        Integer[] t = new Integer[size];
        for (int i = 0; i < size; i++) {
            t[i] = Integer.valueOf(i);
        }
        TheArraySpliterator<Integer> sp = new TheArraySpliterator<>(t, 0, size);
        P<Integer> p = new P(sp);
        p.filter(x -> x % 2 == 0)
                .map(x -> x * 2)
                .forEach(System.out::println);
    }
}


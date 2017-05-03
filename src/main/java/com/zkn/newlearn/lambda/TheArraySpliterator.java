package com.zkn.newlearn.lambda;

import java.util.Spliterator;
import java.util.function.Consumer;
/**
 * Created by 北京-张烨 on 2016/12/25.
 */
public class TheArraySpliterator<T> implements Spliterator<T> {
    private final Object[] array;
    private int origin;
    private final int fence; // one past the greatest index

    TheArraySpliterator(Object[] array, int origin, int fence) {
        this.array = array; this.origin = origin; this.fence = fence;
    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {
        for (; origin < fence; origin++) {
            action.accept((T)array[origin]);
        }
    }

    @Override
    public boolean tryAdvance(Consumer<? super T> action) {
        if (origin < fence) {
            action.accept((T) array[origin]);
            origin++;
            return true;
        }
        else // cannot advance
        {
            return false;
        }
    }

    @Override
    public Spliterator<T> trySplit() {
        int lo = origin;
        int mid = ((lo + fence) >>> 1);
        if (lo < mid) {
            origin = mid;
            return new TheArraySpliterator<>(array, lo, mid);
        }
        else {
            return null;
        }
    }

    @Override
    public long estimateSize() {
        return (long)((fence - origin) / 2);
    }

    @Override
    public int characteristics() {
        return ORDERED | SIZED | IMMUTABLE | SUBSIZED;
    }
}

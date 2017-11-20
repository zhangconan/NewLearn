package com.zkn.newlearn.jdk8.stream;/**
 * Created by zkn on 2017/11/20.
 */

import com.zkn.newlearn.domain.PersonDomain;

import java.util.Optional;

/**
 * @author zkn
 * @date 2017/11/20 21:04
 */
public class OptionalLearn {

    public static void main(String[] args) {
        /**
         * 根据一个非空值创建Optional，如果值为空，则抛出NullPointerException
         */
        //Optional<String> stringOptional = Optional.of("张三");
        //System.out.println(stringOptional.orElseThrow(CustomException::new));

        Optional<String> emptyOptional = Optional.empty();
        //System.out.println(emptyOptional.orElseThrow(CustomException::new));

        PersonDomain personDomain = new PersonDomain();
        personDomain.setName("zhangsan");
        Optional<PersonDomain> objOptional = Optional.ofNullable(personDomain);


        objOptional = Optional.empty();
        System.out.println(objOptional.map(e -> e.getName()).isPresent());

        objOptional = Optional.empty();
        System.out.println(objOptional.filter(e -> e.getAge() > 10).orElse(new PersonDomain()));

        Optional<String> stringOptional = Optional.of("zhangsan");
        stringOptional.ifPresent(e-> System.out.println("我被处理了。。。"+e));

        System.out.println(stringOptional.flatMap(e -> Optional.of("lisi")).orElse("失败"));

        stringOptional = Optional.empty();
        System.out.println(stringOptional.flatMap(e -> Optional.empty()).orElse("失败"));


    }

    private static class CustomException extends RuntimeException {
        private static final long serialVersionUID = -4399699891687593264L;

        public CustomException() {
            super("自定义异常");
        }

        public CustomException(String message) {

            super(message);
        }
    }
}

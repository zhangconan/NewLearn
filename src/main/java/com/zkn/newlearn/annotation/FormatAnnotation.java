package com.zkn.newlearn.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wb-zhangkenan on 2017/4/13.
 *
 * @author wb-zhangkenan
 * @date 2017/04/13
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FormatAnnotation {

    /**
     * 日期的格式
     * @return
     */
    String dateFormat() default "yyyy-MM-dd hh:mm:ss";

    /**
     * list集合的长度
     * @return
     */
    String listLength() default "4";

    /**
     * map集合的长度
     * @return
     */
    String mapLength() default "4";
}

package com.xxt.spring.ioc.annotation;

import java.lang.annotation.*;

/**
 * @author xxt
 * @description
 * @date 2021-07-07 09:57
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LookupMe {
}

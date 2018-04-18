package com.lgd.lgdmyutilsx.Permissionlib.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by mq on 2018/3/6 上午11:34
 * lgdm
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface NeedPermission {

    String[] value();

    int requestCode() default 0;
}

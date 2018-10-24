package com.sbuslab.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Searchable {
    String query();
    boolean selectable() default true;
    String matchAgainstColumn() default "";
    boolean rawSql() default false;
}

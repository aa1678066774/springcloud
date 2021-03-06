package com.tww.annocation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface TestAnnotations {
    TestAnnotation[] value();
}

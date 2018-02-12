package ua.ucu.edu.sparkcourse.udf;

import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Component
public @interface RegisterUDF {

    boolean isValidator() default false;
}
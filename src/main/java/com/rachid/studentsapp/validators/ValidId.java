package com.rachid.studentsapp.validators;

import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidId {

    String message() default "The ID should be a valid number bigger than 0";

    int lower() default  0;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

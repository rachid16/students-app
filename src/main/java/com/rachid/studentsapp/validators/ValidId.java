package com.rachid.studentsapp.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdValidator.class)
public @interface ValidId {

    String message() default "The ID should be a valid number bigger than {lower} ";

    int lower() default  0;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

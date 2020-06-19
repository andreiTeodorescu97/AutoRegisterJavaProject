package com.auto.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PlateConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniquePlate {
	//default value
	public String value() default "";
	
	//default error message
	public String message() default "Plate already exists in database!";
	
	//define default groups
	public Class<?>[] groups() default {};
	
	//define default payloads, additional info about validation error
	public Class<? extends Payload>[] payload() default {};
}

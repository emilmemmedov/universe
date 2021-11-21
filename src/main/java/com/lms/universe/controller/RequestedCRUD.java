package com.lms.universe.controller;


import java.lang.annotation.*;

/**
 * this is for CRUD operations. We can show here which mapping should be applied for Controller
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestedCRUD {
    public String[] mapping() default "Invalid Institution type";

}

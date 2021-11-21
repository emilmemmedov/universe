package com.lms.universe.controller;


import com.lms.universe.config.CRUD;

import java.lang.annotation.*;

/**
 * this is for CRUD operations. We can show here which mapping should be applied for Controller
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestedCRUD {
    public CRUD[] mapping() default {CRUD.CREATE, CRUD.SHOW,CRUD.UPDATE, CRUD.INDEX,CRUD.DELETE};

}

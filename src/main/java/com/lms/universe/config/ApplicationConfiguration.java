package com.lms.universe.config;


import java.util.ArrayList;
import java.util.List;
//Singleton
public class ApplicationConfiguration {
    private  static ApplicationConfiguration instance;

    private String name = "Universe";
    private String description = "Global LMS(Learning Management System) service";
    private String version = "1.0.0";
    private String author = "Emil Mammadov";
    private List<String> poweredBy = new ArrayList<>(){{
       add("Spring Boot");
       add("MYsql");
       add("Tomcat");
    }};

    private ApplicationConfiguration() {
    }

    public static synchronized ApplicationConfiguration getInstance(){
        if (instance == null){
            instance = new ApplicationConfiguration();
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getVersion() {
        return version;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getPoweredBy() {
        return poweredBy;
    }
}
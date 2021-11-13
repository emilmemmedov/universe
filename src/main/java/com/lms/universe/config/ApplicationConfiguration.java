package com.lms.universe.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@ConfigurationProperties("universe")
@Component
@Data
public class ApplicationConfiguration {

    private String name;
    private String description;
    private String version;
    private String author;
    private List<String> poweredBy;

}
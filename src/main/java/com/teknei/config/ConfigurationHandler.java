package com.teknei.config;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Amaro on 21/06/2017.
 */
public class ConfigurationHandler {

    private ConfigurationHandler(){
    }

    private static final ConfigurationHandler instance = new ConfigurationHandler();
    @Getter
    @Setter
    private Integer idEqui;
    public static ConfigurationHandler getInstance(){
        return instance;
    }
}

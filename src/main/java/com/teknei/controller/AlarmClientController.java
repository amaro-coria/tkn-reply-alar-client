package com.teknei.controller;

import com.teknei.client.AlarmClient;
import com.teknei.config.ConfigurationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Amaro on 21/06/2017.
 */
@Component
public class AlarmClientController {

    @Value("${teknei.logfile}")
    private String alarmLogFile;
    @Autowired
    private AlarmClient client;

    @Scheduled(fixedRate = 30000)
    private void processAlarmText(){
        String alarmText = getAlarmText();
        client.sendAlarm(ConfigurationHandler.getInstance().getIdEqui(), alarmText);
    }



    private String getAlarmText(){
        try {
            String content = new String(Files.readAllBytes(Paths.get(alarmLogFile)));
            return content;
        } catch (IOException e) {
            return "";
        }
    }

}

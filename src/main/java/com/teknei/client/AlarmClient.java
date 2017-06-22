package com.teknei.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Amaro on 21/06/2017.
 */
@FeignClient(name = "", url = "")
public interface AlarmClient {

    @RequestMapping(value = "/alarm/process/{idEqui}/${alarmText}")
    String sendAlarm(Integer idEqui, String alarmText);

}

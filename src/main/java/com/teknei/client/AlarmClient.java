package com.teknei.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Amaro on 21/06/2017.
 */
@FeignClient(name = "${teknei.alarm-client-name}", url = "${teknei.alarm-server-url}")
public interface AlarmClient {

    @RequestMapping(value = "/alarm/process/{idEqui}/{alarmText}", method = RequestMethod.GET, consumes = {
            MediaType.APPLICATION_JSON_VALUE})
    String sendAlarm(@PathVariable("idEqui") Integer idEqui, @PathVariable("alarmText") String alarmText);

}

package com.teknei;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients
public class ReplyAlarApplication {

	private static final Logger log = LoggerFactory.getLogger(ReplyAlarApplication.class);

    /**
     * Main entry point
     *
     * @param args
     */
    public static void main(String[] args) {
        boolean reply = false;
        boolean test = false;
        if (args == null || args.length == 0) {
            log.info(
                    "No known option, invoke following: '-v' for version , '-t' for testing , '-h' for help, '-r' for start reply service");
            log.info("Exiting with code 1");
            System.exit(1);
        } else {
            if (args[0].equalsIgnoreCase("-v")) {
                log.info("TKN_VERSION:{}", "1.0.0");
                System.exit(0);
            } else if (args[0].equalsIgnoreCase("-r")) {
                log.info("Running to listen to reply alarm");
                reply = true;
            } else if (args[0].equalsIgnoreCase("-t")) {
                log.debug("TKN Unit testing");
                test = true;
            } else if (args[0].equalsIgnoreCase("-h")) {
                log.info("Application for send alarm records to alarm server");
                log.info("Usage:  '-v' for version , '-t' for testing , '-h' for help, '-r' for reply");
                log.info(
                        "For specify application.properties use '--spring.config.location=<FULL_CONFIG_PATH_TO_YML_FILE>' as last command parameter");
                log.info(
                        "Example: java -jar reply-server.jar -t --spring.config.location=/home/teknei/SITM/CONFIG/tkn_reply_client.yml");
                System.exit(0);
            } else {
                log.info(
                        "No known option, invoke following: '-v' for version , '-t' for testing , '-h' for help, '-r' for reply");
                log.info("Exiting with code 1");
                System.exit(1);
            }
        }
        ConfigurableApplicationContext ctx = SpringApplication.run(ReplyAlarApplication.class, args);
        if (reply) {
            System.out.println("##############################################");
            System.out.println("   ###########  ###     ###   #####     ###");
            System.out.println("       ###      ###   ####    ### ###   ###");
            System.out.println("       ###      ### #####     ###  ###  ###");
            System.out.println("       ###      ######        ###   ### ###");
            System.out.println("       ###      ###  ####     ###    ######");
            System.out.println("       ###      ####  ####    ###     #####");
            System.out.println("##############################################");
            System.out.println("TKN service started");
        }
    }
}

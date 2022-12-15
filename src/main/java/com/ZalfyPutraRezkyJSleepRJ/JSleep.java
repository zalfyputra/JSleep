package com.ZalfyPutraRezkyJSleepRJ;

import com.ZalfyPutraRezkyJSleepRJ.dbjson.JsonDBEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class that is used to launch Spring Boot application
 * @author Zalfy Putra Rezky
 */
@SpringBootApplication
public class JSleep
{
    public static void main(String[] args) {
        JsonDBEngine.Run(JSleep.class);
        SpringApplication.run(JSleep.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(JsonDBEngine::join));
    }
}
package com.acme.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.Instant;

@RestController
public class WebController {

    String previousTimestamp = "NONE";

    @GetMapping("/")
    public String home() {

        String env = System.getenv("WELCOME_MESSAGE");
        if(env == null){
            env = "UNKNOWN";
        }

        String now = Instant.now().toString();

        String page = "<html><body style='text-align:center;font-family:Arial;'>"
                + "<h1>Greetings for the day</h1>"
                + "<h2 style='color:green'>version : 2.0</h2>"
                + "<h3 style='color:red'>Previous Timestamp : " + previousTimestamp + "</h3>"
                + "<h3 style='color:blue'>Latest Timestamp : " + now + "</h3>"
                + "<h3 style='color:pink'>Run Env : " + env + "</h3>"
                + "</body></html>";

        previousTimestamp = now;

        return page;
    }
}

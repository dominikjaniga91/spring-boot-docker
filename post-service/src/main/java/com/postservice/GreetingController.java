package com.postservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dominik_Janiga
 */
@RestController
@RequestMapping("/greeting")
class GreetingController {

    @GetMapping
    String getGreeting() {
        return "Hello, k8s!";
    }
}

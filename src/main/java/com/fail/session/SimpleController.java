package com.fail.session;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by castor on 2020/07/22.
 * Not licensed under public domain.
 */
@RestController
public class SimpleController {

    @GetMapping(path = "/dev")
    String aDev(){
        return "just dev";
    }

}

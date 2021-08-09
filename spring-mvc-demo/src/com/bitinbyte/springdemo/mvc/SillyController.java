package com.bitinbyte.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SillyController
 */
@Controller
public class SillyController {
    @RequestMapping("/showForm")
    public String displayTheForm() {
        return "silly";
    }

}

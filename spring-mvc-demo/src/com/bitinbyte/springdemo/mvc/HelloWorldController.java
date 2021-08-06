package com.bitinbyte.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HelloWorldController
 */
@Controller
public class HelloWorldController {

    // Need a controller method to show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form"; // WEB-INF/view/helloworld-form.jsp
    }

    // Need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // New controller method to read form data and
    // add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letShoutDude(HttpServletRequest request, Model model) {
        // Read the request parameter from the HTML form
        String theName = request.getParameter("studentName");
        // Convert the data to all caps
        theName = theName.toUpperCase();
        // Create the message
        String result = "Yo! " + theName;
        // Add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

}

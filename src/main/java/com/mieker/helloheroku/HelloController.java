package com.mieker.helloheroku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/throw")
public class HelloController {

    @Autowired
    private final RollerService throwService;

    public HelloController(RollerService rollerService) {
        this.throwService = rollerService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "hello traveler";
    }

    @GetMapping
    //parameters assume the number of dice rolls
    public int multipleThrows(@RequestParam int d4, @RequestParam int d6, @RequestParam int d8, @RequestParam int d10,
                              @RequestParam int d12, @RequestParam int d20, @RequestParam int modification) {
        return throwService.multipleThrows(d4, d6, d8, d10, d12, d20, modification);
    }
}

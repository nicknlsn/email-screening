package com.nicknlsn.emailscreeningserver.view;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1")
public class MainController {

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "test", produces = "text/plain")
    public String test() {
        return "test response";
    }
}

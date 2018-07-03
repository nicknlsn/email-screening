package com.nicknlsn.emailscreeningserver.view;

import com.nicknlsn.emailscreeningserver.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * this controller holds all the endpoints, for a larger api there would be many controllers
 * take note that this class implements {@link ApiV1} which means all the endpoint paths are prepended with /api/v1
 */
@RestController
public class MainController implements ApiV1 {

    private MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping(value = "test", produces = "text/plain")
    public String test() {
        return "test response";
    }

    @GetMapping(value = "integer-palindrome")
    public Boolean integerPalindrome(@RequestParam String value) {
        return mainService.integerPalindrome(value);
    }
}

package com.nicknlsn.emailscreeningserver.view;

import com.nicknlsn.emailscreeningserver.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;
import java.util.List;

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

    @GetMapping(value = "integer-palindrome")
    public Boolean integerPalindrome(@RequestParam BigInteger value) {
        return mainService.integerPalindrome(value);
    }

    @GetMapping(value = "chuck-norris-categories")
    public List<String> getJokeCategories() {
        return mainService.getCategories();
    }

    @GetMapping(value = "chuck-norris-category")
    public String chuckNorrisCategory(@RequestParam String category) {
        return mainService.getRandomJokeByCategory(category);
    }


    @GetMapping(value = "chuck-norris-joke-search")
    public String chuckNorrisJokeSearch(@RequestParam String value) {
        return mainService.chuckNorrisJokeSearch(value);
    }

    @GetMapping(value = "unique-traversal")
    public String uniqueTraversal(@RequestParam String value) {
        return null;
    }

    @GetMapping(value = {"/", "/error", "/login"}, produces = "text/html")
    public ModelAndView router() {
        return new ModelAndView("index.html");
    }
}

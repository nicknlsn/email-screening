package com.nicknlsn.emailscreeningserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class MainService {

    private ChuckNorrisApi chuckNorrisApi;

    @Autowired
    public MainService(ChuckNorrisApi chuckNorrisApi) {
        this.chuckNorrisApi = chuckNorrisApi;
    }

    public Boolean integerPalindrome(BigInteger value) {
        // negative numbers can't be a palindrome because of the negative sign
        if (value.compareTo(BigInteger.ZERO) < 0) {
            return false;
        }

        // if the reversed string is the same as the original it is a palindrome
        return new StringBuilder(value.toString()).reverse().toString().equals(value.toString());
    }

    public String getRandomJokeByCategory(String category) {
        return chuckNorrisApi.byCategory(category);
    }
}
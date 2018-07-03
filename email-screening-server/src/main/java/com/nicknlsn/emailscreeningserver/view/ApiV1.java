package com.nicknlsn.emailscreeningserver.view;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * set the request path for the app api, also allow requests from the local dev client server to enable developing
 * locally
 */
@RestController
@RequestMapping(value = "api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public interface ApiV1 {
}

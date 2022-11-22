package br.com.valhalla.ohwaiter.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthRest {

    @GetMapping
    public Map<String, Object> get(Principal principal){
        Map<String, Object> result = new HashMap<>();
        result.put("status", "OK");
        result.put("moment", new Date());
        result.put("user", principal.getName());
        return result;
    }

}

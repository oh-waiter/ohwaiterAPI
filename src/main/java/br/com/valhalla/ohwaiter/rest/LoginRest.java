package br.com.valhalla.ohwaiter.rest;

import br.com.valhalla.ohwaiter.model.Login;
import com.franciscocalaca.http.utils.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginRest {
    @Autowired
    private Login loginDao;

    @PostMapping
    public Map<String, Object> post(@RequestBody Map<String, Object> dados){

        String login = (String) dados.get("login");
        String senha = (String) dados.get("senha");
        Token token = loginDao.getToken(login, senha);


        Map<String, Object> resp = new HashMap<>();
        resp.put("access_token", token.getAccessToken());
        resp.put("login", login);
        return resp;
    }


}

package br.com.valhalla.ohwaiter.resource;

import br.com.valhalla.ohwaiter.model.Usuario;
import br.com.valhalla.ohwaiter.repository.LoginRepository;
import br.com.valhalla.ohwaiter.repository.UsuarioRespository;
import com.franciscocalaca.http.auth.User;
import com.franciscocalaca.http.auth.UtilManager;
import com.franciscocalaca.http.utils.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginResource {
    @Autowired
    private LoginRepository loginDao;

    @Value("${ads04.security.urlManager}")
    private String urlManager;

    @Value("${ads04.security.userManager}")
    private String userManager;

    @Value("${ads04.security.passManager}")
    private String passManager;

    @Autowired
    private UsuarioRespository usuarioRespository;


    @PostMapping
    public Map<String, Object> post(@RequestBody Map<String, Object> dados){

        String login = (String) dados.get("login");
        String senha = (String) dados.get("senha");
        Token token = loginDao.getToken(login, senha);
        System.out.println(login);


        Map<String, Object> resp = new HashMap<>();
        resp.put("access_token", token.getAccessToken());
        resp.put("login", login);
        return resp;
    }
    @PostMapping("/criar")
    public void criarUsuario(@RequestBody Map<String, Object> dados){
        String login = (String) dados.get("login");
        String cpf = (String) dados.get("cpf");
        String nome = (String) dados.get("nome");
        String pass = (String) dados.get("pass");

        User user = new User();
        user.setLogin(login);
        user.setPassword(pass);
        user.getRoles().add("ROLE_VIEWER");
        user.setTenant("teste");
        UtilManager.createUser(urlManager,userManager,passManager,user);

        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        usuario.setNome(nome);
        usuario.setCpf(cpf);
        usuarioRespository.save(usuario);






    }


}

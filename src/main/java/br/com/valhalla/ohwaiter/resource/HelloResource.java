package br.com.valhalla.ohwaiter.resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/hello")
public class HelloResource {

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o texto OK e a data/hora"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping
    @ApiOperation(value = "Exemplo criado na primeira aula de WS Rest")
    public String get (Principal principal){
        String name = principal == null ? null : principal.getName();
        return "OK " + new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZ").format(new Date()) + " " + name;
    }




}

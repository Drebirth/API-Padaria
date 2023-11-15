package com.api.padaria.controller;

import com.api.padaria.model.Usuario;
import com.api.padaria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/cadastrar-usuario")
    public void salvar(@RequestBody Usuario u) throws NoSuchAlgorithmException {
        service.salvar(u);
    }

    @GetMapping("/usuario/{user}")
    public Usuario teste(@PathVariable String user){
        return service.teste(user);
    }

    @PostMapping("/login")
    public  void logar(@RequestBody Usuario u) throws NoSuchAlgorithmException {
        service.login(u);
    }

}

package com.api.padaria.service;

import com.api.padaria.model.Usuario;
import com.api.padaria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository service;

    public UsuarioService(UsuarioRepository service) {
        this.service = service;
    }

    public List<Usuario> listaUsuarios(){
        return service.findAll();
    }

    public void salvar(Usuario u) throws NoSuchAlgorithmException {

        if (u.getUserName().isEmpty() && u.getSenha().isEmpty() || u.getSenha().isBlank() ){
            //throw new RuntimeException("Usuário e senha não podem ser vazios!");

        }else{
            var senha = criptografia(u.getSenha());
            u.setSenha(senha);
            service.save(u);
        }
    }

    private String criptografia(String texto) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(texto.getBytes());

        StringBuilder hexString = new StringBuilder();
        for (byte b : hash){
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        String hashHex = hexString.toString();

        return hashHex;

    }


}

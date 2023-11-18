package com.api.padaria.service;

import com.api.padaria.model.Usuario;
import com.api.padaria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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


            if (u.getUserName().isEmpty() && u.getSenha().isEmpty() || u.getSenha().isBlank()) {
                throw new RuntimeException("Usuário ou senha não pode ser vazios!");

            } else {
                var senha = criptografia(u.getSenha());
                u.setSenha(senha);
                service.save(u);
            }

    }

    public Usuario login(Usuario u) throws NoSuchAlgorithmException {
        return loginUsuario(u);
    }

    public Usuario teste(String usuario){
        return service.findByUserName(usuario);
    }

    private Usuario loginUsuario(Usuario usuario) throws NoSuchAlgorithmException {
       Usuario teste = service.findByUserName(usuario.getUserName());
       usuario.setSenha(criptografia(usuario.getSenha()));
       if(teste.getUserName().equals(usuario.getUserName()) && teste.getSenha().equals(usuario.getSenha())){
           System.out.println("Acesso liberado!");
       }else{
           throw new RuntimeException("Usuário não cadastrado no sistema" );
       }
            return teste;
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

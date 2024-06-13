package com.prueba.crud.service.encrip;

import com.prueba.crud.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class UsuarioServicePass {
    @Autowired
    UsuarioRepository usuarioRepository;

    public String encriptar(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(pass.getBytes());
        byte[] digest = md.digest();

        String base64Encoded = Base64.getEncoder().encodeToString(digest);

        return base64Encoded;
    }
}

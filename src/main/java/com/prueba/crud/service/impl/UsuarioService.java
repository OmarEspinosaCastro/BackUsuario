package com.prueba.crud.service.impl;

import com.prueba.crud.entity.Usuario;
import com.prueba.crud.repository.UsuarioRepository;
import com.prueba.crud.service.IUsuarioService;
import com.prueba.crud.service.encrip.UsuarioServicePass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.time.format.DateTimeFormatter;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioServicePass usuarioServicePass;
    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
    @Override
    public Usuario insertarUsuario(Usuario usuario)throws NoSuchAlgorithmException {
        String pass= usuario.getPassword();
        String passencode=usuarioServicePass.encriptar(pass);
        usuario.setPassword(passencode);
        return usuarioRepository.save(usuario);
    }

    @Override
    public String  validarPassword(String login, String pass2) throws NoSuchAlgorithmException {
        boolean existe= existeUsuario(login);

        String msje= "";
        if(existe) {
            Usuario usuario = usuarioRepository.findByLogin(login);

            String passencode = usuarioServicePass.encriptar(pass2);
            if (usuario.getPassword().equals(passencode)) {

                if(usuario.getFechaVigencia() != null && !usuario.getFechaVigencia().trim().isEmpty()){
                    LocalDate date = LocalDate.parse(usuario.getFechaVigencia());
                    LocalDate currentDate = LocalDate.now();
                    if (currentDate.isAfter(date)) {
                       msje = "4";
                     } else {
                    msje = "1";
                     }
                }else{
                    msje = "1";
                }


                } else{
                    msje = "2";
                }


        }else{
            msje="3";
        }
        return msje;


    }

    public boolean existeUsuario(String login) {
        Optional<Usuario> usuario = usuarioRepository.findOneByLogin(login);
        return usuario.isPresent();
    }

    @Override
    public List<Usuario> findByEstatus(char estatus) {
        return usuarioRepository.findByStatus(estatus);
        //return usuarioRepository.findAll();
    }
    @Override
    public List<Usuario> findByNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }
    @Override
    public List<Usuario> findByFechaAlta(String  fechaAlta) {
        return usuarioRepository.findByFechaalta(fechaAlta);
    }
    @Override
    public List<Usuario> findByFechaBaja(String fechabaja) {
        return usuarioRepository.findByFechabaja(fechabaja);
    }

    @Override
    public Usuario findByLogin(String login){
        return usuarioRepository.findByLogin(login);
    }

    @Override
    public Usuario updateUser(Usuario usuario) throws NoSuchAlgorithmException {
        //String pass= usuario.getPassword();
        //String passencode=usuarioServicePass.encriptar(pass);
        //usuario.setPassword(passencode);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario bajaUser(String login){
        Usuario usuario = usuarioRepository.findByLogin(login);

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateString = date.format(formatter);
        System.out.println("asdfasdfadsf "+dateString);
        usuario.setFechabaja(dateString);
        usuario.setStatus('B');
        return usuarioRepository.save(usuario);
    }


}


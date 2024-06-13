package com.prueba.crud.service;

import com.prueba.crud.entity.Usuario;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;

public interface IUsuarioService {
    public List<Usuario> findAll();

    public Usuario insertarUsuario(Usuario usuario) throws NoSuchAlgorithmException;

    public String validarPassword(String  login,String  password) throws NoSuchAlgorithmException;

    public List<Usuario> findByEstatus(char estatus);

    public List<Usuario> findByNombre(String nombre);

    public List<Usuario> findByFechaAlta(String  fechaalta);

    public List<Usuario> findByFechaBaja(String fechabaja);

    public Usuario findByLogin(String login);

    public Usuario updateUser(Usuario usuario) throws NoSuchAlgorithmException;

    public Usuario bajaUser(String login);

}

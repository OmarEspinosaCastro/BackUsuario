package com.prueba.crud.controller;


import com.prueba.crud.entity.Usuario;
import com.prueba.crud.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/v1")
@RestController
public class UsuarioController {

    @Autowired
    IUsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

    @PostMapping("/inserta")
    public Usuario insertarUsuario(@RequestBody Usuario usuario) throws NoSuchAlgorithmException {
        return usuarioService.insertarUsuario(usuario);
    }

    @GetMapping("/{login}/{password}")
    public String validarPass(@PathVariable String login, @PathVariable String password) throws NoSuchAlgorithmException {
        return usuarioService.validarPassword(login,password);
    }
    @GetMapping("/estatus/{estatus}")
    public List<Usuario> findByEstatus(@PathVariable char estatus){
        return usuarioService.findByEstatus(estatus);
    }
    @GetMapping("/nombre/{nombre}")
    public List<Usuario> findByNombre(@PathVariable String nombre){
        return usuarioService.findByNombre(nombre);
    }

    @GetMapping("/alta/{fechaalta}")
    public List<Usuario> findByFechaAlta(@PathVariable String fechaalta){
        return usuarioService.findByFechaAlta(fechaalta);
    }

    @GetMapping("/baja/{fechabaja}")
    public List<Usuario> findByFechaBaja(@PathVariable String fechabaja){
        return usuarioService.findByFechaBaja(fechabaja);
    }
    @GetMapping("/busca/{login}")
    public Usuario findByLogin(@PathVariable String login){
        return usuarioService.findByLogin(login);
    }

    @PutMapping("/modificar")
    public Usuario updateUser(@RequestBody Usuario usuario) throws NoSuchAlgorithmException {
        return usuarioService.updateUser(usuario);
    }

    @PutMapping("/darBaj/{login}")
    public Usuario  bajaUser(@PathVariable String login) {
        return usuarioService.bajaUser(login);
    }



}

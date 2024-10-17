package com.Merces.cadastro_usuario.controller;

import com.Merces.cadastro_usuario.model.Usuario;
import com.Merces.cadastro_usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> createUser (@RequestBody Usuario user){
        Usuario createdUser = usuarioService.createdUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Usuario> userByUsername(@PathVariable String username){
        Optional<Usuario> user = usuarioService.getUserByUsername(username);
        return user.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PutMapping("/{username}/{password}")
    public ResponseEntity<Usuario> updateUser (@PathVariable String username,@PathVariable String password, @RequestBody Usuario user){
        Usuario userpd = usuarioService.updateUser(username,password,user);
        if (userpd != null){
            return ResponseEntity.ok(userpd);
        }
        return ResponseEntity.notFound().build();
    }

}

package com.Merces.cadastro_usuario.service;

import com.Merces.cadastro_usuario.model.Usuario;
import com.Merces.cadastro_usuario.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario createdUser(Usuario username) {
        Optional<Usuario> userOption = usuarioRepository.findById(username.getUsername());
        if(userOption.isPresent()){
            return null;
        }
        return usuarioRepository.save(username);
    }

    public Optional<Usuario> getUserByUsername(String username){
        return usuarioRepository.findById(username);
    }
    public Usuario updateUser(String username,String senha, Usuario userDetails){
        Optional<Usuario> userOption = usuarioRepository.findById(username);
        if (userOption.isPresent()){

            Usuario user = userOption.get();
            if (user.getPassword().equalsIgnoreCase( senha)) {
                user.setName(userDetails.getName());
                user.setEmail(userDetails.getEmail());
                user.setPassword(userDetails.getPassword());
                return usuarioRepository.save(user);
            }
            return null;
        }
        return null;
    }
}

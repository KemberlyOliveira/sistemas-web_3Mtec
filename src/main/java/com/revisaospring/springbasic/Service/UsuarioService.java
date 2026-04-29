package com.revisaospring.springbasic.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.revisaospring.springbasic.Entity.Usuario;
import com.revisaospring.springbasic.Repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired 
    private UsuarioRepository oUsuarioRepository;
    @Autowired 
    private PasswordEncoder encoder;

    public void cadastraUsario (Usuario oUsuario){

        //realizando a cripitrogarfia da senha
        oUsuario.setPassword(encoder.encode(oUsuario.getPassword()));
    }


    
}
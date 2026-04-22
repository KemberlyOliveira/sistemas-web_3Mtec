package com.revisaospring.springbasic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revisaospring.springbasic.Entity.Produto;
import com.revisaospring.springbasic.Entity.Usuario;
import com.revisaospring.springbasic.Service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/usuarioCTR")
public class UsuarioController {
    
    @Autowired
    private UsuarioService oUsuarioService;

@GetMapping("/formCadastrarUsuario") /// para chamar a tela
    public String telaCadastraUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastrarUsuario";
}}

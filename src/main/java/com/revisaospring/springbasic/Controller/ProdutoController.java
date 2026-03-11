package com.revisaospring.springbasic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revisaospring.springbasic.Entity.Produto;
import com.revisaospring.springbasic.Service.ProdutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/produtoCTR")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;// produtoService é um objeto

    @GetMapping("/listarProdutos")
    public String telaListarProdutos(Model model) {// model é um objeto
        model.addAttribute("produtos", produtoService.buscarTodos());
        return "listarProdutos";
    }

    @GetMapping("/formCadastrar") /// para chamar a tela
    public String telaCadastraProduto(Model model) {
        model.addAttribute("produto", new Produto());
        return "cadastrarProduto";
    }

    @PostMapping("/salvarProduto")
    public String cadastrarProduto(@ModelAttribute Produto oProduto) { //oProduto é um obleto
        produtoService.cadastraProduto(oProduto);        
        return "redirect:/produtoCTR/listarProdutos" ;
    }

}
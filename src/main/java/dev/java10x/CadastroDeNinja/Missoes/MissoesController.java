package dev.java10x.CadastroDeNinja.Missoes;

import org.springframework.web.bind.annotation.*;

//LOCALHOST:8080/adicionar
@RestController
@RequestMapping("missoes")
public class MissoesController {

    //GET --Mandar uma requisicao para mostrar as missoes
    @GetMapping("/listar")
    public String listarMissao(){
        return "Missoes listadas com sucesso";
    }

    // Post -- Mandar uma requisicao para criar as missoes
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao criadas com sucesso";
    }

    // PUT -- Mandar uma requisicao para alterar as missoes
    @PutMapping("/alterar")
    public String  alterarMissao(){
        return "Missao alteradas com sucesso";
    }

    // Delete -- Mandar uma requisicao para deletar as missoes
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletadas com sucesso";
    }


}

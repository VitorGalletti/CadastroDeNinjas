package dev.java10x.CadastroDeNinja.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//LOCALHOST:8080/adicionar
@RestController
@RequestMapping("missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //GET --Mandar uma requisicao para mostrar as missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissao(){
        return missoesService.listarMissoes();
    }
    //GET por id
    @GetMapping("/listar/{id}")
    public Optional<MissoesModel> listarMissaoPorId(@PathVariable Long id) {
        return missoesService.listarMissoesPorId(id);
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

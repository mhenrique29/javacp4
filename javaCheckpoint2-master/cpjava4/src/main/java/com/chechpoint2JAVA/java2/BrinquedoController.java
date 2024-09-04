package com.chechpoint2JAVA.java2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/brinquedos")
public class BrinquedoController {

    private final BrinquedoRepository brinqueRepo;

    // Injeção de dependência pelo construtor
    public BrinquedoController(BrinquedoRepository brinqueRepo) {
        this.brinqueRepo = brinqueRepo;
    }

    // Listar todos os brinquedos
    @GetMapping
    public String listarBrinquedos(Model model) {
        List<Brinquedo> brinquedos = brinqueRepo.findAll();
        model.addAttribute("brinquedos", brinquedos);
        return "listarBrinquedos"; // Nome do template Thymeleaf para listar os brinquedos
    }

    // Obter um brinquedo por ID
    @GetMapping("/{id}")
    public String obterBrinquedoPorId(@PathVariable Long id, Model model) {
        Optional<Brinquedo> brinquedoOpt = brinqueRepo.findById(id);
        if (brinquedoOpt.isPresent()) {
            model.addAttribute("brinquedo", brinquedoOpt.get());
            return "detalhesBrinquedo"; // Nome do template Thymeleaf para mostrar detalhes do brinquedo
        } else {
            return "erro"; // Nome do template Thymeleaf para mostrar uma página de erro
        }
    }

    // Mostrar o formulário para adicionar um novo brinquedo
    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionar(Model model) {
        model.addAttribute("brinquedo", new Brinquedo());
        return "adicionarBrinquedo"; // Nome do template Thymeleaf para adicionar um novo brinquedo
    }

    // Adicionar um novo brinquedo
    @PostMapping("/adicionar")
    public String adicionarBrinquedo(@ModelAttribute Brinquedo brinquedo, Model model) {
        Brinquedo novoBrinquedo = brinqueRepo.save(brinquedo);
        model.addAttribute("brinquedo", novoBrinquedo);
        return "redirect:/brinquedos"; // Redireciona para a lista de brinquedos
    }

    // Mostrar o formulário para atualizar um brinquedo existente
    @GetMapping("/atualizar/{id}")
    public String mostrarFormularioAtualizar(@PathVariable Long id, Model model) {
        Optional<Brinquedo> brinquedoOpt = brinqueRepo.findById(id);
        if (brinquedoOpt.isPresent()) {
            model.addAttribute("brinquedo", brinquedoOpt.get());
            return "atualizarBrinquedo"; // Nome do template Thymeleaf para atualizar o brinquedo
        } else {
            return "erro"; // Nome do template Thymeleaf para mostrar uma página de erro
        }
    }

    // Atualizar um brinquedo existente
    @PostMapping("/atualizar/{id}")
    public String atualizarBrinquedo(@PathVariable Long id, @ModelAttribute Brinquedo brinquedoAtualizado, Model model) {
        return brinqueRepo.findById(id)
                .map(brinquedo -> {
                    brinquedo.setNome(brinquedoAtualizado.getNome());
                    brinquedo.setTipo(brinquedoAtualizado.getTipo());
                    brinquedo.setClassificacao(brinquedoAtualizado.getClassificacao());
                    brinquedo.setTamanho(brinquedoAtualizado.getTamanho());
                    brinquedo.setPreco(brinquedoAtualizado.getPreco());
                    brinqueRepo.save(brinquedo);
                    return "redirect:/brinquedos"; // Redireciona para a lista de brinquedos
                })
                .orElse("erro"); // Nome do template Thymeleaf para mostrar uma página de erro
    }

    // Excluir um brinquedo
    @GetMapping("/excluir/{id}")
    public String excluirBrinquedo(@PathVariable Long id, Model model) {
        if (brinqueRepo.existsById(id)) {
            brinqueRepo.deleteById(id);
            return "redirect:/brinquedos"; // Redireciona para a lista de brinquedos
        } else {
            return "erro"; // Nome do template Thymeleaf para mostrar uma página de erro
        }
    }
}

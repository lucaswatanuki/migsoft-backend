package migsoft.controller;

import migsoft.model.ProdutoEntity;
import migsoft.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping("")
    public ProdutoEntity post(@RequestBody ProdutoEntity estoque) {
        return produtoService.save(estoque);
    }

    @GetMapping("/all")
    public List<ProdutoEntity> getAll() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public ProdutoEntity getProdutoById(@PathVariable int id) {
        return produtoService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProdutoById(@PathVariable int id) {
        produtoService.deleteById(id);
    }
}

package migsoft.controller;

import migsoft.model.EstoqueEntity;
import migsoft.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {

    @Autowired
    EstoqueService estoqueService;

    @PostMapping("")
    public EstoqueEntity post(@RequestBody EstoqueEntity estoque) {
        return estoqueService.save(estoque);
    }

    @GetMapping("/all")
    public List<EstoqueEntity> getAll() {
        return estoqueService.findAll();
    }

    @GetMapping("/{id}")
    public EstoqueEntity getEstoqueById(@PathVariable int id) {
        return estoqueService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEstoqueById(@PathVariable int id) {
        estoqueService.deleteById(id);
    }
}

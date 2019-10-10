package migsoft.controller;

import migsoft.model.FornecedorEntity;
import migsoft.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fornecedor")
public class FornecedorController {

    @Autowired
    FornecedorService fornecedorService;

    @PostMapping("")
    public FornecedorEntity post(@RequestBody FornecedorEntity fornecedor) {
        return fornecedorService.save(fornecedor);
    }

    @GetMapping("/all")
    public List<FornecedorEntity> getAll() {
        return fornecedorService.findAll();
    }

    @GetMapping("/{id}")
    public FornecedorEntity getFornecedorById(@PathVariable int id) {
        return fornecedorService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFornecedorById(@PathVariable int id) {
        fornecedorService.deleteById(id);
    }
}

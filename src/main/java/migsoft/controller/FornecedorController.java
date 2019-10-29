package migsoft.controller;

import migsoft.model.FornecedorEntity;
import migsoft.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/fornecedor")
public class FornecedorController {

    @Autowired
    FornecedorService fornecedorService;

    @PostMapping("")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public FornecedorEntity post(@RequestBody FornecedorEntity fornecedor) {
        return fornecedorService.save(fornecedor);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<FornecedorEntity> getAll() {
        return fornecedorService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public FornecedorEntity getFornecedorById(@PathVariable int id) {
        return fornecedorService.findById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void deleteFornecedorById(@PathVariable int id) {
        fornecedorService.deleteById(id);
    }
}

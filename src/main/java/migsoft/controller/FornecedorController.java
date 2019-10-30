package migsoft.controller;

import migsoft.model.FornecedorEntity;
import migsoft.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/fornecedor")
public class FornecedorController {

    private final FornecedorService fornecedorService;

    @Autowired
    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @PostMapping("")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<FornecedorEntity> post(@RequestBody FornecedorEntity fornecedor) {
        return ResponseEntity.ok(fornecedorService.save(fornecedor));
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<FornecedorEntity>> getAll() {
        return ResponseEntity.ok(fornecedorService.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<FornecedorEntity> getFornecedorById(@PathVariable("id") int id) {
        return ResponseEntity.ok(fornecedorService.findById(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<FornecedorEntity> update(@PathVariable("id") int id, @RequestBody FornecedorEntity fornecedor) {
        fornecedor.setId(id);
        return ResponseEntity.ok(fornecedorService.update(fornecedor));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void deleteFornecedorById(@PathVariable int id) {
        fornecedorService.deleteById(id);
    }
}

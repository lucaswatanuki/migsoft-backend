package migsoft.controller;

import migsoft.model.EstoqueEntity;
import migsoft.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {

    private final EstoqueService estoqueService;

    @Autowired
    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @PostMapping("")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<EstoqueEntity> post(@RequestBody EstoqueEntity estoque) {
        return ResponseEntity.ok(estoqueService.save(estoque));
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<EstoqueEntity>>getAll() {
        return ResponseEntity.ok(estoqueService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstoqueEntity> getEstoqueById(@PathVariable int id) {
        return ResponseEntity.ok(estoqueService.findById(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<EstoqueEntity> update(@PathVariable("id") int id, @RequestBody EstoqueEntity estoque) {
        estoque.setId(id);
        return ResponseEntity.ok(estoqueService.update(estoque));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Object> deleteEstoqueById(@PathVariable int id) {
        estoqueService.deleteById(id);
        return ResponseEntity.ok("Estoque deletado com sucesso");
    }
}

package migsoft.controller;

import migsoft.model.OrcamentoEntity;
import migsoft.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/orcamento")
public class OrcamentoController {

    private final OrcamentoService orcamentoService;

    @Autowired
    public OrcamentoController(OrcamentoService orcamentoService) {
        this.orcamentoService = orcamentoService;
    }

    @PostMapping("")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<OrcamentoEntity> post(@RequestBody OrcamentoEntity orcamentoEntity) {
        return ResponseEntity.ok(orcamentoService.save(orcamentoEntity));
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<OrcamentoEntity>> getAll() {
        return ResponseEntity.ok(orcamentoService.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<OrcamentoEntity> getOrcamentoById(@PathVariable("id") int id) {
        return ResponseEntity.ok(orcamentoService.findById(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<OrcamentoEntity> update(@PathVariable("id") int id, @RequestBody OrcamentoEntity orcamento) {
        orcamento.setId(id);
        return ResponseEntity.ok(orcamentoService.update(orcamento));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Object> deleteOrcamentoById(@PathVariable int id) {
        orcamentoService.deleteById(id);
        return ResponseEntity.ok("Orçamento excluido");
    }
}

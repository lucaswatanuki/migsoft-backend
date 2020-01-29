package migsoft.controller;

import migsoft.controller.request.OrcamentoRequest;
import migsoft.controller.response.OrcamentoResponse;
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
    public ResponseEntity<OrcamentoResponse> post(@RequestBody OrcamentoRequest orcamentoRequest) {
        return ResponseEntity.ok(orcamentoService.save(orcamentoRequest));
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<OrcamentoResponse>> getAll() {
        return ResponseEntity.ok(orcamentoService.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<OrcamentoResponse> getOrcamentoById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(orcamentoService.findById(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<OrcamentoResponse> update(@PathVariable("id") Integer id, @RequestBody OrcamentoRequest orcamento) {
        return ResponseEntity.ok(orcamentoService.update(orcamento, id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void deleteOrcamentoById(@PathVariable Integer id) {
        orcamentoService.deleteById(id);
    }
}

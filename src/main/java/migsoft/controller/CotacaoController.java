package migsoft.controller;

import migsoft.model.CotacaoEntity;
import migsoft.service.CotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/cotacao")
public class CotacaoController {

    private final CotacaoService cotacaoService;

    @Autowired
    public CotacaoController(CotacaoService cotacaoService) {
        this.cotacaoService = cotacaoService;
    }

    @PostMapping("")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<CotacaoEntity> post(@RequestBody CotacaoEntity cotacao) {
        return ResponseEntity.ok(cotacaoService.save(cotacao));
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<CotacaoEntity>> getAll() {
        return ResponseEntity.ok(cotacaoService.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<CotacaoEntity> getCotacaoById(@PathVariable("id") int id) {
        return ResponseEntity.ok(cotacaoService.findById(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<CotacaoEntity> update(@PathVariable("id") int id, @RequestBody CotacaoEntity cotacao) {
        cotacao.setId(id);
        return ResponseEntity.ok(cotacaoService.update(cotacao));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Object> deleteCotacaoById(@PathVariable int id) {
        cotacaoService.deleteById(id);
        return ResponseEntity.ok("Cotação excluida com sucesso");
    }
}

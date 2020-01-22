package migsoft.controller;

import migsoft.controller.request.CotacaoRequest;
import migsoft.controller.response.CotacaoResponse;
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
    public CotacaoResponse post(@RequestBody CotacaoRequest cotacao) {
        return cotacaoService.save(cotacao);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<CotacaoResponse>> getAll() {
        return ResponseEntity.ok(cotacaoService.findAll());
    }

    @GetMapping("/all/approved")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<CotacaoResponse>> getApproved() {
        return ResponseEntity.ok(cotacaoService.findOnlyApproved());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<CotacaoResponse> getCotacaoById(@PathVariable("id") int id) {
        return ResponseEntity.ok(cotacaoService.findById(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public CotacaoResponse update(@PathVariable("id") Integer id, @RequestBody CotacaoRequest cotacao) {
        return cotacaoService.update(cotacao, id);
    }

    @PutMapping("/status/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public CotacaoResponse setStatus(@PathVariable("id") Integer id) {
        return cotacaoService.aproveById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void deleteCotacaoById(@PathVariable("id") Integer id) {
        cotacaoService.deleteById(id);
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public CotacaoResponse aprove(@PathVariable("id") Integer id) {
        return cotacaoService.updateStatus(id);
    }



}

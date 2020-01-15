package migsoft.controller;

import migsoft.controller.request.FormulaRequest;
import migsoft.controller.response.FormulaResponse;
import migsoft.service.FormulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/formula")
public class FormulaController {

    @Autowired
    FormulaService formulaService;

    @PostMapping("")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<FormulaResponse> post(@RequestBody FormulaRequest formula) {
        return ResponseEntity.ok(formulaService.save(formula));
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<FormulaResponse>>  getAll() {
        return ResponseEntity.ok(formulaService.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<FormulaResponse> getProdutoById(@PathVariable("id") int id) {
        return ResponseEntity.ok(formulaService.findById(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<FormulaResponse> updateProduto(@PathVariable("id") int id, @RequestBody FormulaRequest formula){
        return ResponseEntity.ok(formulaService.update(formula, id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void deleteProdutoById(@PathVariable Integer id) {
        formulaService.deleteById(id);
    }

}

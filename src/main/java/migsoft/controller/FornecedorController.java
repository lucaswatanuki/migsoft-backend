package migsoft.controller;

import migsoft.model.FornecedorEntity;
import migsoft.model.response.FornecedorResponse;
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
    public FornecedorResponse post(@RequestBody FornecedorEntity fornecedor) {
        return fornecedorService.save(fornecedor);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<FornecedorResponse> getAll() {
        return fornecedorService.findAll();
    }

    @GetMapping("/all/active")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<FornecedorResponse> getAllActive() {
        return fornecedorService.findAllActive();
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public FornecedorResponse getFornecedorById(@PathVariable("id") Integer id) {
        return fornecedorService.findById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public FornecedorResponse update(@PathVariable("id") Integer id, @RequestBody FornecedorEntity fornecedor) {
        fornecedor.setId(id);
        return fornecedorService.update(fornecedor);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void deleteFornecedorById(@PathVariable int id) {
        fornecedorService.deleteById(id);
    }
}

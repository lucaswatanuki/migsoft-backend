package migsoft.controller;

import migsoft.controller.request.ProdutoRequest;
import migsoft.exceptions.ProdutoInexistenteException;
import migsoft.exceptions.Resposta;
import migsoft.controller.mappers.ProdutoMapper;
import migsoft.model.ProdutoEntity;
import migsoft.controller.response.ProdutoResponse;
import migsoft.service.ProdutoService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping("")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ProdutoResponse post(@RequestBody ProdutoRequest request) {
        return produtoService.save(request);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<ProdutoResponse> getAll() {
        List<ProdutoResponse> response = produtoService.findAll();
        return response;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ProdutoResponse getProdutoById(@PathVariable("id") Integer id) {
        return produtoService.findById(id);
    }

    @GetMapping("/nome/{nome}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Object> getProdutoByName(@PathVariable("nome") String nome) {
        try {
            return ResponseEntity.ok(produtoService.findByNome(nome));
        } catch (ProdutoInexistenteException e) {
            return ResponseEntity.badRequest().body(new Resposta(e.getLocalizedMessage()));
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ProdutoResponse updateProduto(@PathVariable("id") Integer id, @RequestBody ProdutoRequest request) {
        return produtoService.update(request, id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void deleteProdutoById(@PathVariable("id") Integer id) {
        produtoService.deleteById(id);
    }
}
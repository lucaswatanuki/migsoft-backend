package migsoft.controller;

import migsoft.Exceptions.ProdutoInexistenteException;
import migsoft.Exceptions.Resposta;
import migsoft.model.ProdutoEntity;
import migsoft.model.response.ProdutoResponse;
import migsoft.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ProdutoResponse post(@RequestBody ProdutoEntity produtoEntity) {
        return produtoService.save(produtoEntity);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<ProdutoResponse> getAll() {
        return produtoService.findAll();
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
            return ResponseEntity.badRequest().body(new Resposta(e.getCode(), e.getLocalizedMessage(), null));
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ProdutoResponse updateProduto(@PathVariable("id") Integer id, @RequestBody ProdutoEntity produto) {
        produto.setId(id);
        return produtoService.update(produto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void deleteProdutoById(@PathVariable("id") Integer id) {
        produtoService.deleteById(id);
    }
}

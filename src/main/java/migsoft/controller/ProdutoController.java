package migsoft.controller;

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
    public List<ProdutoResponse>  getAll() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ProdutoResponse getProdutoById(@PathVariable("id") Integer id) {
        return produtoService.findById(id);
    }

    @GetMapping("/nome/{nome}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ProdutoResponse getProdutoByName(@PathVariable("nome") String nome) {
        return produtoService.findByNome(nome);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ProdutoResponse updateProduto(@PathVariable("id") Integer id, @RequestBody ProdutoEntity produto){
        produto.setId(id);
        return produtoService.update(produto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void deleteProdutoById(@PathVariable("id") Integer id) {
        produtoService.deleteById(id);
    }
}

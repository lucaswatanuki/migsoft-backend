package migsoft.controller;

import migsoft.Exceptions.ProdutoInexistenteException;
import migsoft.Exceptions.Resposta;
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
    public ProdutoResponse post(@RequestBody ProdutoEntity produtoEntity) {
        ProdutoEntity produto = produtoService.save(produtoEntity);
        ProdutoResponse response = Mappers.getMapper(ProdutoMapper.class).toProdutoResponse(produto);
        return response;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<ProdutoResponse> getAll() {
        List<ProdutoEntity> listaProduto = produtoService.findAll();
        List<ProdutoResponse> response = Mappers.getMapper(ProdutoMapper.class).toListaProdutoResponse(listaProduto);
        return response;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ProdutoResponse getProdutoById(@PathVariable("id") Integer id) {
        ProdutoEntity produto = produtoService.findById(id);
        ProdutoResponse response = Mappers.getMapper(ProdutoMapper.class).toProdutoResponse(produto);
        return response;
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
    public ProdutoResponse updateProduto(@PathVariable("id") Integer id, @RequestBody ProdutoEntity produto) {
        produto.setId(id);
        ProdutoEntity produtoEntity = produtoService.save(produto);
        ProdutoResponse response = Mappers.getMapper(ProdutoMapper.class).toProdutoResponse(produto);
        return response;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void deleteProdutoById(@PathVariable("id") Integer id) {
        produtoService.deleteById(id);
    }
}

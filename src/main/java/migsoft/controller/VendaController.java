package migsoft.controller;

import migsoft.Exceptions.EstoqueException;
import migsoft.model.ProdutoEntity;
import migsoft.model.VendaEntity;
import migsoft.model.request.VendaRequest;
import migsoft.model.response.ItemProdutoResponse;
import migsoft.model.response.ProdutoResponse;
import migsoft.model.response.VendaResponse;
import migsoft.service.EstoqueService;
import migsoft.service.ProdutoService;
import migsoft.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/venda")
public class VendaController {

    private final VendaService vendaService;
    private final EstoqueService estoqueService;

    @Autowired
    ProdutoService produtoService;

    @Autowired
    public VendaController(VendaService vendaService, EstoqueService estoqueService) {
        this.vendaService = vendaService;
        this.estoqueService = estoqueService;
    }

    @PostMapping(value = "")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Object> postVenda(@RequestBody VendaEntity venda) throws IllegalArgumentException {
        try {
            estoqueService.subVendaEstoque(venda.getProduto().getId(), venda.getQuantidade());
            VendaResponse response = vendaService.save(venda);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException | EstoqueException exception) {
            return ResponseEntity.badRequest().body("Estoque insuficiente");
        }
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Object> putVenda(@PathVariable("id") Integer id, @RequestBody VendaRequest venda) throws EstoqueException {
        ProdutoResponse produtoResponse = produtoService.findByNome(venda.getProduto());
        VendaResponse vendaResponse = vendaService.findById(id);
        try {
            estoqueService.subVendaEstoque(produtoResponse.getId(), venda.getQuantidade() - vendaResponse.getQuantidade());
            VendaResponse response = vendaService.update(venda, id);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException | EstoqueException exception) {
            return ResponseEntity.badRequest().body("Estoque insuficiente");
        }
    }

    @GetMapping(value = "/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<VendaResponse> getAllVendas() {
        return vendaService.findAll();
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public VendaResponse getVendaById(@PathVariable Integer id) {
        return vendaService.findById(id);
    }


}

package migsoft.controller;

import migsoft.Exceptions.EstoqueException;
import migsoft.model.ItemProduto;
import migsoft.model.VendaEntity;
import migsoft.model.response.ItemProdutoResponse;
import migsoft.model.response.VendaResponse;
import migsoft.service.EstoqueService;
import migsoft.service.ItemProdutoService;
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
    private final ItemProdutoService itemProdutoService;
    private final EstoqueService estoqueService;

    @Autowired
    public VendaController(VendaService vendaService, ItemProdutoService itemProdutoService, EstoqueService estoqueService) {
        this.vendaService = vendaService;
        this.itemProdutoService = itemProdutoService;
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

    @PostMapping(value = "/itemproduto")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ItemProdutoResponse postItemVenda(@RequestBody ItemProduto item) {
        return itemProdutoService.save(item);
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

    @GetMapping(value = "/itemvenda")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<ItemProdutoResponse> getAllItems() {
        return itemProdutoService.findAll();
    }

    @GetMapping(value = "/itemvenda/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ItemProdutoResponse update(@PathVariable("id") Integer id, @RequestBody ItemProduto item) {
        item.setId(id);
        return itemProdutoService.update(item);
    }

    @DeleteMapping(value = "/itemvenda/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void deleteItemById(@PathVariable Integer id) {
        itemProdutoService.deleteById(id);
    }
}

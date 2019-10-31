package migsoft.controller;

import migsoft.model.ItemProduto;
import migsoft.model.VendaEntity;
import migsoft.service.ItemVendaService;
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
    private final ItemVendaService itemVendaService;

    @Autowired
    public VendaController(VendaService vendaService, ItemVendaService itemVendaService) {
        this.vendaService = vendaService;
        this.itemVendaService = itemVendaService;
    }

    @PostMapping(value = "")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<VendaEntity> postVenda(@RequestBody VendaEntity venda) {
        return ResponseEntity.ok(vendaService.save(venda));
    }

    @PostMapping(value = "/itemvenda")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ItemProduto> postItemVenda(@RequestBody ItemProduto item) {
        return ResponseEntity.ok(itemVendaService.save(item));
    }

    @GetMapping(value = "/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<VendaEntity>> getAllVendas() {
        return ResponseEntity.ok(vendaService.findAll());
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public VendaEntity getVendaById(@PathVariable int id) {
        return vendaService.findById(id);
    }

    @GetMapping(value = "/itemvenda")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<ItemProduto>> getAllItems() {
        return ResponseEntity.ok(itemVendaService.findAll());
    }

    @GetMapping(value = "/itemvenda/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ItemProduto> update(@PathVariable("id") int id, @RequestBody ItemProduto item) {
        item.setId(id);
        return ResponseEntity.ok(itemVendaService.update(item));
    }

    @DeleteMapping(value = "/itemvenda/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Object> deleteItemById(@PathVariable int id) {
        itemVendaService.deleteById(id);
        return ResponseEntity.ok("Item excluido");
    }
}

package migsoft.controller;

import migsoft.model.ItemProduto;
import migsoft.model.PedidoEntity;
import migsoft.model.ProdutoEntity;
import migsoft.model.response.ItemProdutoResponse;
import migsoft.model.response.PedidoResponse;
import migsoft.service.EstoqueService;
import migsoft.service.ItemProdutoService;
import migsoft.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    private PedidoService pedidoService;
    private EstoqueService estoqueService;

    @Autowired
    public PedidoController(PedidoService pedidoService, EstoqueService estoqueService) {
        this.pedidoService = pedidoService;
        this.estoqueService = estoqueService;
    }

    @PostMapping("")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public PedidoResponse post(@RequestBody PedidoEntity pedido) {
        PedidoResponse response = pedidoService.save(pedido);
        estoqueService.addPedidoEstoque(pedido.getProduto().getId(), pedido.getQuantidade());
        return response;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<PedidoResponse> getAll() {
        return pedidoService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public PedidoResponse getPedidoById(@PathVariable("id") Integer id) {
        return pedidoService.findById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public PedidoResponse save(@PathVariable("id") Integer id, @RequestBody PedidoEntity pedido) {
        pedido.setId(id);
        return pedidoService.update(pedido);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void deletePedidoById(@PathVariable Integer id) {
        pedidoService.deleteById(id);
    }
}

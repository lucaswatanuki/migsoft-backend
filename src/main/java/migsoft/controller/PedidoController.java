package migsoft.controller;

import migsoft.Exceptions.EstoqueException;
import migsoft.model.PedidoEntity;
import migsoft.model.request.PedidoRequest;
import migsoft.model.response.PedidoResponse;
import migsoft.service.EstoqueService;
import migsoft.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    private final PedidoService pedidoService;
    private final EstoqueService estoqueService;

    @Autowired
    public PedidoController(PedidoService pedidoService, EstoqueService estoqueService) {
        this.pedidoService = pedidoService;
        this.estoqueService = estoqueService;
    }


    @PostMapping("")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public PedidoResponse post(@RequestBody PedidoRequest pedido) throws EstoqueException {
        PedidoResponse response = pedidoService.save(pedido);
        estoqueService.addEstoque(response.getProduto_id(), response.getQuantidade());
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
    public PedidoResponse save(@PathVariable("id") Integer id, @RequestBody PedidoRequest pedido) {
        return pedidoService.update(id, pedido);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void deletePedidoById(@PathVariable Integer id) {
        pedidoService.deleteById(id);
    }
}

package migsoft.controller;

import migsoft.model.PedidoEntity;
import migsoft.model.ProdutoEntity;
import migsoft.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class PedidoController {

    private PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<PedidoEntity> post(@RequestBody PedidoEntity pedido) {
        return ResponseEntity.ok(pedidoService.save(pedido));
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<PedidoEntity> getAll() {
        return pedidoService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<PedidoEntity> getPedidoById(@PathVariable("id") int id) {
        return ResponseEntity.ok(pedidoService.findById(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<PedidoEntity> save(@PathVariable("id") int id, @RequestBody PedidoEntity pedido) {
        pedido.setId(id);
        return ResponseEntity.ok(pedidoService.update(pedido));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Object> deletePedidoById(@PathVariable int id) {
        pedidoService.deleteById(id);
        return ResponseEntity.ok("Pedido excluido");
    }
}

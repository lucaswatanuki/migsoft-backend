package migsoft.controller;

import migsoft.model.PedidoEntity;
import migsoft.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PedidoController {

    private PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("")
    public ResponseEntity<PedidoEntity> post(@RequestBody PedidoEntity pedido) {
        return ResponseEntity.ok(pedidoService.save(pedido));
    }

    @GetMapping("/all")
    public List<PedidoEntity> getAll() {
        return pedidoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoEntity> getProdutoById(@PathVariable int id) {
        return ResponseEntity.ok(pedidoService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteProdutoById(@PathVariable int id) {
        pedidoService.deleteById(id);
    }
}

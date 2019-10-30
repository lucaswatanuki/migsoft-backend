package migsoft.controller;

import migsoft.model.ClienteEntity;
import migsoft.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ClienteEntity> post(@RequestBody ClienteEntity cliente) {
        return ResponseEntity.ok(clienteService.save(cliente));
    }

    @GetMapping(value = "/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<ClienteEntity>> getAll() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ClienteEntity> getClienteById(@PathVariable("id") int id) {
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ClienteEntity> update(@PathVariable("id") int id, @RequestBody ClienteEntity cliente){
        cliente.setId(id);
        return ResponseEntity.ok(clienteService.update(cliente));
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Object> deleteClienteById(@PathVariable int id) {
        clienteService.deleteById(id);
        return ResponseEntity.ok("Cliente deletado com sucesso");
    }
}

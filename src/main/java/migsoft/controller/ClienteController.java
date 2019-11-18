package migsoft.controller;

import migsoft.model.ClienteEntity;
import migsoft.model.response.ClienteResponse;
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
    public ClienteResponse post(@RequestBody ClienteEntity cliente) {
        return clienteService.save(cliente);
    }

    @GetMapping(value = "/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<ClienteResponse> getAll() {
        return clienteService.findAll();
    }

    @GetMapping(value = "/nome/{nome}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ClienteResponse getNome(@PathVariable("nome") String nome) {
        return clienteService.findByNome(nome);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ClienteResponse getClienteById(@PathVariable("id") Integer id) {
        return clienteService.findById(id);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ClienteResponse update(@PathVariable("id") Integer id, @RequestBody ClienteEntity cliente){
        cliente.setId(id);
        return clienteService.update(cliente);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void deleteClienteById(@PathVariable int id) {
        clienteService.deleteById(id);
    }
}

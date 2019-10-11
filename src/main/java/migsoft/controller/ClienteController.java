package migsoft.controller;

import migsoft.model.ClienteEntity;
import migsoft.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @RequestMapping(method = RequestMethod.POST)
    public ClienteEntity post(@RequestBody ClienteEntity cliente){
        return clienteService.save(cliente);
    }

    @GetMapping(value = "/all")
    public List<ClienteEntity> getAll(){
        return clienteService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ClienteEntity getClienteById(@PathVariable int id){
        return clienteService.findById(id);
    }

    //Implementar PUT mapping para fazer o update!

    @DeleteMapping(value = "/{id}")
    public void deleteClienteById(@PathVariable int id){
        clienteService.deleteById(id);
    }
}

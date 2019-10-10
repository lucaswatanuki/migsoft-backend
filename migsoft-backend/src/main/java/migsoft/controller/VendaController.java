package migsoft.controller;

import migsoft.model.ItemVendaEntity;
import migsoft.model.VendaEntity;
import migsoft.service.ItemVendaService;
import migsoft.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venda")
public class VendaController {

    @Autowired
    VendaService vendaService;

    @Autowired
    ItemVendaService itemVendaService;

    @PostMapping(value = "")
    public VendaEntity postVenda(@RequestBody VendaEntity venda) {
        return vendaService.save(venda);
    }

    @PostMapping(value = "/itemvenda")
    public ItemVendaEntity postItemVenda(@RequestBody ItemVendaEntity item) {
        return itemVendaService.save(item);
    }

    @GetMapping(value = "/all")
    public List<VendaEntity> getAllVendas() {
        return vendaService.findAll();
    }

    @GetMapping(value = "/{id}")
    public VendaEntity getVendaById(@PathVariable int id) {
        return vendaService.findById(id);
    }

    @GetMapping(value = "/itemvenda")
    public List<ItemVendaEntity> getAllItems() {
        return itemVendaService.findAll();
    }

    @GetMapping(value = "itemvenda/{id}")
    public ItemVendaEntity getItemById(@PathVariable int id) {
        return itemVendaService.findById(id);
    }

    //Implementar PUT mapping para fazer o update!

    @DeleteMapping(value = "/{id}")
    public void deleteVendaById(@PathVariable int id) {
        vendaService.deleteById(id);
    }

    @DeleteMapping(value = "itemvenda/{id}")
    public void deleteItemById(@PathVariable int id) {
        itemVendaService.deleteById(id);
    }
}

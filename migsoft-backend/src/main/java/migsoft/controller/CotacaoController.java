package migsoft.controller;

import migsoft.model.CotacaoEntity;
import migsoft.service.CotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cotacao")
public class CotacaoController {

    @Autowired
    CotacaoService cotacaoService;

    @PostMapping("")
    public CotacaoEntity post(@RequestBody CotacaoEntity cotacao) {
        return cotacaoService.save(cotacao);
    }

    @GetMapping("/all")
    public List<CotacaoEntity> getAll() {
        return cotacaoService.findAll();
    }

    @GetMapping("/{id}")
    public CotacaoEntity getCotacaoById(@PathVariable int id) {
        return cotacaoService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCotacaoById(@PathVariable int id) {
        cotacaoService.deleteById(id);
    }
}

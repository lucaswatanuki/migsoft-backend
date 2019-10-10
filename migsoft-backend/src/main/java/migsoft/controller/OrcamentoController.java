package migsoft.controller;

import migsoft.model.OrcamentoEntity;
import migsoft.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orcamento")
public class OrcamentoController {

    @Autowired
    OrcamentoService orcamentoService;

    @PostMapping("")
    public OrcamentoEntity post(@RequestBody OrcamentoEntity orcamentoEntity) {
        return orcamentoService.save(orcamentoEntity);
    }

    @GetMapping("/all")
    public List<OrcamentoEntity> getAll() {
        return orcamentoService.findAll();
    }

    @GetMapping("/{id}")
    public OrcamentoEntity getOrcamentoById(@PathVariable int id) {
        return orcamentoService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrcamentoById(@PathVariable int id) {
        orcamentoService.deleteById(id);
    }
}

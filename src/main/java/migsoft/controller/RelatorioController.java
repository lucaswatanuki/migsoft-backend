package migsoft.controller;

import migsoft.controller.request.RelatorioRequest;
import migsoft.controller.response.RelatorioFinanceiroResponse;
import migsoft.controller.response.RelatorioProdutos;
import migsoft.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/relatorio")
public class RelatorioController {

    private final RelatorioService relatorioService;

    @Autowired
    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @GetMapping(value = "/financeiro")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public RelatorioFinanceiroResponse getRelatorioFinanceiro() {
        return relatorioService.extrairRelatorioFinanceiro();
    }

    @PostMapping(value = "/vendaprodutos")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<RelatorioProdutos> getAllVendasBetweenData(@RequestBody RelatorioRequest relatorioRequest) {
        return relatorioService.getRelatorioProdutos(relatorioRequest.getDataInicial(), relatorioRequest.getDataFinal(), relatorioRequest.getStatus());
    }
}

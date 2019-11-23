package migsoft.service;

import migsoft.model.response.RelatorioFinanceiroResponse;
import migsoft.model.response.RelatorioProdutos;

import java.util.Date;
import java.util.List;

public interface RelatorioService {

    public RelatorioFinanceiroResponse extrairRelatorioFinanceiro();
    public List<RelatorioProdutos> getRelatorioProdutos(Date dataInicial, Date dataFinal, String status);
}

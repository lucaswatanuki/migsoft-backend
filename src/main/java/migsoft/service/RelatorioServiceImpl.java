package migsoft.service;

import migsoft.controller.response.RelatorioFinanceiroResponse;
import migsoft.controller.response.RelatorioProdutos;
import migsoft.repository.PedidoRepository;
import migsoft.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Service
public class RelatorioServiceImpl implements RelatorioService {

    private final VendaRepository vendaRepository;
    private final PedidoRepository pedidoRepository;
    private EntityManager em;

    @Autowired
    public RelatorioServiceImpl(VendaRepository vendaRepository, PedidoRepository pedidoRepository, EntityManager entityManager) {
        this.vendaRepository = vendaRepository;
        this.pedidoRepository = pedidoRepository;
        this.em = entityManager;
    }

    @Override
    public List<RelatorioProdutos> getRelatorioProdutos(Date dataInicial, Date dataFinal, String status) {
        Query query = em.createNativeQuery("SELECT produto.nome, sum(v.quantidade) as quantidadeTotal, sum(v.total) as vendasTotal " +
                "FROM venda v INNER JOIN produto " +
                "ON v.produto_id = produto.id " +
                "WHERE v.status = :status AND v.data BETWEEN :dataInicial AND :dataFinal " +
                "GROUP BY produto.nome " +
                "ORDER BY quantidadeTotal DESC", "VendaProdutos");
        query.setParameter("status", status);
        query.setParameter("dataInicial", dataInicial);
        query.setParameter("dataFinal", dataFinal);
        List<RelatorioProdutos> relatorioProdutos = query.getResultList();
        return relatorioProdutos;
    }

    @Override
    public RelatorioFinanceiroResponse extrairRelatorioFinanceiro() {

        Double despesa = pedidoRepository.findAll().stream()
                .filter(pedido -> pedido.getStatus().contains("Entregue"))
                .mapToDouble(value -> value.getTotal()).sum();


        Double receita = vendaRepository.findAll().stream()
                .filter(venda -> venda.getStatus().contains("OK"))
                .mapToDouble(value -> value.getTotal()).sum();

        RelatorioFinanceiroResponse relatorio = new RelatorioFinanceiroResponse();
        relatorio.setDespesa(despesa);
        relatorio.setReceita(receita);
        relatorio.setLucro(receita - despesa);
        if (relatorio.getLucro() < 0) {
            relatorio.setPrejuizo(receita - despesa);
            relatorio.setLucro(0.0);
        } else relatorio.setPrejuizo(0.0);
        return relatorio;
    }

}

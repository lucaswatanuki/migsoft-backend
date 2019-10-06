package migsoft.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class CotacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double preco;
    private ProdutoEntity idProduto;
    private FornecedorEntity idFornecedor;
    private String data;
}

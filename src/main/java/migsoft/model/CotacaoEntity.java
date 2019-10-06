package migsoft.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "cotacao")
@Data
public class CotacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double preco;
    //private ProdutoEntity idProduto;
    //private FornecedorEntity idFornecedor;
    private String data;
}

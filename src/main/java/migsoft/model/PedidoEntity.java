package migsoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "pedido")
@Data
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String data;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ProdutoEntity produto;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FornecedorEntity fornecedor;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CotacaoEntity idCotacao;

    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ItemProduto> itemProdutos;

    private double total;
}

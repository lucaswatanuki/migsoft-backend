package migsoft.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@NoArgsConstructor
@Entity(name = "produto")
@Data
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Double preco;

    private Integer qtdEstoque;

    @OneToMany(mappedBy = "produto", fetch = FetchType.LAZY)
    private Set<ItemProduto> listItemVenda;

    @OneToMany(mappedBy = "produto", fetch = FetchType.LAZY)
    private Set<CotacaoEntity> listCotacao;

    @OneToMany(mappedBy = "produto", fetch = FetchType.LAZY)
    private Set<PedidoEntity> pedido;

    @ManyToMany(mappedBy = "idProduto", fetch = FetchType.LAZY)
    private Set<FormulaProdutoEntity> idFormula;
}

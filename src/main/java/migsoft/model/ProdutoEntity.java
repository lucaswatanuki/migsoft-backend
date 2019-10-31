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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String nome;

    private double preco;

    private int qtdEstoque;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ItemProduto> listItemVenda;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private EstoqueEntity estoque;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CotacaoEntity> listCotacao;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<PedidoEntity> pedido;

    @ManyToMany(mappedBy = "idProduto", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<FormulaProdutoEntity> idFormula;

    public ProdutoEntity(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}

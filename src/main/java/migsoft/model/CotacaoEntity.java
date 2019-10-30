package migsoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cotacao")
@Data
public class CotacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double preco;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ProdutoEntity produto;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FornecedorEntity fornecedor;

    @OneToMany(mappedBy = "idCotacao")
    private Set<PedidoEntity> pedido;

    private String data;
}

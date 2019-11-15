package migsoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cotacao")
@Data
public class CotacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double preco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto")
    private ProdutoEntity produto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fornecedor")
    private FornecedorEntity fornecedor;

    @OneToMany(mappedBy = "cotacao", fetch = FetchType.LAZY)
    private Set<PedidoEntity> pedido;

    private String data;

    private String data_resposta;

    private Integer quantidade;

    private Double total;

    private String status;
}

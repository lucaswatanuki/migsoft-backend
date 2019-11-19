package migsoft.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import migsoft.model.response.RelatorioProdutos;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "venda")
@Data
@SqlResultSetMapping(
        name = "VendaProdutos",
        classes = @ConstructorResult(
                targetClass = RelatorioProdutos.class,
                columns = {
                        @ColumnResult(name = "nome", type = String.class),
                        @ColumnResult(name = "quantidadeTotal", type = Integer.class),
                        @ColumnResult(name = "vendasTotal", type = Double.class)
                }
        )
)
public class VendaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name = "data")
    private Date data;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private ClienteEntity cliente;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private ProdutoEntity produto;

    private Integer quantidade;

  /*  @OneToMany(mappedBy = "venda", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ItemProduto> itemvenda;*/

    private Double total;
}

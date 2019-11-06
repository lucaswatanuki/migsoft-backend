package migsoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "venda")
@Data
public class VendaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String data;

    @ManyToOne(fetch = FetchType.LAZY)
    private ClienteEntity cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProdutoEntity produto;

    private Integer quantidade;

  /*  @OneToMany(mappedBy = "venda", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ItemProduto> itemvenda;*/

    private Double total;
}

package migsoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "itemvenda")
@Data
public class ItemVendaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantidade;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ProdutoEntity produto;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private VendaEntity venda;
}

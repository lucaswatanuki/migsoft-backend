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
    private int id;

    private String data;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ClienteEntity cliente;

    @OneToMany(mappedBy = "venda", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ItemVendaEntity> itemvenda;

    private double total;
}

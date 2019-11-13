package migsoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "pedido")
@Data
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String data;

    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cotacao")
    private CotacaoEntity cotacao;

    private Integer quantidade;

    private Double total;

    public PedidoEntity() {
    }

    public PedidoEntity(Integer id, String data, String status, CotacaoEntity cotacao, Integer quantidade, Double total) {
        this.id = id;
        this.data = data;
        this.status = status;
        this.cotacao = cotacao;
        this.quantidade = quantidade;
        this.total = total;
    }
}

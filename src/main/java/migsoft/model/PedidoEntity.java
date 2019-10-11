package migsoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private UsuarioEntity user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ProdutoEntity produto;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FornecedorEntity fornecedor;

    private double total;
}

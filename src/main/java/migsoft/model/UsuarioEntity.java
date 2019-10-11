package migsoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "usuario")
@Data
@PrimaryKeyJoinColumn(name = "id")
public class UsuarioEntity extends Pessoa{

    private String login;
    private String password;
    private String acesso;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<PedidoEntity> pedido;
}

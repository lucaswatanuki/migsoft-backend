package migsoft.model;

import lombok.*;

import javax.persistence.*;
import java.util.Scanner;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "fornecedor")
@Data
@PrimaryKeyJoinColumn(name = "id")
public class FornecedorEntity extends Pessoa {
    private String cnpj;
    private String nomeFantasia;

    @OneToMany(mappedBy = "fornecedor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CotacaoEntity> cotacao;

    @OneToMany(mappedBy = "fornecedor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<PedidoEntity> pedido;

    public FornecedorEntity(String cnpj, String nomeFantasia) {
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }
}

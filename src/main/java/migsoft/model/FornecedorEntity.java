package migsoft.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Scanner;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "fornecedor")
@Data
public class FornecedorEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cnpj;

    private String nomeFantasia;

    private boolean atividade;

    @OneToMany(mappedBy = "fornecedor", fetch = FetchType.LAZY)
    private Set<CotacaoEntity> cotacao;

    @OneToMany(mappedBy = "fornecedor", fetch = FetchType.LAZY)
    private Set<PedidoEntity> pedido;
}

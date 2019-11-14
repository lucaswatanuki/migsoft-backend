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
@PrimaryKeyJoinColumn(name = "id")
public class FornecedorEntity extends Pessoa{

    @Column(unique = true)
    private String cnpj;

    private String nomeFantasia;

    private String atividade;

    @OneToMany(mappedBy = "fornecedor", fetch = FetchType.LAZY)
    private Set<CotacaoEntity> cotacao;

}

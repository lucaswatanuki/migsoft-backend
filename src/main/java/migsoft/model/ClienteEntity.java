package migsoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cliente")
@Data
@PrimaryKeyJoinColumn(name = "id")
public class ClienteEntity extends Pessoa {

    private String tipo;

    public ClienteEntity(int id, String nome, String cpf, String telefone, String email, String endereco, String tipo) {
        super(id, nome, cpf, telefone, email, endereco);
        this.tipo = tipo;
    }
}

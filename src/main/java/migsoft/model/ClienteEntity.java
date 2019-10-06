package migsoft.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity(name = "cliente")
@Data
public class ClienteEntity extends Pessoa {
    private String tipo;

    public ClienteEntity(int id, String nome, String cpf, String telefone, String email, String endereco, String tipo) {
        super(id, nome, cpf, telefone, email, endereco);
        this.tipo = tipo;
    }

    public ClienteEntity() {
    }
}

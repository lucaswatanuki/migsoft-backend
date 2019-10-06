package migsoft.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity(name = "usuario")
@Data
public class UsuarioEntity extends Pessoa{
    private String acesso;

    public UsuarioEntity(int id, String nome, String cpf, String telefone, String email, String endereco, String acesso) {
        super(id, nome, cpf, telefone, email, endereco);
        this.acesso = acesso;
    }

    public UsuarioEntity() {
    }
}

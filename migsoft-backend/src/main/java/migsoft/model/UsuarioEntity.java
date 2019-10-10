package migsoft.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "usuario")
@Data
@PrimaryKeyJoinColumn(name = "id")
public class UsuarioEntity extends Pessoa{

    private String login;
    private String password;
    private String acesso;

    public UsuarioEntity(int id, String nome, String cpf, String telefone, String email, String endereco, String login, String password, String acesso) {
        super(id, nome, cpf, telefone, email, endereco);
        this.login = login;
        this.password = password;
        this.acesso = acesso;
    }

    public UsuarioEntity() {
    }
}

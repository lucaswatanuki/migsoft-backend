package migsoft.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Data
public class FornecedorEntity extends Pessoa {
    private String cnpj;
    private String nomeFantasia;

    public FornecedorEntity(int id, String nome, String cpf, String telefone, String email, String endereco, String cnpj, String nomeFantasia) {
        super(id, nome, cpf, telefone, email, endereco);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }
}

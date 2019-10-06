package migsoft;

import migsoft.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "migsoft.repository")
@ComponentScan(basePackageClasses = {ClienteEntity.class, CotacaoEntity.class, EstoqueEntity.class, FornecedorEntity.class, Pessoa.class, ItemVendaEntity.class, LocalizacaoEntity.class, OrcamentoEntity.class, ProdutoEntity.class, UsuarioEntity.class, VendaEntity.class})
@SpringBootApplication
public class ApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }
}

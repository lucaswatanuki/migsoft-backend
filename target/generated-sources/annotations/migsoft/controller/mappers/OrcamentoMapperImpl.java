package migsoft.controller.mappers;

import javax.annotation.Generated;
import migsoft.controller.response.OrcamentoResponse;
import migsoft.model.ClienteEntity;
import migsoft.model.OrcamentoEntity;
import migsoft.model.ProdutoEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-29T16:28:52-0200",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_212 (Oracle Corporation)"
)
@Component
public class OrcamentoMapperImpl implements OrcamentoMapper {

    @Override
    public OrcamentoResponse toOrcamentoResponse(OrcamentoEntity orcamentoEntity) {
        if ( orcamentoEntity == null ) {
            return null;
        }

        OrcamentoResponse orcamentoResponse = new OrcamentoResponse();

        String nome = orcamentoEntityProdutoNome( orcamentoEntity );
        if ( nome != null ) {
            orcamentoResponse.setProduto( nome );
        }
        String nome1 = orcamentoEntityClienteNome( orcamentoEntity );
        if ( nome1 != null ) {
            orcamentoResponse.setCliente( nome1 );
        }
        orcamentoResponse.setId( orcamentoEntity.getId() );
        orcamentoResponse.setData( orcamentoEntity.getData() );
        orcamentoResponse.setQuantidade( orcamentoEntity.getQuantidade() );
        orcamentoResponse.setTotal( orcamentoEntity.getTotal() );

        return orcamentoResponse;
    }

    private String orcamentoEntityProdutoNome(OrcamentoEntity orcamentoEntity) {
        if ( orcamentoEntity == null ) {
            return null;
        }
        ProdutoEntity produto = orcamentoEntity.getProduto();
        if ( produto == null ) {
            return null;
        }
        String nome = produto.getNome();
        if ( nome == null ) {
            return null;
        }
        return nome;
    }

    private String orcamentoEntityClienteNome(OrcamentoEntity orcamentoEntity) {
        if ( orcamentoEntity == null ) {
            return null;
        }
        ClienteEntity cliente = orcamentoEntity.getCliente();
        if ( cliente == null ) {
            return null;
        }
        String nome = cliente.getNome();
        if ( nome == null ) {
            return null;
        }
        return nome;
    }
}

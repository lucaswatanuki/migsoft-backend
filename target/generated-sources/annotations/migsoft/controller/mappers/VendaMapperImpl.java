package migsoft.controller.mappers;

import javax.annotation.Generated;
import migsoft.controller.response.VendaResponse;
import migsoft.model.ClienteEntity;
import migsoft.model.ProdutoEntity;
import migsoft.model.VendaEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-29T16:28:52-0200",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_212 (Oracle Corporation)"
)
@Component
public class VendaMapperImpl implements VendaMapper {

    @Override
    public VendaResponse toVendaResponse(VendaEntity vendaEntity) {
        if ( vendaEntity == null ) {
            return null;
        }

        VendaResponse vendaResponse = new VendaResponse();

        String nome = vendaEntityProdutoNome( vendaEntity );
        if ( nome != null ) {
            vendaResponse.setProduto( nome );
        }
        String nome1 = vendaEntityClienteNome( vendaEntity );
        if ( nome1 != null ) {
            vendaResponse.setCliente( nome1 );
        }
        vendaResponse.setId( vendaEntity.getId() );
        vendaResponse.setData( vendaEntity.getData() );
        vendaResponse.setQuantidade( vendaEntity.getQuantidade() );
        vendaResponse.setTotal( vendaEntity.getTotal() );
        vendaResponse.setStatus( vendaEntity.getStatus() );

        return vendaResponse;
    }

    private String vendaEntityProdutoNome(VendaEntity vendaEntity) {
        if ( vendaEntity == null ) {
            return null;
        }
        ProdutoEntity produto = vendaEntity.getProduto();
        if ( produto == null ) {
            return null;
        }
        String nome = produto.getNome();
        if ( nome == null ) {
            return null;
        }
        return nome;
    }

    private String vendaEntityClienteNome(VendaEntity vendaEntity) {
        if ( vendaEntity == null ) {
            return null;
        }
        ClienteEntity cliente = vendaEntity.getCliente();
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

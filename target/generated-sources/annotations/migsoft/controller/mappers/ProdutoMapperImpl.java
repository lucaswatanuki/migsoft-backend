package migsoft.controller.mappers;

import javax.annotation.Generated;
import migsoft.controller.request.ProdutoRequest;
import migsoft.controller.response.ProdutoResponse;
import migsoft.model.ProdutoEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-29T16:28:53-0200",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_212 (Oracle Corporation)"
)
@Component
public class ProdutoMapperImpl implements ProdutoMapper {

    @Override
    public ProdutoResponse toProdutoResponse(ProdutoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ProdutoResponse produtoResponse = new ProdutoResponse();

        produtoResponse.setQtdEstoqueProduto( entity.getQtdEstoque() );
        produtoResponse.setIdProduto( entity.getId() );
        if ( entity.getPreco() != null ) {
            produtoResponse.setPrecoProduto( entity.getPreco() );
        }
        produtoResponse.setNomeProduto( entity.getNome() );

        return produtoResponse;
    }

    @Override
    public ProdutoEntity toProdutoEntity(ProdutoRequest request) {
        if ( request == null ) {
            return null;
        }

        ProdutoEntity produtoEntity = new ProdutoEntity();

        produtoEntity.setNome( request.getNome() );
        produtoEntity.setPreco( request.getPreco() );
        produtoEntity.setQtdEstoque( request.getQtdEstoque() );

        return produtoEntity;
    }
}

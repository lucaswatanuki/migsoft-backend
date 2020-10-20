package migsoft.controller.mappers;

import javax.annotation.Generated;
import migsoft.controller.request.CotacaoRequest;
import migsoft.controller.response.CotacaoResponse;
import migsoft.model.CotacaoEntity;
import migsoft.model.FornecedorEntity;
import migsoft.model.ProdutoEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-20T12:19:48-0300",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 11.0.7 (Oracle Corporation)"
)
@Component
public class CotacaoMapperImpl implements CotacaoMapper {

    @Override
    public CotacaoEntity toCotacaoEntity(CotacaoRequest cotacaoRequest) {
        if ( cotacaoRequest == null ) {
            return null;
        }

        CotacaoEntity cotacaoEntity = new CotacaoEntity();

        cotacaoEntity.setFornecedor( cotacaoRequestToFornecedorEntity( cotacaoRequest ) );
        cotacaoEntity.setProduto( cotacaoRequestToProdutoEntity( cotacaoRequest ) );
        cotacaoEntity.setData( cotacaoRequest.getData() );
        cotacaoEntity.setQuantidade( cotacaoRequest.getQuantidade() );
        cotacaoEntity.setStatus( cotacaoRequest.getStatus() );

        return cotacaoEntity;
    }

    @Override
    public CotacaoResponse toCotacaoResponse(CotacaoEntity cotacaoEntity) {
        if ( cotacaoEntity == null ) {
            return null;
        }

        CotacaoResponse cotacaoResponse = new CotacaoResponse();

        String nome = cotacaoEntityFornecedorNome( cotacaoEntity );
        if ( nome != null ) {
            cotacaoResponse.setFornecedor( nome );
        }
        cotacaoResponse.setId( cotacaoEntity.getId() );
        String nome1 = cotacaoEntityProdutoNome( cotacaoEntity );
        if ( nome1 != null ) {
            cotacaoResponse.setProduto( nome1 );
        }
        cotacaoResponse.setData( cotacaoEntity.getData() );
        cotacaoResponse.setData_resposta( cotacaoEntity.getData_resposta() );
        cotacaoResponse.setQuantidade( cotacaoEntity.getQuantidade() );
        cotacaoResponse.setTotal( cotacaoEntity.getTotal() );
        cotacaoResponse.setStatus( cotacaoEntity.getStatus() );

        return cotacaoResponse;
    }

    protected FornecedorEntity cotacaoRequestToFornecedorEntity(CotacaoRequest cotacaoRequest) {
        if ( cotacaoRequest == null ) {
            return null;
        }

        FornecedorEntity fornecedorEntity = new FornecedorEntity();

        fornecedorEntity.setNome( cotacaoRequest.getFornecedor() );

        return fornecedorEntity;
    }

    protected ProdutoEntity cotacaoRequestToProdutoEntity(CotacaoRequest cotacaoRequest) {
        if ( cotacaoRequest == null ) {
            return null;
        }

        ProdutoEntity produtoEntity = new ProdutoEntity();

        produtoEntity.setNome( cotacaoRequest.getProduto() );

        return produtoEntity;
    }

    private String cotacaoEntityFornecedorNome(CotacaoEntity cotacaoEntity) {
        if ( cotacaoEntity == null ) {
            return null;
        }
        FornecedorEntity fornecedor = cotacaoEntity.getFornecedor();
        if ( fornecedor == null ) {
            return null;
        }
        String nome = fornecedor.getNome();
        if ( nome == null ) {
            return null;
        }
        return nome;
    }

    private String cotacaoEntityProdutoNome(CotacaoEntity cotacaoEntity) {
        if ( cotacaoEntity == null ) {
            return null;
        }
        ProdutoEntity produto = cotacaoEntity.getProduto();
        if ( produto == null ) {
            return null;
        }
        String nome = produto.getNome();
        if ( nome == null ) {
            return null;
        }
        return nome;
    }
}

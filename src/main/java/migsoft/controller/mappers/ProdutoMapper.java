package migsoft.controller.mappers;

import migsoft.controller.request.ProdutoRequest;
import migsoft.controller.response.ProdutoResponse;
import migsoft.model.ProdutoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    @Mappings({
            @Mapping(source = "entity.id", target = "idProduto"),
            @Mapping(source = "entity.nome", target = "nomeProduto"),
            @Mapping(source = "entity.preco", target = "precoProduto"),
            @Mapping(source = "entity.qtdEstoque", target = "qtdEstoqueProduto")
    })
    ProdutoResponse toProdutoResponse(ProdutoEntity entity);

    ProdutoEntity toProdutoEntity(ProdutoRequest request);
}

package migsoft.controller.mappers;

import migsoft.controller.request.CotacaoRequest;
import migsoft.controller.response.CotacaoResponse;
import migsoft.model.CotacaoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CotacaoMapper {
    @Mappings({
            @Mapping(source = "cotacaoRequest.produto", target = "produto.nome"),
            @Mapping(source = "cotacaoRequest.fornecedor", target = "fornecedor.nome")
    })
    CotacaoEntity toCotacaoEntity(CotacaoRequest cotacaoRequest);

    @Mappings({
            @Mapping(source = "cotacaoEntity.produto.nome", target = "produto"),
            @Mapping(source = "cotacaoEntity.fornecedor.nome", target = "fornecedor"),
            @Mapping(source = "cotacaoEntity.id", target = "id")
    })
    CotacaoResponse toCotacaoResponse(CotacaoEntity cotacaoEntity);

}

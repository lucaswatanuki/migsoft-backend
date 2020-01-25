package migsoft.controller.mappers;

import migsoft.controller.response.OrcamentoResponse;
import migsoft.model.OrcamentoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface OrcamentoMapper {
    @Mappings({
            @Mapping(source="orcamentoEntity.produto.nome", target = "produto"),
            @Mapping(source="orcamentoEntity.cliente.nome", target = "cliente")
    })
    OrcamentoResponse toOrcamentoResponse(OrcamentoEntity orcamentoEntity);
}

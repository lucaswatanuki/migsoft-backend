package migsoft.controller.mappers;

import migsoft.controller.response.VendaResponse;
import migsoft.model.VendaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface VendaMapper {
    @Mappings({
            @Mapping(source = "vendaEntity.produto.nome", target = "produto"),
            @Mapping(source = "vendaEntity.cliente.nome", target = "cliente")
    })
    VendaResponse toVendaResponse(VendaEntity vendaEntity);

}

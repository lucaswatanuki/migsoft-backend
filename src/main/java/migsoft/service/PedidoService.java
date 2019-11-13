package migsoft.service;

import migsoft.model.PedidoEntity;
import migsoft.model.request.PedidoRequest;
import migsoft.model.response.PedidoResponse;
import migsoft.model.response.ProdutoResponse;

import java.util.List;

public interface PedidoService {
    PedidoResponse findById(Integer id);
    List<PedidoResponse> findAll();
    PedidoResponse save(PedidoRequest pedido);
    PedidoResponse update(PedidoEntity pedido);
    void deleteById(Integer id);
}

package migsoft.service;

import migsoft.controller.request.PedidoRequest;
import migsoft.controller.response.PedidoResponse;

import java.util.List;

public interface PedidoService {
    PedidoResponse findById(Integer id);
    PedidoResponse updateStatus(Integer id);
    PedidoResponse cancel(Integer id);
    List<PedidoResponse> findAll();
    PedidoResponse save(PedidoRequest pedido);
    PedidoResponse update(Integer id, PedidoRequest pedido);
    void deleteById(Integer id);
}

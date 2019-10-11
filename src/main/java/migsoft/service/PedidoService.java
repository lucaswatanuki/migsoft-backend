package migsoft.service;

import migsoft.model.PedidoEntity;

import java.util.List;

public interface PedidoService {
    PedidoEntity findById(int id);
    List<PedidoEntity> findAll();
    PedidoEntity save(PedidoEntity pedido);
    PedidoEntity update(PedidoEntity produto);
    void deleteById(int id);
}

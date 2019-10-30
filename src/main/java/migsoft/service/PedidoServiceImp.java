package migsoft.service;

import migsoft.model.PedidoEntity;
import migsoft.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImp implements PedidoService{

    private PedidoRepository pedidoRepository;

    @Autowired
    public PedidoServiceImp(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public PedidoEntity findById(int id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public List<PedidoEntity> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public PedidoEntity save(PedidoEntity pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public PedidoEntity update(PedidoEntity pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void deleteById(int id) {
        pedidoRepository.delete(pedidoRepository.findById(id));
    }
}

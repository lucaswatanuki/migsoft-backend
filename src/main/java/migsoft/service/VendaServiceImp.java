package migsoft.service;

import migsoft.model.VendaEntity;
import migsoft.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaServiceImp implements VendaService {

    private final VendaRepository vendaRepository;

    @Autowired
    public VendaServiceImp(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    @Override
    public VendaEntity findById(int id) {
        return vendaRepository.findById(id);
    }

    @Override
    public List<VendaEntity> findAll() {
        return vendaRepository.findAll();
    }

    @Override
    public VendaEntity save(VendaEntity venda) {
        return vendaRepository.save(venda);
    }

    @Override
    public VendaEntity update(VendaEntity venda) {
        return null;
    }
}

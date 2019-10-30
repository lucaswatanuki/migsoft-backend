package migsoft.service;

import migsoft.model.OrcamentoEntity;
import migsoft.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrcamentoServiceImp implements OrcamentoService {

    private final OrcamentoRepository orcamentoRepository;

    @Autowired
    public OrcamentoServiceImp(OrcamentoRepository orcamentoRepository) {
        this.orcamentoRepository = orcamentoRepository;
    }

    @Override
    public OrcamentoEntity findById(int id) {
        return orcamentoRepository.findById(id);
    }

    @Override
    public List<OrcamentoEntity> findAll() {
        return orcamentoRepository.findAll();
    }

    @Override
    public OrcamentoEntity save(OrcamentoEntity orcamento) {
        return orcamentoRepository.save(orcamento);
    }

    @Override
    public OrcamentoEntity update(OrcamentoEntity orcamento) {
        return orcamentoRepository.save(orcamento);
    }

    @Override
    public void deleteById(int id) {
        orcamentoRepository.delete(orcamentoRepository.findById(id));
    }
}

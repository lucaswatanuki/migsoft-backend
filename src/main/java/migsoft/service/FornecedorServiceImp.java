package migsoft.service;

import migsoft.model.FornecedorEntity;
import migsoft.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorServiceImp implements FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    @Autowired
    public FornecedorServiceImp(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    @Override
    public FornecedorEntity findById(int id) {
        return fornecedorRepository.findById(id);
    }

    @Override
    public FornecedorEntity findByNomeFantasia(String nomeFantasia) {
        FornecedorEntity filtered = new FornecedorEntity();
        for (FornecedorEntity fornecedor: fornecedorRepository.findAll()){
            if (fornecedor == null){
                System.out.println("Fornecedor nao cadastrado");
            }
            else if (fornecedor.getNomeFantasia().equals(nomeFantasia)){
                filtered = fornecedor;
            }
        }
        return filtered;
    }

    @Override
    public FornecedorEntity findByCnpj(String cnpj) {
        FornecedorEntity filtered = new FornecedorEntity();
        for (FornecedorEntity fornecedor: fornecedorRepository.findAll()){
            if (fornecedor == null){
                System.out.println("Fornecedor nao cadastrado");
            }
            else if (fornecedor.getCnpj().equals(cnpj)){
                filtered = fornecedor;
            }
        }
        return filtered;
    }

    @Override
    public List<FornecedorEntity> findAll() {
        return fornecedorRepository.findAll();
    }

    @Override
    public FornecedorEntity save(FornecedorEntity fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    @Override
    public FornecedorEntity update(FornecedorEntity fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    @Override
    public void deleteById(int id) {
        fornecedorRepository.delete(fornecedorRepository.findById(id));
    }
}

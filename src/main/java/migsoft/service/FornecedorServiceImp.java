package migsoft.service;

import migsoft.model.FornecedorEntity;
import migsoft.model.response.FornecedorResponse;
import migsoft.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FornecedorServiceImp implements FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    @Autowired
    public FornecedorServiceImp(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    @Override
    public FornecedorResponse findById(Integer id) {
        return entitytoResponseConverter(fornecedorRepository.findById(id).orElse(null));
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
    public List<FornecedorResponse> findAll() {
        ArrayList<FornecedorResponse> fornecedorResponses = new ArrayList<>();
        for (FornecedorEntity fornecedorEntity : fornecedorRepository.findAll()){
            FornecedorResponse fornecedorResponse = new FornecedorResponse();
            fornecedorResponse = entitytoResponseConverter(fornecedorEntity);
            fornecedorResponses.add(fornecedorResponse);
        }
        return fornecedorResponses;
    }

    @Override
    public FornecedorResponse save(FornecedorEntity fornecedor) {
        FornecedorResponse fornecedorResponse = entitytoResponseConverter(fornecedorRepository.save(fornecedor));
        return fornecedorResponse;
    }

    @Override
    public FornecedorResponse update(FornecedorEntity fornecedor) {
        FornecedorResponse fornecedorResponse = entitytoResponseConverter(fornecedorRepository.save(fornecedor));
        return fornecedorResponse;
    }

    @Override
    public void deleteById(Integer id) {
        fornecedorRepository.deleteById(id);
    }

    public FornecedorResponse entitytoResponseConverter(FornecedorEntity fornecedorEntity){
        FornecedorResponse fornecedorResponse = new FornecedorResponse();
        fornecedorResponse.setId(fornecedorEntity.getId());
        fornecedorResponse.setCnpj(fornecedorEntity.getCnpj());
        fornecedorResponse.setNomeFantasia(fornecedorEntity.getNomeFantasia());

        return fornecedorResponse;
    }
}

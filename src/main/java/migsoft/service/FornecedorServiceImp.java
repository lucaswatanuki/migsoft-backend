package migsoft.service;

import migsoft.model.FornecedorEntity;
import migsoft.controller.response.FornecedorResponse;
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
    public FornecedorResponse findByNomeFantasia(String nome) {
        return entitytoResponseConverter(fornecedorRepository.findByNomeFantasia(nome));
    }

    @Override
    public List<FornecedorResponse> findAll() {
        List<FornecedorResponse> fornecedorResponses = new ArrayList<>();
        fornecedorRepository.findAll().forEach(fornecedorEntity -> {
            FornecedorResponse fornecedorResponse = entitytoResponseConverter(fornecedorEntity);
            fornecedorResponses.add(fornecedorResponse);
        });
        return fornecedorResponses;
    }

    @Override
    public List<FornecedorResponse> findAllActive() {
        List<FornecedorResponse> fornecedorResponses = new ArrayList<>();
        fornecedorRepository.findAll().stream().filter(fornecedor -> fornecedor.getAtividade().contains("Ativo"))
                .forEach(fornecedorEntity -> {
                    FornecedorResponse fornecedorResponse = entitytoResponseConverter(fornecedorEntity);
                    fornecedorResponses.add(fornecedorResponse);
                });
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

    public FornecedorResponse entitytoResponseConverter(FornecedorEntity fornecedorEntity) {
        FornecedorResponse fornecedorResponse = new FornecedorResponse();
        fornecedorResponse.setId(fornecedorEntity.getId());
        fornecedorResponse.setCnpj(fornecedorEntity.getCnpj());
        fornecedorResponse.setNomeFantasia(fornecedorEntity.getNomeFantasia());
        fornecedorResponse.setAtividade(fornecedorEntity.getAtividade());
        fornecedorResponse.setTelefone(fornecedorEntity.getTelefone());
        fornecedorResponse.setNome(fornecedorEntity.getNome());
        fornecedorResponse.setEmail(fornecedorEntity.getEmail());
        fornecedorResponse.setCpf(fornecedorEntity.getCpf());
        fornecedorResponse.setEndereco(fornecedorEntity.getEndereco());
        return fornecedorResponse;
    }
}

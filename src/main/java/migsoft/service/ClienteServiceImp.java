package migsoft.service;

import migsoft.exceptions.ClienteInexistenteException;
import migsoft.model.ClienteEntity;
import migsoft.controller.response.ClienteResponse;
import migsoft.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService{

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImp(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteResponse findById(Integer id) {
        return entitytoResponseConverter(clienteRepository.findById(id).orElse(null));
    }

    @Override
    public ClienteResponse findByNome(String nome) {
        if (clienteRepository.findByNome(nome) == null){
            throw new ClienteInexistenteException("Cliente não cadastrado");
        }
        ClienteResponse response = entitytoResponseConverter(clienteRepository.findByNome(nome));
        return response;
    }

    @Override
    public List<ClienteResponse> findAll() {
        List<ClienteResponse> clienteResponses = new ArrayList<>();
        clienteRepository.findAll().forEach(clienteEntity -> {
            ClienteResponse clienteResponse = entitytoResponseConverter(clienteEntity);
            clienteResponses.add(clienteResponse);
        });
        return clienteResponses;
    }

    @Override
    public ClienteResponse save(ClienteEntity cliente) {
        ClienteResponse clienteResponse = entitytoResponseConverter(clienteRepository.save(cliente));
        return clienteResponse;
    }

    @Override
    public ClienteResponse update(ClienteEntity cliente) {
        ClienteResponse clienteResponse = entitytoResponseConverter(clienteRepository.save(cliente));
        return clienteResponse;
    }

    @Override
    public void deleteById(Integer id) {
        clienteRepository.deleteById(id);
    }

    public ClienteResponse entitytoResponseConverter(ClienteEntity clienteEntity){
        ClienteResponse clienteResponse = new ClienteResponse();
        clienteResponse.setId(clienteEntity.getId());
        clienteResponse.setTipo(clienteEntity.getTipo());
        clienteResponse.setCpf(clienteEntity.getCpf());
        clienteResponse.setNome(clienteEntity.getNome());
        clienteResponse.setEmail(clienteEntity.getEmail());
        clienteResponse.setEndereco(clienteEntity.getEndereco());
        clienteResponse.setTelefone(clienteEntity.getTelefone());
        return clienteResponse;
    }
}

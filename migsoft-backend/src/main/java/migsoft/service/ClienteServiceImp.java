package migsoft.service;

import migsoft.model.ClienteEntity;
import migsoft.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService{

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImp(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteEntity findById(int id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<ClienteEntity> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public ClienteEntity save(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public ClienteEntity update(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
        //Implementar o response
    }

    @Override
    public void deleteById(int id) {
        clienteRepository.delete(clienteRepository.findById(id));
    }
}

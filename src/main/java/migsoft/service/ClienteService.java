package migsoft.service;

import migsoft.model.ClienteEntity;
import migsoft.controller.response.ClienteResponse;

import java.util.List;

public interface ClienteService{
     ClienteResponse findById(Integer id);
     ClienteResponse findByNome(String nome);
     List<ClienteResponse> findAll();
     ClienteResponse save(ClienteEntity cliente);
     ClienteResponse update(ClienteEntity cliente);
     void deleteById(Integer id);
}

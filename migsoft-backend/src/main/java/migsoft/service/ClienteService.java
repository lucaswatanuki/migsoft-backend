package migsoft.service;

import migsoft.model.ClienteEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClienteService{
     ClienteEntity findById(int id);
 //    ClienteEntity findByName(String nome);
     List<ClienteEntity> findAll();
     ClienteEntity save(ClienteEntity cliente);
     ClienteEntity update(ClienteEntity cliente);
     void deleteById(int id);
}

package migsoft.service;

import migsoft.model.VendaEntity;
import migsoft.model.response.VendaResponse;
import migsoft.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class VendaServiceImp implements VendaService {

    private final VendaRepository vendaRepository;

    @Autowired
    public VendaServiceImp(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    @Override
    public VendaResponse findById(Integer id) {
        return entitytoResponseConverter(vendaRepository.findById(id).orElse(null));
    }

    @Override
    public List<VendaResponse> findAll() {
        ArrayList<VendaResponse> vendaResponses = new ArrayList<>();
        for (VendaEntity vendaEntity: vendaRepository.findAll()){
            VendaResponse vendaResponse = new VendaResponse();
            vendaResponse = entitytoResponseConverter(vendaEntity);
            vendaResponses.add(vendaResponse);
        }
        return vendaResponses;
    }

    @Override
    public VendaResponse save(VendaEntity venda) {
        venda.setTotal(venda.getQuantidade() * venda.getProduto().getPreco());
        dateConverter(venda);
        VendaResponse vendaResponse = entitytoResponseConverter(vendaRepository.save(venda));
        return vendaResponse;
    }

    @Override
    public VendaResponse update(VendaEntity venda) {
        venda.setTotal(venda.getQuantidade() * venda.getProduto().getPreco());
        VendaResponse vendaResponse = entitytoResponseConverter(vendaRepository.save(venda));
        return vendaResponse;
    }

    public VendaResponse entitytoResponseConverter(VendaEntity vendaEntity) {
        VendaResponse vendaResponse = new VendaResponse();
        vendaResponse.setId(vendaEntity.getId());
        vendaResponse.setCliente(vendaEntity.getCliente().getNome());
        vendaResponse.setQuantidade(vendaEntity.getQuantidade());
        vendaResponse.setTotal(vendaEntity.getTotal());
        vendaResponse.setProduto(vendaEntity.getProduto().getNome());
        vendaResponse.setData(vendaEntity.getData());
        return vendaResponse;
    }

    public void dateConverter(VendaEntity venda){
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(venda.getData(), inputFormatter);
        String formattedDate = outputFormatter.format(date);
        venda.setData(formattedDate);
    }
}

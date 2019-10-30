package controller;

import migsoft.controller.ClienteController;
import migsoft.model.ClienteEntity;
import migsoft.service.ClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientesControllerTest {

    @InjectMocks
    private ClienteController clienteController;

    @Mock
    private ClienteService clienteService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddClienteSuccess() throws Exception {
        ClienteEntity cliente = new ClienteEntity(
                1,
                "teste",
                "111.111.111-11",
                "19 9 8920 2049",
                "teste@hotmail.com",
                "R. Teste",
                "admin"
        );
        when(clienteService.save(cliente)).thenReturn(cliente);
        ClienteEntity clienteResp = clienteService.save(cliente);
        Assert.assertTrue(clienteResp.getId() == cliente.getId());
    }

    @Test
    public void testUpdateClienteSuccess(){
        ClienteEntity cliente = new ClienteEntity(
                1,
                "teste",
                "111.111.111-11",
                "19 9 8920 2049",
                "teste@hotmail.com",
                "R. Teste",
                "admin"
        );
        when(clienteService.findById(anyInt())).thenReturn(cliente);
        when(clienteService.save(cliente)).thenReturn(cliente);
        ClienteEntity clienteResp = clienteService.save(cliente);
        Assert.assertTrue(clienteResp.getId() == cliente.getId());
    }



    @Test
    public void testDeleteClienteSuccess(){
        ClienteEntity cliente = new ClienteEntity(
                1,
                "teste",
                "111.111.111-11",
                "19 9 8920 2049",
                "teste@hotmail.com",
                "R. Teste",
                "admin"
        );
        when(clienteService.findById(cliente.getId())).thenReturn(cliente);
        clienteController.deleteClienteById(cliente.getId());
        verify(clienteService).deleteById(cliente.getId());

    }
}

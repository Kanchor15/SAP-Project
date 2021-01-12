package Okan.Project.services;

import Okan.Project.commands.ClientForm;
import Okan.Project.converters.ClientFormToClient;
import Okan.Project.entities.Client;
import Okan.Project.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService
{
    private final ClientRepository clientRepository;
    private final ClientFormToClient clientFormToClient;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ClientFormToClient clientFormToClient)
    {
        this.clientRepository = clientRepository;
        this.clientFormToClient = clientFormToClient;
    }
    @Override
    public List<Client> listAll()
    {
        return (List<Client>) clientRepository.findAll();
    }
    @Override
    public Client getById(Long id)
    {
        return clientRepository.findById(id).orElse(null);
    }
    @Override
    public Client saveOrUpdate(Client client)
    {
        clientRepository.save(client);
        return client;
    }
    @Override
    public void delete(Long id)
    {
        clientRepository.deleteById(id);

    }
    @Override
    public Client saveOrUpdateClientForm(ClientForm clientForm)
    {
        return saveOrUpdate(clientFormToClient.convert(clientForm));
    }
}
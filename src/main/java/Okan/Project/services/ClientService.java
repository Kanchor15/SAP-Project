package Okan.Project.services;

import Okan.Project.commands.ClientForm;
import Okan.Project.entities.Client;
import java.util.List;

public interface ClientService
{
    List<Client> listAll();

    Client getById(Long id);

    Client saveOrUpdate(Client client);

    void delete(Long id);

    Client saveOrUpdateClientForm(ClientForm clientForm);
}

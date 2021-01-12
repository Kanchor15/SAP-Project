package Okan.Project.converters;

import Okan.Project.commands.ClientForm;
import Okan.Project.entities.Client;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ClientFormToClient implements Converter<ClientForm, Client>
{
    @Override
    public Client convert(ClientForm clientForm)
    {
        Client client = new Client();
        if (clientForm.getId() != null  && !StringUtils.isEmpty(clientForm.getId()))
        {
            client.setId(clientForm.getId());
        }
        client.setName(clientForm.getName());
        return client;
    }
}

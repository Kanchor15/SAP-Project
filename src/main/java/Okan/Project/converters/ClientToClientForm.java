package Okan.Project.converters;

import Okan.Project.commands.ClientForm;
import Okan.Project.entities.Client;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClientToClientForm implements Converter<Client, ClientForm>
{
    @Override
    public ClientForm convert(Client client)
    {
        ClientForm clientForm= new ClientForm();
        clientForm.setId(client.getId());
        clientForm.setName(client.getName());
        return clientForm;
    }
    @Override
    public JavaType getInputType(TypeFactory typeFactory)
    {
        return null;
    }
    @Override
    public JavaType getOutputType(TypeFactory typeFactory)
    {
        return null;
    }
}
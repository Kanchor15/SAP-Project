package Okan.Project.controllers;

import Okan.Project.commands.ClientForm;
import Okan.Project.converters.ClientToClientForm;
import Okan.Project.entities.Client;
import Okan.Project.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;

@CrossOrigin
@Controller
public class ClientController
{
    private ClientService clientService;
    private ClientToClientForm clientToClientForm;

    @Autowired
    public void setClientToClientForm(ClientToClientForm clientToClientForm)
    {
        this.clientToClientForm = clientToClientForm;
    }

    @Autowired
    public void setClientService(ClientService clientService)
    {
        this.clientService = clientService;
    }

    @RequestMapping({"/client/list", "/client"})
    public String listClients(Model model)
    {
        model.addAttribute("clients", clientService.listAll());
        return "/client/list";
    }

    @RequestMapping("/client/show/{id}")
    public String getClient(@PathVariable String id, Model model)
    {
        model.addAttribute("client", clientService.getById(Long.valueOf(id)));
        return "/client/show";
    }

    @RequestMapping("/client/edit/{id}")
    public String edit(@PathVariable String id, Model model)
    {
        Long editId = Long.valueOf(id);
        Client client = clientService.getById(Long.valueOf(id));
        ClientForm clientForm = clientToClientForm.convert(client);
        model.addAttribute("clientForm", clientForm);
        clientService.delete(editId);
        return "/client/clientform";
    }

    @RequestMapping("/client/new")
    public String newClient(Model model)
    {
        model.addAttribute("clientForm", new ClientForm());
        return "/client/clientform";
    }

    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public String saveOrUpdateClient(@Valid ClientForm clientForm, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "/client/clientform";
        }
        Client savedClient = clientService.saveOrUpdateClientForm(clientForm);
        return "redirect:/client/show/" + savedClient.getId();
    }

    @RequestMapping("/client/delete/{id}")
    public String delete(@PathVariable String id)
    {
        clientService.delete(Long.valueOf(id));
        return "redirect:/client/list";
    }
}
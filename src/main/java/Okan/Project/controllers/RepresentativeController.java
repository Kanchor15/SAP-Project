package Okan.Project.controllers;

import Okan.Project.commands.RepresentativeForm;
import Okan.Project.converters.RepresentativeToRepresentativeForm;
import Okan.Project.entities.Representative;
import Okan.Project.services.RepresentativeService;
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
public class RepresentativeController
{
    private RepresentativeService representativeService;
    private RepresentativeToRepresentativeForm representativeToRepresentativeForm;

    @Autowired
    public void setRepresentativeToRepresentativeForm(RepresentativeToRepresentativeForm representativeToRepresentativeForm)
    {
        this.representativeToRepresentativeForm = representativeToRepresentativeForm;
    }

    @Autowired
    public void setRepresentativeService(RepresentativeService representativeService)
    {
        this.representativeService = representativeService;
    }

    @RequestMapping({"/representative/list", "/representative"})
    public String listRepresentatives(Model model)
    {
        model.addAttribute("representatives", representativeService.listAll());
        return "/representative/list";
    }

    @RequestMapping("/representative/show/{id}")
    public String getRepresentative(@PathVariable String id,Model model)
    {
        model.addAttribute("representative", representativeService.getById(Long.valueOf(id)));
        return "/representative/show";
    }

    @RequestMapping("/representative/edit/{id}")
    public String edit(@PathVariable String id, Model model)
    {
        Long editId = Long.valueOf(id);
        Representative representative = representativeService.getById(Long.valueOf(id));
        RepresentativeForm representativeForm = representativeToRepresentativeForm.convert(representative);
        model.addAttribute("representativeForm", representativeForm);
        representativeService.delete(editId);
        return "/representative/representativeform";
    }

    @RequestMapping("/representative/new")
    public String newRepresentative(Model model)
    {
        model.addAttribute("representativeForm", new RepresentativeForm());
        return "/representative/representativeform";
    }

    @RequestMapping(value = "/representative", method = RequestMethod.POST)
    public String saveOrUpdateRepresentative(@Valid RepresentativeForm representativeForm, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "/representative/representativeform";
        }
        Representative savedRepresentative = representativeService.saveOrUpdateRepresentativeForm(representativeForm);
        return "redirect:/representative/show/" + savedRepresentative.getId();
    }

    @RequestMapping("/representative/delete/{id}")
    public String delete(@PathVariable String id)
    {
        representativeService.delete(Long.valueOf(id));
        return "redirect:/representative/list";
    }
}
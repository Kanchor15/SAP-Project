package Okan.Project.controllers;

import Okan.Project.commands.SaleForm;
import Okan.Project.converters.SaleToSaleForm;
import Okan.Project.entities.Sale;
import Okan.Project.repositories.ClientRepository;
import Okan.Project.repositories.ProductRepository;
import Okan.Project.repositories.RepresentativeRepository;
import Okan.Project.services.SaleService;
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
public class SaleController
{
    private SaleService saleService;
    private SaleToSaleForm saleToSaleForm;

    @Autowired
    public void setSaleToSaleForm(SaleToSaleForm saleToSaleForm)
    {
        this.saleToSaleForm = saleToSaleForm;
    }

    @Autowired
    public void setSaleService(SaleService saleService)
    {
        this.saleService = saleService;
    }

    @RequestMapping(value = {"/sale/list", "/sale"})
    public String listSales(Model model)
    {
        model.addAttribute("sales", saleService.listAll());
        return "/sale/list";
    }

    @RequestMapping("/sale/show/{id}")
    public String getSale(@PathVariable String id, Model model)
    {
        model.addAttribute("sale", saleService.getById(Long.valueOf(id)));
        return "/sale/show";
    }

    @RequestMapping("/sale/edit/{id}")
    public String edit(@PathVariable String id, Model model)
    {
        Long editId = Long.valueOf(id);
        Sale sale = saleService.getById(Long.valueOf(id));
        SaleForm saleForm = saleToSaleForm.convert(sale);
        model.addAttribute("saleForm", saleForm);
        saleService.delete(editId);
        return "/sale/saleform";
    }

    @RequestMapping(value = "/sale/new")
    public String newSale(Model model)
    {
        model.addAttribute("saleForm", new SaleForm());
        /*
        model.addAttribute("representatives", RepresentativeRepository.findAll());
        model.addAttribute("representatives", ClientRepository.findAll());
        model.addAttribute("representatives", ProductRepository.findAll());
         */
        return "/sale/saleform";
    }

    /*
    @PostMapping(value = "/sale/new")
    public String submitSale(@ModelAttribute("saleForm") SaleForm saleForm)
    {
        return "/sale/saleform";
    }
    */

    @RequestMapping(value = "/sale", method = RequestMethod.POST)
    public String saveOrUpdateSale(@Valid SaleForm saleForm, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "sale/saleform";
        }
        Sale savedSale = saleService.saveOrUpdateSaleForm(saleForm);
        return "redirect:/sale/show/" + savedSale.getId();
    }

    @RequestMapping("/sale/delete/{id}")
    public String delete(@PathVariable String id)
    {
        saleService.delete(Long.valueOf(id));
        return "redirect:/sale/list";
    }
}
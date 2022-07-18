package SalesBusiness.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import SalesBusiness.web.negocio.Client;
import SalesBusiness.web.servicio.ServiceSalesBusiness;

@Controller
@RequestMapping()
public class ClientController {
    @Autowired
    ServiceSalesBusiness miservicio;

    @RequestMapping("/clients")
    public String showClients(Model model) {
	model.addAttribute("clients", miservicio.findAllClients());
	
	return "clients/lista-clientes";
    }

    @RequestMapping("/client/{pk_id}/edit")
    public String editClient(Model model, @PathVariable String pk_id) {
	model.addAttribute("client", miservicio.findClient(pk_id));
	List<String> genders=new ArrayList<String>(List.of("male","female","other"));
	model.addAttribute("genders",genders);
	

	return "clients/editar-cliente";
    }

    @RequestMapping(value = "/client/{pk_id}/save", method = RequestMethod.POST)
    public String updateClient(Model model, Client client, @RequestParam String pk_id) {

	
	miservicio.updateClient(client, pk_id);

	return "redirect:/clients";

    }

    @RequestMapping("/client/{pk_id}/delete")
    public String deleteClient(Model model, @PathVariable String pk_id) {
	miservicio.deleteClient(new Client(pk_id));
	return "redirect:/clients";
    }

    @RequestMapping("/client/new")
    public String formNewClient(Model model) {
	List<String> genders=new ArrayList<String>(List.of("male","female","other"));
	model.addAttribute("genders",genders);
	return "clients/formulario-cliente";
    }

    @RequestMapping("/client/insert")
    public String insertClient(Model model, Client client) {
	miservicio.insertClient(client);
	return "redirect:/clients";
    }

}

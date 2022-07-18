package SalesBusiness.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import SalesBusiness.web.negocio.Client;
import SalesBusiness.web.negocio.Product;
import SalesBusiness.web.negocio.Purchase;
import SalesBusiness.web.negocio.Store;
import SalesBusiness.web.servicio.ServiceSalesBusiness;

@Controller
@RequestMapping()
public class PurchaseController {

    @Autowired
    ServiceSalesBusiness miservicio;

    @RequestMapping("/sales")
    public String showPurchases(Model model) {
	model.addAttribute("purchases", miservicio.findAllPurchases());
	model.addAttribute("categories", miservicio.findAllCategories());
	return "sales/lista-ventas";
    }

    @RequestMapping("/sale/new")
    public String newFormPurchases(Model model) {
	model.addAttribute("products", miservicio.findAllProducts());
	model.addAttribute("clients", miservicio.findAllClients());
	model.addAttribute("stores", miservicio.findAllStores());
	return "sales/formulario-venta";
    }

    @RequestMapping("/sale/insert")
    public String insertPurchase(Model model, Purchase purchase, @RequestParam int fk_product,
	    @RequestParam String fk_client, @RequestParam int fk_store) {
	purchase.setProduct(new Product(fk_product));
	purchase.setClient(new Client(fk_client));
	purchase.setStore(new Store(fk_store));
	miservicio.insertPurchase(purchase);

	return "redirect:/sales";
    }

    @RequestMapping("/sale/{pk_purchase}/delete")
    public String deletePurchase(Model model, @PathVariable int pk_purchase) {
	miservicio.deletePurchase(new Purchase(pk_purchase));
	return "redirect:/sales";
    }

    @RequestMapping("/sale/{pk_purchase}/edit")
    public String editProduct(Model model, @PathVariable int pk_purchase) {

	model.addAttribute("products", miservicio.findAllProducts());
	model.addAttribute("clients", miservicio.findAllClients());
	model.addAttribute("stores", miservicio.findAllStores());
	model.addAttribute("purchase", miservicio.findOnePurchase(pk_purchase));
	return "sales/editar-venta";
    }

    @RequestMapping(value = "/sale/{pk_purchase}/save", method = RequestMethod.POST)
    public String updatePurchase(Model model, Purchase purchase, @RequestParam int pk_purchase,
	    @RequestParam int fk_product, @RequestParam String fk_client, @RequestParam int fk_store) {

	purchase.setProduct(new Product(fk_product));
	purchase.setClient(new Client(fk_client));
	purchase.setStore(new Store(fk_store));

	miservicio.updatePurchase(purchase, pk_purchase);

	return "redirect:/sales";

    }

}

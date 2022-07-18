package SalesBusiness.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import SalesBusiness.web.negocio.Product;
import SalesBusiness.web.servicio.ServiceSalesBusiness;

@Controller
@RequestMapping()
public class DiscountController {
    
    @Autowired
    ServiceSalesBusiness miservicio;

    @RequestMapping("/discounts")
    public String showProducts(Model model) {
   	model.addAttribute("products",miservicio.findAllProducts());
   	
   	return "discounts/discounts";
       }
    
    @RequestMapping(value="/setdiscounts", method= RequestMethod.POST)
    public String setsDiscounts(Model model,@RequestParam Map<String,String> allParams) {
	double discount=Integer.parseInt(allParams.get("discount"));
	allParams.forEach((key, value) -> {if(!key.equals("discount")) {
	    Product product=miservicio.findOneProduct(Integer.parseInt(key));
	    product.setPrice(product.getPrice()-(discount/100));
	    //miservicio.updateProduct(product, Integer.parseInt(key));
	    System.out.println(key);
	    
	}});
	
   	model.addAttribute("products",miservicio.findAllProducts());
   	
   	return "redirect:/discounts";
       }

}

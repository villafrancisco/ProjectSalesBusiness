package SalesBusiness.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import SalesBusiness.web.servicio.ServiceSalesBusiness;

@Controller
@RequestMapping()
public class MainController {

    @Autowired
    ServiceSalesBusiness miservicio;
    
    @RequestMapping()
    public String index(Model model) {
	return "index";
    }
}

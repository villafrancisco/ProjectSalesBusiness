package SalesBusiness.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import SalesBusiness.web.negocio.Purchase;
import SalesBusiness.web.servicio.ServiceSalesBusiness;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080", methods = { RequestMethod.GET, RequestMethod.POST })
public class ApiRestController {

    @Autowired
    ServiceSalesBusiness miservicio;

    @GetMapping("/purchase/product/category/{pk_category}")
        public List<Purchase> showPuchaseProductCategory(@PathVariable int pk_category) {
	//List<Product> products=miservicio.findAllProductsbyCategory(pk_category);
	return miservicio.findPurchaseByProductCategory(pk_category);
    }

}

package SalesBusiness.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import SalesBusiness.web.negocio.Category;
import SalesBusiness.web.negocio.Product;
import SalesBusiness.web.servicio.ServiceSalesBusiness;

@Controller
@RequestMapping()
public class ProductController {
    
    @Autowired
    ServiceSalesBusiness miservicio;
   
    
   
    @RequestMapping("/products")
    public String showProducts(Model model) {
	model.addAttribute("products",miservicio.findAllProducts());
	
	return "products/lista-productos";
    }
    
    @RequestMapping("/product/{pk_product}/edit")
    public String editProduct(Model model,@PathVariable int pk_product) {
	model.addAttribute("product",miservicio.findProduct(pk_product));
	
	model.addAttribute("categories",miservicio.findAllCategories());
	
	
	return "products/editar-producto";
    }
    
    @RequestMapping(value = "/product/{pk_product}/save", method = RequestMethod.POST)
    public String updateProduct(Model model, Product product, @RequestParam int pk_product,@RequestParam int fk_category) {
	
	product.setCategory(new Category(fk_category));
	
	miservicio.updateProduct(product, pk_product);
	
	return "redirect:/products";

    }
    
    @RequestMapping("/product/{pk_product}/delete")
    public String deleteProduct(Model model,@PathVariable int pk_product) {
	miservicio.deleteProduct(new Product(pk_product));
	return "redirect:/products";
    }
    @RequestMapping("/product/new")
    public String formNewProduct(Model model) {
	model.addAttribute("categories",miservicio.findAllCategories());
	return "products/formulario-producto";
    }
    @RequestMapping("/product/insert")
    public String insertProduct(Model model,Product product,@RequestParam int fk_category) {
	product.setCategory(new Category(fk_category));

	miservicio.insertProduct(product);
	return "redirect:/products";
    }
    

}

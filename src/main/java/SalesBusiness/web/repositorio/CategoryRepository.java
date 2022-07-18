package SalesBusiness.web.repositorio;

import java.util.List;

import SalesBusiness.web.negocio.Category;

public interface CategoryRepository {
    
    List<Category> findAll();

    Category findOne(int pk_category);

}

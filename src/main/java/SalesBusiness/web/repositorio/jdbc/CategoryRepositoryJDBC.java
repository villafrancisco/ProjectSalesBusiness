package SalesBusiness.web.repositorio.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import SalesBusiness.web.negocio.Category;
import SalesBusiness.web.repositorio.CategoryRepository;
import SalesBusiness.web.repositorio.jdbc.mapper.CategoryMapper;

@Repository
public class CategoryRepositoryJDBC implements CategoryRepository {

    @Autowired
    private JdbcTemplate plantilla;

    
    @Override
    public List<Category> findAll() {
	
	return plantilla.query("select * from category", new CategoryMapper());
    }

    @Override
    public Category findOne(int pk_category) {
	return plantilla.queryForObject("select * from category where pk_category=?",new CategoryMapper(),pk_category);
    }

}

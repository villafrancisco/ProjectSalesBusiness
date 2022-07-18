package SalesBusiness.web.repositorio.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import SalesBusiness.web.negocio.Category;

public class CategoryMapper implements RowMapper<Category> {

    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
	// TODO Auto-generated method stub
	return new Category(rs.getInt("pk_category"),rs.getString("name"));
    }

}

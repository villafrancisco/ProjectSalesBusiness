package SalesBusiness.web.repositorio.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import SalesBusiness.web.negocio.Category;
import SalesBusiness.web.negocio.Client;
import SalesBusiness.web.negocio.Product;
import SalesBusiness.web.negocio.Purchase;
import SalesBusiness.web.negocio.Store;

public class PurchaseMapper implements RowMapper<Purchase> {

    @Override
    public Purchase mapRow(ResultSet rs, int rowNum) throws SQLException {
	Product product =new Product(rs.getInt("pk_product"),rs.getString("name_product"),new Category(rs.getInt("pk_category"),rs.getString("name_category")),rs.getDouble("price"));
	Client client =new Client(rs.getString("pk_id"),rs.getString("name_client"),rs.getString("gender"));
	Store store=new Store(rs.getInt("pk_store"),rs.getString("town"));
	return new Purchase(rs.getInt("pk_purchase"),product,rs.getInt("units"),client,store,rs.getDate("date"));
		
    }

}

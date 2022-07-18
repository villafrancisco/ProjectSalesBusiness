package SalesBusiness.web.repositorio.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import SalesBusiness.web.negocio.Store;

public class StoreMapper implements RowMapper<Store> {

    @Override
    public Store mapRow(ResultSet rs, int rowNum) throws SQLException {
	return new Store(rs.getInt("pk_store"),rs.getString("town"));
    }

}

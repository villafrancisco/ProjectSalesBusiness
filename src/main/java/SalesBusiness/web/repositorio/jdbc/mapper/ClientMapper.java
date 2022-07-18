package SalesBusiness.web.repositorio.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import SalesBusiness.web.negocio.Client;

public class ClientMapper implements RowMapper<Client> {

    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
	return new Client(rs.getString("pk_id"),rs.getString("name"),rs.getString("gender"));
    }

}

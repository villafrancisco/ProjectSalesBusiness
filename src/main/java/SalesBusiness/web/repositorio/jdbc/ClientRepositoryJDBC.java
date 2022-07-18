package SalesBusiness.web.repositorio.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import SalesBusiness.web.negocio.Client;
import SalesBusiness.web.repositorio.ClientRepository;
import SalesBusiness.web.repositorio.jdbc.mapper.ClientMapper;

@Repository
public class ClientRepositoryJDBC implements ClientRepository {

    @Autowired
    private JdbcTemplate plantilla;

    @Override
    public void update(Client client, String pk_id) {
	plantilla.update("update client set pk_id=?, name=? , gender=? where pk_id=?",client.getPk_id(),client.getName(),client.getGender(),pk_id);

    }

    @Override
    public void insert(Client client) {
	plantilla.update("insert into client (pk_id,name,gender) values (?,?,?)",client.getPk_id(),client.getName(),client.getGender());

    }

    @Override
    public void delete(Client client) {
	plantilla.update("delete from client where pk_id =?",client.getPk_id());

    }

    @Override
    public List<Client> findAll() {
	return plantilla.query("select * from client", new ClientMapper());
    }

    @Override
    public Client findOne(String pk_id) {
	return plantilla.queryForObject("select * from client where pk_id=?",new ClientMapper(),pk_id);
    }

}

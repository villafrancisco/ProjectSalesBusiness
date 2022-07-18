package SalesBusiness.web.repositorio.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import SalesBusiness.web.negocio.Store;
import SalesBusiness.web.repositorio.StoreRepository;
import SalesBusiness.web.repositorio.jdbc.mapper.StoreMapper;

@Repository
public class StoreRepositoryJDBC implements StoreRepository {
    @Autowired
    private JdbcTemplate plantilla;
    

    @Override
    public List<Store> findAll() {
	return plantilla.query("select * from store", new StoreMapper());
    }

}

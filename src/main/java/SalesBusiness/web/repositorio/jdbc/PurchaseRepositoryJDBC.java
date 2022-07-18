package SalesBusiness.web.repositorio.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import SalesBusiness.web.negocio.Purchase;
import SalesBusiness.web.repositorio.PurchaseRepository;
import SalesBusiness.web.repositorio.jdbc.mapper.PurchaseMapper;

@Repository
public class PurchaseRepositoryJDBC implements PurchaseRepository {

    @Autowired
    private JdbcTemplate plantilla;
    
    @Override
    public void update(Purchase purchase, int pk_purchase) {
	plantilla.update("update purchase set pk_purchase=?, fk_product=?, units=?, fk_client=?, fk_store=?, date=? where pk_purchase=?",purchase.getPk_purchase(),purchase.getProduct().getPk_product(),purchase.getUnits(),purchase.getClient().getPk_id(),purchase.getStore().getPk_store(),purchase.getDate(),purchase.getPk_purchase());

    }

    @Override
    public void insert(Purchase purchase) {
	plantilla.update("insert into purchase (fk_product, units, fk_client, fk_store, date) values (?,?,?,?,?)",purchase.getProduct().getPk_product(),purchase.getUnits(),purchase.getClient().getPk_id(),purchase.getStore().getPk_store(),purchase.getDate());

    }

    @Override
    public void delete(Purchase purchase) {
	plantilla.update("delete from purchase where pk_purchase =?",purchase.getPk_purchase());

    }

    @Override
    public List<Purchase> findAll() {
	return plantilla.query("select *, pr.name as name_product, ca.name as name_category, c.name as name_client  from purchase as p INNER JOIN client as c ON p.fk_client=c.pk_id"
		+ " INNER JOIN store as s ON p.fk_store=s.pk_store INNER JOIN product as pr ON p.fk_product=pr.pk_product INNER JOIN category as ca ON pr.fk_category=ca.pk_category INNER JOIN store as st ON p.fk_store=st.pk_store", new PurchaseMapper());
    }

    @Override
    public Purchase findOne(int pk_purchase) {
	return plantilla.queryForObject("select *, pr.name as name_product, ca.name as name_category, c.name as name_client  from purchase as p INNER JOIN client as c ON p.fk_client=c.pk_id "
		+ " INNER JOIN store as s ON p.fk_store=s.pk_store INNER JOIN product as pr ON p.fk_product=pr.pk_product INNER JOIN category as ca ON pr.fk_category=ca.pk_category INNER JOIN store as st ON p.fk_store=st.pk_store where pk_purchase=?",new PurchaseMapper(),pk_purchase);
    }

    @Override
    public List<Purchase> findAllPurchaseByCategory(int pk_category) {
	return plantilla.query("select *, pr.name as name_product, ca.name as name_category, c.name as name_client  from purchase as p INNER JOIN client as c ON p.fk_client=c.pk_id"
		+ " INNER JOIN store as s ON p.fk_store=s.pk_store INNER JOIN product as pr ON p.fk_product=pr.pk_product INNER JOIN category as ca ON pr.fk_category=ca.pk_category INNER JOIN store as st ON p.fk_store=st.pk_store where ca.pk_category=?", new PurchaseMapper(),pk_category);
   }

}

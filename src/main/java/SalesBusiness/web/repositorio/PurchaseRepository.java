package SalesBusiness.web.repositorio;

import java.util.List;

import SalesBusiness.web.negocio.Purchase;

public interface PurchaseRepository {

    void update(Purchase purchase, int pk_purchase);

    void insert(Purchase purchase);

    void delete(Purchase purchase);

    List<Purchase> findAll();

    Purchase findOne(int pk_purchase);

    List<Purchase> findAllPurchaseByCategory(int pk_category);

}

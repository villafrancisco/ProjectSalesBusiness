package SalesBusiness.web.repositorio;

import java.util.List;

import SalesBusiness.web.negocio.Store;

public interface StoreRepository {

    List<Store> findAll();
}

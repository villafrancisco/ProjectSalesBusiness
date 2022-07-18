package SalesBusiness.web.repositorio;

import java.util.List;

import SalesBusiness.web.negocio.Client;

public interface ClientRepository {

    void update(Client client, String pk_id);

    void insert(Client client);

    void delete(Client client);

    List<Client> findAll();

    Client findOne(String pk_id);

}

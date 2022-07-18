package SalesBusiness.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SalesBusiness.web.negocio.Category;
import SalesBusiness.web.negocio.Client;
import SalesBusiness.web.negocio.Product;
import SalesBusiness.web.negocio.Purchase;
import SalesBusiness.web.negocio.Store;
import SalesBusiness.web.repositorio.CategoryRepository;
import SalesBusiness.web.repositorio.ClientRepository;
import SalesBusiness.web.repositorio.ProductRepository;
import SalesBusiness.web.repositorio.PurchaseRepository;
import SalesBusiness.web.repositorio.StoreRepository;

@Service
public class ServiceSalesBusiness {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private PurchaseRepository purchaseRepository;

    public void updateProduct(Product product, int pk_product) {
	productRepository.update(product, pk_product);
    }

    public void insertProduct(Product product) {
	productRepository.insert(product);
    }

    public void deleteProduct(Product product) {
	productRepository.delete(product);
    }

    public List<Product> findAllProducts() {
	return productRepository.findAll();
    }

    public Product findProduct(int pk_product) {
	return productRepository.findOne(pk_product);
    }

    public List<Category> findAllCategories() {
	return categoryRepository.findAll();
    }

    public List<Client> findAllClients() {
	return clientRepository.findAll();
    }

    public void updateClient(Client client, String pk_id) {
	clientRepository.update(client, pk_id);

    }

    public void deleteClient(Client client) {
	clientRepository.delete(client);

    }

    public void insertClient(Client client) {
	clientRepository.insert(client);

    }

    public Client findClient(String pk_id) {
	return clientRepository.findOne(pk_id);
    }

    public List<Purchase> findAllPurchases() {
	return purchaseRepository.findAll();
    }

    public void insertPurchase(Purchase purchase) {
	purchaseRepository.insert(purchase);

    }

    public void deletePurchase(Purchase purchase) {
	purchaseRepository.delete(purchase);

    }

    public Purchase findOnePurchase(int pk_purchase) {
	return purchaseRepository.findOne(pk_purchase);
    }

    public void updatePurchase(Purchase purchase, int pk_purchase) {
	purchaseRepository.update(purchase, pk_purchase);

    }

    public List<Store> findAllStores() {
	return storeRepository.findAll();
    }

    public List<Purchase> findPurchaseByProductCategory(int pk_category) {
	return purchaseRepository.findAllPurchaseByCategory(pk_category);
    }

    public Product findOneProduct(int pk_product) {
	return productRepository.findOne(pk_product);
    }

    

}

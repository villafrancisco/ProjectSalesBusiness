package SalesBusiness.web.negocio;

import java.sql.Date;

public class Purchase {
    private int pk_purchase;
    private Product product;
    private int units;
    private Client client;
    private Store store;
    private Date date;
    public Purchase(int pk_purchase, Product product, int units, Client client, Store store, Date date) {
	super();
	this.pk_purchase = pk_purchase;
	this.product = product;
	this.units = units;
	this.client = client;
	this.store = store;
	this.date = date;
    }
    public Purchase(int pk_purchase) {
	super();
	this.pk_purchase = pk_purchase;
    }
    public Purchase() {
	super();
    }
    public int getPk_purchase() {
        return pk_purchase;
    }
    public void setPk_purchase(int pk_purchase) {
        this.pk_purchase = pk_purchase;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getUnits() {
        return units;
    }
    public void setUnits(int units) {
        this.units = units;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Store getStore() {
        return store;
    }
    public void setStore(Store store) {
        this.store = store;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public String toString() {
	return "Purchase [pk_purchase=" + pk_purchase + ", product=" + product + ", units=" + units + ", client="
		+ client + ", store=" + store + ", date=" + date + "]";
    }
    
    
    

}

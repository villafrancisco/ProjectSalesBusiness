package SalesBusiness.web.negocio;

public class Store {
    private int pk_store;
    private String town;
    
    
    public Store(int pk_store, String town) {
	super();
	this.pk_store = pk_store;
	this.town = town;
    }
    
    public Store(int pk_store) {
	super();
	this.pk_store = pk_store;
    }
    

    public Store() {
	super();
    }

    public int getPk_store() {
        return pk_store;
    }
    public void setPk_store(int pk_store) {
        this.pk_store = pk_store;
    }
    public String getTown() {
        return town;
    }
    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public String toString() {
	return "Store [pk_store=" + pk_store + ", town=" + town + "]";
    }
    

}

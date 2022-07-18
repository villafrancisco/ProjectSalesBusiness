package SalesBusiness.web.negocio;

public class Product {
    private int pk_product;
    private String name;
    private Category category;
    private double price;
    public Product(int pk_product, String name, Category category, double price) {
	super();
	this.pk_product = pk_product;
	this.name = name;
	this.category = category;
	this.price = price;
    }
    public Product(int pk_product) {
	super();
	this.pk_product = pk_product;
    }
    public Product() {
	super();
    }
    public int getPk_product() {
        return pk_product;
    }
    public void setPk_product(int pk_product) {
        this.pk_product = pk_product;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
	return "Product [pk_product=" + pk_product + ", name=" + name + ", category=" + category + ", price=" + price
		+ "]";
    }

    
}

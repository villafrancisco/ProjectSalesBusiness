package SalesBusiness.web.negocio;

public class Category {
    
    private int pk_category;
    private String name;
    
    public Category(int pk_category, String name) {
	super();
	this.pk_category = pk_category;
	this.name = name;
    }
    public Category(int pk_category) {
	super();
	this.pk_category = pk_category;
    }
    public Category() {
	super();
    }
    public int getPk_category() {
        return pk_category;
    }
    public void setPk_category(int pk_category) {
        this.pk_category = pk_category;
    }
    @Override
    public String toString() {
	return "Category [pk_category=" + pk_category + ", name=" + name + "]";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
    
    

}

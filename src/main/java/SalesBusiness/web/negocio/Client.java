package SalesBusiness.web.negocio;

enum gender{
    female,male,other;
}

public class Client {
   
    private String pk_id;
    private String name;
    private String gender;
    
    
    
    
    public Client(String pk_id, String name, String gender) {
	super();
	this.pk_id = pk_id;
	this.name = name;
	this.gender = gender;
    }
    public Client(String pk_id, String name) {
	super();
	this.pk_id = pk_id;
	this.name = name;
    }
    public Client(String pk_id) {
	super();
	this.pk_id = pk_id;
    }
    public Client() {
	super();
    }
    public String getPk_id() {
        return pk_id;
    }
    public void setPk_id(String pk_id) {
        this.pk_id = pk_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
	return "Client [pk_id=" + pk_id + ", name=" + name + ", gender=" + gender + "]";
    }

    
    

}

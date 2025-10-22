import java.util.UUID;

public abstract class AbstractCustomer implements Discountable{
    private String id;
    private String name;
    private String email;

    public AbstractCustomer(String name, String email){
        this.name=name;
        this.email=email;
        id= UUID.randomUUID().toString();
    }

    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setEmail(String email){
        this.email=email;
    }

    @Override
    public String toString() {
        return name + " | " + email + " | ID: " + id;
    }

    public abstract double getDiscount();

}

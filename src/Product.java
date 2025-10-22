import java.util.UUID;

public class Product implements Sellable{
    private String id;
    private String name;
    private String description;
    private double price;
    private int stock;

    public Product (String name,String description, double price,int stock){
        this.id= UUID.randomUUID().toString();
        this.name=name;
        this.description=description;
        this.price=price;
        this.stock=stock;
    }

    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }
    public double getPrice(){
        return this.price;
    }
    public int getStock() {
        return this.stock;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public void setPrice(double price){
        if(price<0){
            System.out.println("The price cannot be lower than 0!");
        }else {
            this.price=price;
        }
    }
    public void setStock(int stock){
        this.stock=stock;
    }


    public void addStock(int amount){
        this.stock+=amount;
    }
    public void removeStock(int amount){
        if(amount>this.stock){
            System.out.println("This amount is not available for removal");
        }else {
            this.stock-=amount;
        }
    }

    @Override
    public String toString() {
        return name + " - " + description + " | Price: " + price + " | Stock: " + stock;
    }


}

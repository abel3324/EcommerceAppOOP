import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Product> products;
    public Inventory(){
        this.products=new ArrayList<>();
    }
    public void addProduct(Product product){
        products.add(product);
    }
    public void removeProductById(String id){
        products.removeIf(p->p.getId().equals(id));
    }
    public Product findProductByName(String name){
        for(Product p:products){
            if(p.getName().equalsIgnoreCase(name)){
                return p;
            }
        }
        return null;
    }
    public Product findProductById(String id){
        for(Product p:products){
            if(p.getId().equalsIgnoreCase(id)){
                return p;
            }
        }
        return null;
    }
    public void updateStock(String id,int newStock){
        for(Product p:products){
            if(p.getId().equals(id)){
                p.setStock(newStock);
                return;
            }
        }
    }
    public void printAll(){
        if(products.isEmpty()){
            System.out.println("No products in the inventory");
            return;
        }
        System.out.println("=== Product Inventory ===");
        for(Product p:products){
            System.out.println(p);
        }
    }

    public List<Product> getProducts(){
        return products;
    }
}

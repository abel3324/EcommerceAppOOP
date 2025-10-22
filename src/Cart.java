import java.util.ArrayList;
import java.util.List;

public class Cart {
    private AbstractCustomer customer;
    private List<CartItem> items;
    private Inventory inventory;
    private List<Order> orderHistory=new ArrayList<>();

    public Cart(AbstractCustomer a,Inventory inventory){
        this.customer=a;
        this.inventory=inventory;
        this.items=new ArrayList<>();
    }
    public List<Order> getOrderHistory(){
        return this.orderHistory;
    }

    public String addItem(String productName , int quantity){
        Product product=inventory.findProductByName(productName);
        if(product==null){
            return "❌ The product :" + productName + "is not in stock!" ;

        }
        if(product.getStock()<quantity){
            return "⚠ Insuficient stock for " + product.getName() + "(available : " + product.getStock() + ")";
        }
        product.removeStock(quantity);

        for(CartItem item:items){
            if(item.getProduct().getId().equals(product.getId())){
                item.setQuantity(item.getQuantity() + quantity);
                return "✅ Updated " + product.getName() + " quantity in cart.";
            }
        }
        items.add(new CartItem(product,quantity));
        return "✅ Added " + quantity + " x " + product.getName() + " to cart.";

    }

    public String removeItem(String productName,int quantity){
        for(CartItem item:items){
            if(item.getProduct().getName().equalsIgnoreCase(productName)){
                if(quantity>=item.getQuantity()){
                    items.remove(item);
                    item.getProduct().addStock(item.getQuantity());
                    return productName + " removed completley from cart!";
                }else{
                    item.setQuantity(item.getQuantity()-quantity);
                    item.getProduct().addStock(quantity);
                    return quantity + " x " + productName + " removed from cart!";
                }
            }
        }
        return "❌ Product not found in cart!";

    }

    public double calculateTotal(){
        double total=0;
        for(CartItem item:items){
            total+=item.getProduct().getPrice()* item.getQuantity();
        }
        total*= (1-customer.getDiscount());
        return total;
    }

    public void printCart(){
        System.out.println("Cosul clientului : " + customer.getName());
        for(CartItem item:items){
            System.out.println(item.getProduct().getName() + " x " + item.getQuantity() +
                               " = " + (item.getProduct().getPrice() * item.getQuantity()));
        }
        System.out.println("Total de plata : " + calculateTotal());
    }
    public void checkout(Inventory inventory,PaymentMethod paymentMethod){
        System.out.println("\n=== Checkout for " + customer.getName() + " ===");
        for(CartItem item:items){
            Product product=inventory.findProductById(item.getProduct().getId());
            if(product==null){
                System.out.println("❌ The product " + item.getProduct().getName() + " no longer exists in the inventory!");
                return;
            }
            if(product.getStock()<item.getQuantity()){
                System.out.println("⚠️ Not enough stock for " + product.getName() + " (available: " + product.getStock() + ")");
                return;
            }
        }
        for(CartItem item:items){
            Product product=inventory.findProductById(item.getProduct().getId());
            product.setStock(product.getStock()-item.getQuantity());
        }
        double total=calculateTotal();
        System.out.println("💰 Total to pay: " + total + " RON (discount applied: " + (customer.getDiscount() * 100) + "%)");

        paymentMethod.pay(total);

        orderHistory.add(new Order(customer,items,total));

        items.clear();
        System.out.println("✅ Checkout completed successfully! The cart is now empty.");
    }

    public void refundOrder(Order order,Inventory inventory){
        System.out.println("\n=== Refund for Order ID: " + order.getId() + " ===");

        for(CartItem item: order.getItems()){
            Product product=inventory.findProductById(item.getProduct().getId());
            if(product!=null){
                product.addStock(item.getQuantity());
            }
        }
        orderHistory.remove(order);
        System.out.println("✅ Order refunded successfully. Stock has been updated.");
    }
    public void clear(){
        items.clear();
    }
    public List<CartItem> getItems(){
        return items;
    }





}

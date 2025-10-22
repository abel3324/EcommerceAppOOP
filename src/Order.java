import java.util.List;
import java.util.UUID;

public class Order {
    private String id;
    private List<CartItem> items;
    private double total;
    private AbstractCustomer customer;

    public Order(AbstractCustomer customer, List<CartItem> items, double total){
        this.customer=customer;
        this.items=List.copyOf(items);
        this.total=total;
        this.id= UUID.randomUUID().toString();

    }
    public String getId() {
        return this.id;
    }

    public List<CartItem> getItems() {
        return this.items;
    }

    public double getTotal() {
        return this.total;
    }

    public AbstractCustomer getCustomer() {
        return this.customer;
    }
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("Order ID: ").append(id).append("\n");
        sb.append("Customer: ").append(customer.getName()).append("\n");
        sb.append("Items:\n");
        for(CartItem item:items){
            sb.append("  ").append(item.getProduct().getName())
                    .append(" x ").append(item.getQuantity())
                    .append(" = ").append(item.getProduct().getPrice() * item.getQuantity())
                    .append("\n");
        }
        sb.append("Total : ").append(total).append(" RON\n");
        return sb.toString();


    }
}

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product,int quantity){
        this.product=product;
        this.quantity=quantity;
    }

    public Product getProduct() {
        return this.product;
    }
    public int getQuantity() {
        return this.quantity;
    }

    public void setProduct(Product product){
        this.product=product;
    }
    public void setQuantity(int quantity) {
        if (quantity<0){
            System.out.println("The quantity you are setting cannot be lower than 0 ! ");
        }else {
            this.quantity=quantity;
        }
    }

    @Override
    public String toString(){
        return product.getName() + " | Quantity: " + quantity + " | Price each: " + product.getPrice();
    }

}

public class PayPalPayment implements PaymentMethod{
    private String email;

    public PayPalPayment(String email){
        this.email=email;
    }
    @Override
    public void pay(double amount) {
        System.out.println("🅿️ Paid " + amount + " RON using PayPal account :" + email);
    }

    @Override
    public String getName() {
        return "PayPal";
    }
}

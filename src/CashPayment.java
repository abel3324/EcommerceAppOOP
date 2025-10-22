public class CashPayment implements PaymentMethod{
    @Override
    public void pay(double amount) {
        System.out.println("💵 Cash on delivery: " + amount + " RON to be paid upon delivery");
    }

    @Override
    public String getName() {
        return "Cash on Delivery";
    }
}

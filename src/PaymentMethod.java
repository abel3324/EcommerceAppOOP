public interface PaymentMethod {
    void pay(double amount);
    String getName();
}

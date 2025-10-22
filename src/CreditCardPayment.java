public class CreditCardPayment implements PaymentMethod{
    private String cardNumber;

    public CreditCardPayment(String cardNumber){
        this.cardNumber=cardNumber;
    }
    @Override
    public void pay(double amount){
        System.out.println("💳 Paid " + amount + " RON using Credit Card ending with "
                + cardNumber.substring(cardNumber.length() - 4));
    }
    @Override
    public String getName() {
        return "Credit Card";
    }
}

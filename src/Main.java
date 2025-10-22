
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        //inventar, se pot adauga cate produse se doresc
        Inventory inventory = new Inventory();
        inventory.addProduct(new Product("Laptop",".", 3500, 10));
        inventory.addProduct(new Product("Mouse",".", 150, 25));
        inventory.addProduct(new Product("Keyboard",".", 300, 15));

        // creează client
        AbstractCustomer customer = new RegularCustomer("Abel", "abel.ursu33@gmail.com"); // 10% discount

        // deschide fereastra principală
        SwingUtilities.invokeLater(() -> new MainFrame(inventory, customer));
    }
}


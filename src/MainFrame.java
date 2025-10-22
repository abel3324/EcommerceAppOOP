
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {
    private Inventory inventory;
    private Cart cart;
    private DefaultListModel<String> listModel;
    private JList<String> productList;
    private AbstractCustomer customer;

    public MainFrame(Inventory inventory,AbstractCustomer customer){
        this.inventory=inventory;
        this.customer=customer;
        this.cart=new Cart(customer,inventory);

        setVisible(true);

        setTitle("E-commerce App");
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        listModel=new DefaultListModel<>();
        for(Product p : inventory.getProducts()){
            listModel.addElement(p.getName() + " | Price : " + p.getPrice() + " (in stock : " + p.getStock() + ")");
        }
        productList=new JList<>(listModel);
        add(new JScrollPane(productList),BorderLayout.CENTER);

        JPanel buttonPanel=new JPanel();
        JButton addToCartBtn=new JButton("Add to Cart");
        JButton viewCartBtn=new JButton("View Cart");
        JButton exitBtn=new JButton("Exit");

        buttonPanel.add(addToCartBtn);
        buttonPanel.add(viewCartBtn);
        buttonPanel.add(exitBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        addToCartBtn.addActionListener(e->{
            String selected=productList.getSelectedValue();
            if(selected==null){
                JOptionPane.showMessageDialog(this,"You must select a product first !");
                return;
            }
            String productName = selected.split("\\|")[0].trim();
            String quantityStr=JOptionPane.showInputDialog("Enter quantity to add in cart : ");
            if(quantityStr==null)return;

            int quantity=Integer.parseInt(quantityStr);
            String result = cart.addItem(productName, quantity);
            JOptionPane.showMessageDialog(this, result);
            refreshProductList();

        });

        viewCartBtn.addActionListener(e -> {
            new CartFrame(cart,inventory,this);
        });

        exitBtn.addActionListener(e->System.exit(0));
    }
    public void refreshProductList(){
        listModel.clear();
        for(Product p:inventory.getProducts()){
            listModel.addElement(p.getName() + " | Price : " + p.getPrice() + " (in stock : " + p.getStock() + ")");
        }
    }
}

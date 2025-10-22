import javax.swing.*;
import java.awt.*;

public class CartFrame extends JFrame {
    private Cart cart;
    private Inventory inventory;
    private JFrame mainFrame;
    private DefaultListModel<String> cartListModel;
    private JList<String> cartList;
    private JLabel totalLabel;

    public CartFrame(Cart cart,Inventory inventory, JFrame mainFrame){
        this.cart=cart;
        this.inventory=inventory;
        this.mainFrame=mainFrame;
        setVisible(true);

        setTitle("Your  Cart ");
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initCartList();
        initButtons();
        updateTotalLabel();

    }
    private void initCartList(){
        cartListModel=new DefaultListModel<>();
        for(CartItem item:cart.getItems()){
            cartListModel.addElement(item.toString());
        }
        cartList = new JList<>(cartListModel);
        add(new JScrollPane(cartList),BorderLayout.CENTER);
    }

    private void initButtons(){
        JPanel buttonPanel = new JPanel();

        JButton removeBtn = new JButton("Remove Selected");
        JButton checkoutBtn = new JButton("Checkout");
        JButton backBtn = new JButton("Back");

        totalLabel=new JLabel("Total: " + cart.calculateTotal() + "RON");
        totalLabel.setFont(new Font("Arial",Font.BOLD,16));
        totalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(totalLabel,BorderLayout.NORTH);

        buttonPanel.add(removeBtn);
        buttonPanel.add(checkoutBtn);
        buttonPanel.add(backBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        removeBtn.addActionListener(e->removeSelectedItem());
        checkoutBtn.addActionListener(e->checkout());
        backBtn.addActionListener(e->{
            mainFrame.setVisible(true);
            dispose();
        });
    }
    private void updateTotalLabel(){
        totalLabel.setText("Total : " + cart.calculateTotal() + " RON");
    }

    private void removeSelectedItem(){
        int selectedIndex=cartList.getSelectedIndex();
        if(selectedIndex==-1){
            JOptionPane.showMessageDialog(this,"Select an item first !");
            return;
        }
        CartItem selectedItem=cart.getItems().get(selectedIndex);
        String productName=selectedItem.getProduct().getName();

        String quantityStr=JOptionPane.showInputDialog(this,
                "Enter quantity to remove (max " + selectedItem.getQuantity() + " ) :");
        if(quantityStr==null)return;
        int quantity;
        try{
            quantity=Integer.parseInt(quantityStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,"Invalid number!");
            return;
        }
        if(quantity<=0){
            JOptionPane.showMessageDialog(this,"Quantity must be >0");
            return;
        }
        String result=cart.removeItem(productName,quantity);
        refreshCartList();
        updateTotalLabel();
        if(mainFrame instanceof MainFrame){
            ((MainFrame) mainFrame).refreshProductList();
        }

        JOptionPane.showMessageDialog(this,result);
    }
    private void refreshCartList(){
        cartListModel.clear();
        for(CartItem item: cart.getItems()){
            cartListModel.addElement(item.getProduct().getName() + " | Quantity: " + item.getQuantity() + " | Price each: " + item.getProduct().getPrice());
        }
    }


    private void checkout(){
        if(cart.getItems().isEmpty()){
            JOptionPane.showMessageDialog(this,"Your cart is empty!");
            return;
        }
        PaymentMethod paymentMethod=new PaymentMethod() {
            @Override
            public void pay(double amount) {
                JOptionPane.showMessageDialog(CartFrame.this,"Paid " + amount + " RON successfully!");
            }

            @Override
            public String getName() {
                return "Sabin";
            }
        };
        cart.checkout(inventory,paymentMethod);
        cartListModel.clear();
        updateTotalLabel();
        mainFrame.setVisible(true);
        dispose();
    }
}

public class VIPCustomer extends AbstractCustomer {

    public VIPCustomer(String name,String email){
        super(name,email);
    }

    @Override
    public double getDiscount(){
        return 0.2;
    }

}

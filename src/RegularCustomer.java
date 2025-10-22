public class RegularCustomer extends AbstractCustomer{

    public RegularCustomer(String name, String email){
        super(name,email);
    }

    @Override
    public double getDiscount(){
        return 0;
    }

}

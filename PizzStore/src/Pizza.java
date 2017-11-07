
public class Pizza {
	public Pizza(String type){
		SimplePizzaFactory(type);
	}
	public Pizza SimplePizzaFactory(String type){
		Pizza p = null;
	    switch(type){
	    case "Cheese":
	    	p=new CheesePizza(type);
	    	break;
		case "Pepproni":
	    	p=new PepproniPizza(type);
	    	break;
		case "Clam":
	    	p=new ClamPizza(type);
	    	break;
	    }
	    return p;
	    }
   public void prepare(){
	   System.out.println("prepare pizza");
   }
   public void bake(){
	   System.out.println("bake pizza");
   }
   public void cut(){
	   System.out.println("cut pizza");
   }
   public void box(){
	   System.out.println("box pizza");
   }
   public class CheesePizza extends Pizza{

	public CheesePizza(String type) {
		super(type);
		
	}}
   public class PepproniPizza extends Pizza{

	public PepproniPizza(String type) {
		super(type);
		
	}}
   public class ClamPizza extends Pizza{

	public ClamPizza(String type) {
		super(type);
		
	}}
}


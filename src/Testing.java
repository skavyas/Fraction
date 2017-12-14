
public class Testing {

	public static void main(String[] args) {
			Fraction f1  = new Fraction(-1,2);
			Fraction f2  = new Fraction(1,1);
			System.out.println(f1.hashCode());
			System.out.println(f2.hashCode());
			if(f1.hashCode() == f2.hashCode())
	        {
	            if(f1.equals(f2))
	                System.out.println(f1 +"and "+f2+" are equal.");
	            else
	                System.out.println(f1 +"and "+f2+" are not equal.");
	        }
	        else
	        	System.out.println(f1 +"and "+f2+" are not equal.");
			Fraction result = f1.add(f2);
			result = f1.divideBy(f2);
			if(f1.compareTo(f2) == 1) {
		        System.out.println(f1+" is greater than "+f2); 
			}
			else {
		        System.out.println(f1+" is less than "+f2); 
			}
		}
	
}

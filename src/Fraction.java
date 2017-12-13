public class Fraction {
	
	private int numerator;
	private int denominator;
	private int HCF = 1;
	
	public Fraction(int numerator,int denominator) {
		if(denominator == 0) {
			throw new IllegalArgumentException("Cannot divide by zero");
		}
		if(denominator < 0) {
			this.numerator = -numerator;
			this.denominator = -denominator;
		}
		else {
			this.numerator = numerator;
			this.denominator = denominator;
		}		
	}
	
	public int getNumerator() {
		return this.numerator;
	}
	
	public int getDenominator() {
		return this.denominator;
	}
	
	private void findHCF(int num, int den) {
		// TODO Auto-generated method stub
		num = Math.abs(num);
		den = Math.abs(den);
		HCF = 1;
		int min;
		if(num>den) {
			min = den;
		}
		else {
			min = num;
		}
		for (int i = min; i > 1; --i) {
            if (num%i==0&&den%i==0) {
                HCF = i;
                break;
            }
        }	
	}
	
	public int findLCM(int a, int b) {
		if(a == b) {
			return a;
		}
		findHCF(a, b);
		return (a*b)/HCF;
	}
	
	public Fraction simplify() {
		int num = this.numerator;
		int den = this.denominator;
		findHCF(num,den);	
		this.numerator = num/HCF;
        this.denominator = den/HCF;
		return this;
	}
	
	//Adding
	public Fraction addFraction(Fraction f2) {
		int num1 = this.numerator;
		int den1 = this.denominator;
		int num2 = f2.getNumerator();
		int den2 = f2.getDenominator();
		int lcm;
		lcm = findLCM(den1, den2);
		Fraction result = new Fraction((num1*(lcm/den1) + num2*(lcm/den2)),lcm);
		result.simplify();
		return result;	
	}
	
	//Mulitply
	public Fraction mulFraction(Fraction f2) {
		this.simplify();
		int num1 = this.numerator;
		int den1 = this.denominator;
		f2.simplify();
		int num2 = f2.getNumerator();
		int den2 = f2.getDenominator();
		Fraction result = new Fraction((num1*num2),(den1*den2));
		result.simplify();
		return result;
	}

	//Dividing fractions
	public Fraction divideBy(Fraction f2) {
		this.simplify();
		int num1 = this.numerator;
		int den1 = this.denominator;
		f2.simplify();
		int num2 = f2.getNumerator();
		int den2 = f2.getDenominator();
		Fraction result = new Fraction( num1*den2,num2*den1);
		result.simplify();
		return result;	
	}

	//Subtract fractions
	public Fraction subtractBy(Fraction f2) {
		this.simplify();
		int num1 = this.numerator;
		int den1 = this.denominator;
		f2.simplify();
		int num2 = f2.getNumerator();
		int den2 = f2.getDenominator();
		int lcm = findLCM(den1, den2);
		Fraction result = new Fraction((num1*(lcm/den1) - num2*(lcm/den2)),lcm);
		result.simplify();
		return result;	
	}
	
	//Is equal
	public boolean isEqual(Fraction f2) {
		int num1 = this.numerator;
		int den1 = this.denominator;
		int num2 = f2.getNumerator();
		int den2 = f2.getDenominator();
		int lcm = findLCM(den1, den2);
		System.out.println("LCMM :"+lcm);
		if(num1*(lcm/den1) == num2*(lcm/den2)) {
			return true;
		}
		return false;	
	}
	
	//Compare to
	public int compareTo(Fraction f2) {
		int num1 = this.numerator;
		int den1 = this.denominator;
		int num2 = f2.getNumerator();
		int den2 = f2.getDenominator();
		int lcm = findLCM(den1, den2);
		if(num1*(lcm/den1) <= num2*(lcm/den2)) {
			return -1;
		}
		return 1;	
	}
	//Displaying Fraction
	public String toString() {
		return numerator+"/"+denominator;
		
	}
	
	public void display() {
		System.out.println(this.toString());
	}
	
	public static void main(String[] args) {
		Fraction f1  = new Fraction(-17,-17);
		Fraction f2  = new Fraction(0,1);
		Fraction result = f1.addFraction(f2);
		result = f1.divideBy(f2);
		result.display();
	}
	
}
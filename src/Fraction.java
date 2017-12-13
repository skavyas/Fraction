public class Fraction {
	
	int numerator;
	int denominator;
	int HCF = 1;
	
	public Fraction(int numerator,int denominator) {
	
		
		if(denominator < 0) {
			this.numerator = -numerator;
			this.denominator = -denominator;
		}
		else {
		this.numerator = numerator;
		this.denominator = denominator;
		}
		if(this.denominator == 0) {
			throw new IllegalArgumentException("Cannot divide by zero");
		}
		
	}
	
	public int getNumerator() {
		return this.numerator;
	}
	
	public int getDenominator() {
		return this.denominator;
	}
	
	public int simplify() {
		return this.numerator/this.denominator;
	}
	
	public boolean checkSimplify() {
		if(this.numerator%this.denominator == 0) {
			return true;
		}
		return false;
	}
	
	
	
	
	public Fraction addFraction(Fraction f2) {
		int num1 = this.numerator;
		int den1 = this.denominator;
		int num2 = f2.getNumerator();
		int den2 = f2.getDenominator();
		int min;
		int max;
		int lcm;
//		if(den1 == den2) {
//			lcm = den1;
//		}
		lcm = findLCM(den1, den2);
		System.out.println("LCMM :"+lcm);
		Fraction result = new Fraction((num1*(lcm/den1) + num2*(lcm/den2)),lcm);
		return result;	
	}
	
	public int findLCM(int a, int b) {
		a = Math.abs(a);
		b = Math.abs(b);
		if(a == b) {
			return a;
		}
		findHCF(a, b);
		return (a*b)/HCF;
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
	
	public Fraction simplifyMe() {
		int num = this.numerator;
		int den = this.denominator;
		findHCF(num,den);	
		this.numerator = num/HCF;
        this.denominator = den/HCF;
		return this;
	}
	
	//Mulitply
	public Fraction mulFraction(Fraction f2) {
		this.simplifyMe();
		int num1 = this.numerator;
		int den1 = this.denominator;
		f2.simplifyMe();
		int num2 = f2.getNumerator();
		int den2 = f2.getDenominator();
		Fraction result = new Fraction((num1*num2),(den1*den2));
		return result;
	}

	//Dividing fractions
	public Fraction divideFraction(Fraction f2) {
		this.simplifyMe();
		int num1 = this.numerator;
		int den1 = this.denominator;
		f2.simplifyMe();
		int num2 = f2.getNumerator();
		int den2 = f2.getDenominator();
		Fraction result = new Fraction( num1*den2,num2*den1);
		return result;	
	}

	//Subtract fractions
	public Fraction subtractFraction(Fraction f2) {
		this.simplifyMe();
		int num1 = this.numerator;
		int den1 = this.denominator;
		f2.simplifyMe();
		int num2 = f2.getNumerator();
		int den2 = f2.getDenominator();
		int lcm = findLCM(den1, den2);
		Fraction result = new Fraction((num1*(lcm/den1) - num2*(lcm/den2)),lcm);
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
	
	public static void main(String[] args) {
		Fraction f1  = new Fraction(-17,-17);
//		Fraction f = f1.simplifyMe();

		Fraction f2  = new Fraction(6,1);
		Fraction result = f1.addFraction(f2);
		result = f1.subtractFraction(f2);
//		if(result.checkSimplify()) {
//			int output = result.simplify();
//			System.out.println(output);
//		}
//		else {
			System.out.println(result.getNumerator()+"/"+result.getDenominator());
//		}
	}
	
}
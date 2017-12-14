# Fraction

Class used to compute basic Operations on Fractions

###### Initialisation
Fraction can be initialised as shown below:

```
Fraction fraction = new Fraction(12,5);
```
Here 12 is the numerator and 5 is the denominator

###### Basic Functions

Add, Subtract divide and mulitply operations can be used as shown below:



```
		Fraction addResult = f1.add(f2);
		Fraction multiplyResult = f1.mutliply(f2);
		Fraction divideResult = f1.divideBy(f2);
		Fraction subtractResult = f1.subtractBy(f2);	
```

###### Comparison

To check of they're equal:
```
		if(f1.hashCode() == f2.hashCode())
	        {
	            if(f1.equals(f2))
	                System.out.println(f1 +"and "+f2+" are equal.");
	            else
	                System.out.println(f1 +"and "+f2+" are not equal.");
	        }
	        else
	        	System.out.println(f1 +"and "+f2+" are not equal.");
```
To compare Fractions:

```
      		if(f1.compareTo(f2) == 1) {
        		System.out.println(f1+" is greater than "+f2); 
		}
		else {
			System.out.println(f1+" is less than "+f2); 
		}
```


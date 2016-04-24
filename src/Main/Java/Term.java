package Main.Java;

public class Term {
	
	/*It saves the coefficient and  exponent given to it, and then calculates the  value */
	private int coefficient, exponent, value;
	
	/*Class constructor*/
	public Term( int inputCoefficient, int inputExponent ) {
		this.coefficient = inputCoefficient;
		this.exponent = inputExponent;
		this.value = ( int ) Math.pow( coefficient, exponent );
	}
	
	
	/** It concatenates input numbers into a string expression
	 * @return stringExpression
	 */
	public String toString() {
		
		String stringExpression = "";
		
		if ( this.exponent == 0 ) {
			return Integer.toString( this.coefficient );
		}
		
		if ( this.coefficient > 1 ) {
			stringExpression = Integer.toString( this.coefficient );
		}
		
		stringExpression += "x";
		
		if ( this.exponent > 1 ) {
			stringExpression = stringExpression + "^" + Integer.toString(this.exponent);
		}
		
		return stringExpression;
		
	}
	
	public int getExponent() {
		return this.exponent;
	}
	
	public int getCoefficient() {
		return this.coefficient;
	}
	
	public int getValue() {
		return this.value;
	}
}

package Main.Java;

import java.util.*;

public class Polynomial
{
	private ArrayList<Term> polyExpression;
	public Polynomial()
	{
		polyExpression = new ArrayList<>();
	}
	
	/**It inserts new terms into the poly expression
	 * @param newTerm
	 */
	public void Insert(Term newTerm) {
		
		if ( polyExpression.isEmpty() ) {
			polyExpression.add(0, newTerm);
			return;
		}
		
		Term currentTerm = newTerm;

		for (int i = 0; i < polyExpression.size(); i++) {
			
			if ( polyExpression.get(i).getExponent() > currentTerm.getExponent() ) {
				Term temp = polyExpression.set(i, currentTerm);
				currentTerm = temp;
			}
		}
		polyExpression.add(currentTerm);
	}
	
	/** It makes printable poly expressions by concatenating the arraylist into a string 
	 * @return list
	 */
	public String getPolyExpression() {
		
		String list = "";
		
		for (int i = 0; i < polyExpression.size(); i++) {
			if ( (i > 0) && (polyExpression.get(i).getCoefficient() >= 0) ) {
				list += " + ";
			}
			
			else if (i > 0) {
				list += " ";
			}
			
			list += polyExpression.get(i).toString();
		}
		return list;
	}
	
	/**It deletes a term by removing it from the arraylist 
	 * @param termToDelete
	 */
	public void Delete(Term termToDelete) {
		boolean termWasDeleted = false;
		for (int i = 0; i < polyExpression.size(); i++) {
			if(polyExpression.get(i).getCoefficient() == termToDelete.getCoefficient() &&
				polyExpression.get(i).getExponent() == termToDelete.getExponent())
			{
				polyExpression.remove(i);
				termWasDeleted = true;
				break;
			}
		}
		if (termWasDeleted == false) {
			System.out.println("ERROR: THE GIVEN TERM WAS NOT IN THIS POLYNOMIAL");
		}
		polyExpression.removeAll( Collections.singleton(null) );
	}
	
	/**It reverses the list by swapping the elements 
	 */
	public void Reverse() {
		for (int i = 0; i < ( polyExpression.size() / 2 ); i++) {
			Term temp = polyExpression.set( i, polyExpression.get(polyExpression.size() - 1 - i) );
			polyExpression.set(polyExpression.size() - 1 - i, temp);
		}
	}
}
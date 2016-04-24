package Test;

import java.io.*;
import Main.Java.*;

public class Main {
	/* It is a driver class for the program */
	public static void main(String[] args) throws IOException  {
		BufferedReader input = new BufferedReader(new FileReader("src/main/resources/numbers.txt"));
		int base, exponent;
		
		while( input.ready() ) {
			BufferedReader operations = new BufferedReader(new FileReader("src/main/resources/operations.txt"));
			String[] line = input.readLine().split(";");
			Polynomial newPoly = new Polynomial();
			String polyName = line[0];
			
			for(int i = 1; i < line.length; i += 2) {
				base = Integer.parseInt( line[i] );
				exponent = Integer.parseInt( line[i + 1] );
				Term newTerm = new Term(base, exponent);
				newPoly.Insert(newTerm);
			}
			
			while( operations.ready() )
			{
				String read = operations.readLine();
				System.out.println(read);
				line = read.split(" ");
				
				if( line[0].equals("INSERT") ) {
					Term newTerm = new Term( Integer.parseInt(line[1]), Integer.parseInt(line[2]) );
					newPoly.Insert(newTerm);
					System.out.println( polyName + ": " + newPoly.getPolyExpression() );
				}
				
				if( line[0].equals("DELETE") ) {
					Term deleteMe = new Term( Integer.parseInt(line[1]), Integer.parseInt(line[2]) );
					newPoly.Delete(deleteMe);
					System.out.println( polyName + ": " + newPoly.getPolyExpression() );
				}
				
				if( line[0].equals("REVERSE") ) {
					newPoly.Reverse();
					System.out.println( polyName + ": " + newPoly.getPolyExpression() );
				}
				
				if( line[0].equals("PRODUCT") ) {
					System.out.println( polyName + ": " + newPoly.getPolyExpression() );
				}
				
				System.out.println("");
			}
			operations.close();
			System.out.println("");
		}
		input.close();
	}
}


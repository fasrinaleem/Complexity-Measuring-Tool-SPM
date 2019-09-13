
public class MyException2 {

    public static long fibonacci(long number) {

        if ((number == 0) || (number == 1)) { // base check
            return number;
        }
        else {
            // recursion step
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
        }

    public static void main(String args[ ]) {
        for (int count = 0; count <= 10; count++){

            System.out.println("Fibonacci of " + count + " is " + fibonacci(count));
        }
        }
		
/*		
		
		if (number < 10) {
			System.out.println("Number is greater than 10");
		} 
		if (number > 10) {
			System.out.println("Number is lesser than 10");
		}
		
		
		
		
		// infinite loop because condition is not apt 
        // condition should have been i>0. 
        for (int i = 5; i != 0; i -= 2) 
        { 
            System.out.println(i); 
        }
			

			
		try {
			//  Block of code to try
		}
		catch(Exception e) {
			//  Block of code to handle errors
		}
        }
		
		
		
		while(condition)
		{
			statement(s);
		}



		int i=10;
        do{
            System.out.println(i);
            i--;
        }while(i>1);




		
		switch(expression)
		{
			case value1 :
							// Statement
							break;
							// break is optional
			case value2 :
							// Statements
							break,
			default :
							// Statements
		}
	
	*/


}

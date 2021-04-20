public class Cryptarithmeic_problem {
	
	private static void backtracking(int digits[], int index,int choise) {
		/*
		 * this is a recursive method like a backtracking to give each char a different digit
		 * 
		 *helpful source: https://coderanch.com/t/595306/java/Optimizing-send-money-code
		 * */
	    if (index >= digits.length) { //if assignment is complete then return assignment
	    	ChooseAndPrint(digits,choise);
	        return;
	    }
	    
	    int ceiling=5; //an exoume eksadiko susthma
	    if(choise ==3) //an exoume dekadiko susthma
	    	ceiling = 9;
	    
	    label:
	    for (int digit=0; digit <= ceiling; digit++) {
	        digits[index] = digit;
	        for (int i = 0; i < index; i++)
	            if (digits[i] == digit) continue label;
	        backtracking(digits, index+1,choise);
	    }
	}
	 
	private static void ChooseAndPrint(int[] d,int choise) {
		
		/*method to check if the assignment from backtracking is correct
		 * this method supports first digit from a word to be 0 */
		if(choise==1) {
		int T=d[0],O=d[1],F=d[2],R=d[3];
		
		int TO = T*10 + O;
		int FOR = F*100 + O*10 + R;
		String num1 = String.valueOf(TO);
		String num2 = String.valueOf(FOR);
		num1 = sumBaseB(num1, num1, 6);
		if (num1.equals(num2))
			System.out.println("TO+TO=FOR=>"+T+O+"+"+T+O+"="+F+O+R);
		}
		else if(choise ==2) {
			int T=d[0],O=d[1],F=d[2],R=d[3];
			
			int TOÏ = T*100 + O*10+O;
			int FOR = F*100 + O*10 + R;
			String num1 = String.valueOf(TOÏ);
			String num2 = String.valueOf(FOR);
			num1 = sumBaseB(num1, num1, 6);
			if (num1.equals(num2))
				System.out.println("TOO+TOO=FOR=>"+T+O+O+"+"+T+O+O+"="+F+O+R);
		}else if(choise ==3) {
			int W=d[0],O=d[1],N=d[2],T=d[3];
			int WON = W*100 + O*10+N;
			int TOO = T*100 + O*10 + O;
			if (2*WON  == TOO)
				System.out.println("WON+WON=TOO=>"+W+O+N+"+"+W+O+N+"="+TOO);
		}
	}

	static String sumBaseB(String a, String b, int base) 
	    { 
		/*THIS METHOD IS A COPY FROM 
		 * https://www.geeksforgeeks.org/program-to-add-two-integers-of-given-base
		 * TO DO THE SUM WITH GIVEN BASE */
	        int len_a, len_b; 
	        len_a = a.length(); 
	        len_b = b.length(); 
	      
	        String sum, s; 
	        s = ""; 
	        sum = ""; 
	      
	        int diff; 
	        diff = Math.abs(len_a - len_b);    
	        // Padding 0 in front of the 
	        // number to make both numbers equal 
	        for (int i = 1; i <= diff; i++) 
	            s += "0";      
	        // Condition to check if the strings 
	        // have lengths mis-match 
	        if (len_a < len_b) 
	            a = s + a; 
	        else
	            b = s + b; 
	      
	        int curr, carry = 0; 
	          
	        // Loop to find the find the sum 
	        // of two integers of base B 
	        for (int i = Math.max(len_a, len_b) - 1; i > -1; i--) { 
	            // Current Place value for 
	            // the resultant sum 
	            curr = carry + (a.charAt(i) - '0') + 
	                        (b.charAt(i) - '0'); 
	            // Update carry 
	            carry = curr / base; 
	            // Find current digit 
	            curr = curr % base; 
	            // Update sum result 
	            sum = (char)(curr + '0') + sum; 
	        } 
	        if (carry > 0) 
	            sum = (char)(carry + '0') + sum; 
	        return sum; 
	    } 
	 
	public static void main(String[] args) {
		backtracking(new int[4],0,1); //TO+TO=FOR 
		backtracking(new int[4],0,2); //TOO+TOO=FOR 
		backtracking(new int[4],0,3); //WON+WON=TOO 
	}
}

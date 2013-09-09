/**
 * HW2 Part 1 - Coding with bases
 * @author Montek Singh
 * 
 * *** NOTE: The rules are different for each java file! ***
 *
 * You may not use any of the following:
 * - Any functions found in Java libraries (especially the Math library)
 *     - Example Math.pow, Integer.bitCount, String.valueOf, etc.
 *     - Basically, any function that does everything for you. The purpose of this
 *       homework is to learn how to do these operations yourself, instead of simply
 *       using the Java API!
 *     - The only exception to this rule is String.charAt to get a character from a
 *       String, and you may use String.length to get the size of the string.
 *     - Any Java 7 feature / standard library function (we will be grading using Java 6)
 *     
 * - You my not implement any Java library functions as helpers to use in other functions.
 *     
 * - String concatenation with a number for more than one digit.
 *     - For example, "" + 123 is banned. "" + 6 is allowed, though.
 *     
 * - You may only use 2 if-statements max.
 *     - This means you may have 2 separate conditions, making this okay:
 *     
 *     if(cond1) {
 *         code;
 *     } else {
 *         moreCode;
 *     }
 *     if(cond2) {
 *         code;
 *     } else {
 *         modeCode;
 *     }
 *     
 * - You may not use a switch statement.
 *     
 * - Recursion is not allowed.
 * 
 * - You may not reuse any function to implement another function.
 * 
 * - Typecasting IS allowed.
 * 
 * Your code also must compile, not throw exceptions, or infinitely loop on any of the
 * test cases. If your code infinitely loops, you will get no credit for that function.
 * If your code does not compile or it throws exceptions, there will be a heavy penalty.
 */
public class HW2Bases
{
	/**
	 * strdtoi - Decimal String to int
	 *
	 * Convert a string containing ASCII characters (in decimal) to an int.
	 * You do not have to handle negative numbers. The Strings we will pass in will be
	 * valid decimal numbers, and able to fit in a 32-bit signed integer.
	 * 
	 * Example: strdtoi("123"); // => 123
	 */
	public static int strdtoi(String decimal)
	{
		int val = 0;
		int mag = 1;
		for (int i = decimal.length()-1; i>=0 && decimal.charAt(i) != ' '; i--){
			val += (decimal.charAt(i)-48)*mag;
			mag*=10;
		}
		
		return val;
	}

	/**
	 * strbtoi - Binary String to int
	 *
	 * Convert a string containing ASCII characters (in binary) to an int.
	 * You do not have to handle negative numbers. The Strings we will pass in will be
	 * valid binary numbers, and able to fit in a 32-bit signed integer.
	 * 
	 * Example: strbtoi("111"); // => 7
	 */
	public static int strbtoi(String binary)
	{
		int val = 0;
		int base = 1;
		for (int i = binary.length() - 1; i >= 0 && binary.charAt(i) != ' '; i--) {
			val += (binary.charAt(i) - 48) * base;
			base *= 2;
		}
		return val;
	}

	/**
	 * strxtoi - Hexadecimal String to int
	 *
	 * Convert a string containing ASCII characters (in hex) to an int.
	 * You do not have to handle negative numbers. The Strings we will pass in will be
	 * valid hexadecimal numbers, and able to fit in a 32-bit signed integer.
	 * 
	 * NOTE: Hexadecimal numbers are typically prefixed with a "0x". However, for the
	 * sake of this assignment, the strings passed into this function will not have
	 * this prefix.
	 * 
	 * Example: strxtoi("A6"); // => 166
	 */
	public static int strxtoi(String hex)
	{
		int val = 0;
		int base = 1;
		for (int i = hex.length() - 1; i >= 0 && hex.charAt(i) != ' '; i--) {
			if(hex.charAt(i) > 64){
				val += (hex.charAt(i) - 55) * base; //if decimal value of the ASCII is greater
				base *= 16;							//than 64, that means the char is a letter
			}										//subtract 55 to get its value in hex
			else{
				val += (hex.charAt(i) - 48) * base;
				base *= 16;
			}
		}
		return val;
	}

	/**
	 * itostrb - int to Binary String
	 *
	 * Convert a int into a String containing ASCII characters (in binary).
	 * You do not have to handle negative numbers.
	 * The String returned should contain the minimum number of characters necessary to
	 * represent the number that was passed in.
	 * 
	 * Example: itostrb(7); // => "111"
	 */
	public static String itostrb(int binary)
	{
		String bin = "";
		String retBin = "";
		bin += binary % 2;
		binary /= 2;
		for(; binary > 0; binary /= 2){
			bin += binary % 2;
		}
		for(int i = bin.length()-1; i >=0; i--){
			retBin += bin.charAt(i);
		}
		return retBin;
	}

	/**
	 * itostrx - int to Hexadecimal String
	 *
	 * Convert a int into a String containing ASCII characters (in hexadecimal).
	 * You do not have to handle negative numbers.
	 * The String returned should contain the minimum number of characters necessary to
	 * represent the number that was passed in.
	 * 
	 * NOTE: Hexadecimal numbers are typically prefixed with a "0x". However, for the
	 * sake of this assignment, the answers returned by this function should not have
	 * this prefix.
	 * 
	 * Example: itostrx(166); // => "A6"
	 */
	public static String itostrx(int hex)
	{
		String hx = "";
		String retHex = "";
		char ch = 0;
		if(hex%16 > 9){
			hx += (char) ((hex % 16)+55);
		}else
			hx += hex % 16;
		hex /= 16;
		for(; hex > 0; hex /= 16){
			if(hex%16 > 9){
				hx += (char) ((hex % 16)+55);
			}else
				hx += (hex % 16);
		}
		for(int i = hx.length()-1; i >=0; i--){
			retHex += hx.charAt(i);
		}
		return retHex;
		
	}
}

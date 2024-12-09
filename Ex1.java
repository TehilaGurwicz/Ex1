//package assignments.ex1;
/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    public static int po (int x, int y){
        int ans =1;
        for (int i = 0; i<y; i++){
            ans = ans *x;
        }
        return ans;
    }
    private static int char2int(char c)
    {
        char[] nums = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G'};
        for (int i = 0; i<nums.length;i++)
        {
            if(nums[i]==c){return i;}
        }
        return -1;
     }
     private static boolean is_digits (String c)
     {
         for (char s: c.toCharArray())
         {
            if(!Character.isDigit((s)))
            {  return false;}
         }
         return true;
     }
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
       // int ans = -1;
        if (!isNumber(num)){return  -1;}
        if(is_digits(num)){return Integer.parseInt(num);}
        String num_Value = num.substring(0,num.indexOf("b"));
        char base = num.charAt(num.indexOf("b")+1);
        int sum = 0;
        int power = num_Value.length()-1;
        for (char c: num_Value.toCharArray())
        {
            sum = sum + (char2int(c)*po(char2int(base),power));
            power--;
        }
        return sum;
    }
    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * @param num1 a String representing a number
     * @return true iff the given String is in a number format
     */

    public static boolean isNumber(String num1) {
        boolean ans = true;
        if (is_digits(num1)){return true;}// return true if only digits (decimal)
        char base = num1.charAt(num1.indexOf("b")+1);
        String num_Value = num1;
        if(num1.contains("b"))
        { num_Value = num1.substring(0,num1.indexOf("b"));}
        int countb = 0;
        for (char c: num_Value.toCharArray())// loop on string and checks different statements
        {
            if(char2int(c)>=char2int(base)) {return false;}
            if (c=='b'){countb++;}
            if (countb>1){return false;}
            if(char2int(c)==-1&&c=='b'){return false;}
        }
        if (num1.indexOf("b")!=num1.length()-2){return false;}
        if(char2int(base)==-1){return false;}
        return ans;
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        StringBuilder bld = new StringBuilder();
        String temp_str = String.valueOf(num);
        while (num!=0)
        {
           bld.append(num % base);
           num =  num/base;
        }
        bld.reverse();
        bld.append("b");
        bld.append(base);
        return bld.toString();
    }
    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        return number2Int(n1)==number2Int(n2);
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     */
    public static int maxIndex(String[] arr)
    {
        int ans = 0;

        for(int i = 0; i<=arr.length-1;i++)
        {
            if (number2Int(arr[i])>number2Int(arr[ans]))
            {
                ans = i;
            }
        }
        return ans;
    }
}

package credictcardnum;
import java.util.*;
/**
 *
 * @author Shifeng Yuan, GWid: G32115270
 */
public class CredictCardNum {
    
    public static Boolean isValid(long number){                                
     //Return if the card number is valid
        long Sum = sumOfOddPlace(number) + sumOfDoubleEvenPlace(number);
        if((Sum % 10 == 0)&&(ValidPrefix(number))&&(getSize(number) >= 13)&&(getSize(number) <= 16))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static boolean ValidPrefix(long number){
        long digit1 = getPrefix(number, 2);
        long digit2 = getPrefix(number, 3);
        
        if(digit1 == 4){
            return true;
        }
        else if(digit1 == 5){
            return true;
        }
        else if(digit2 == 37){
            return true;
        }
        else if(digit1 == 6){
            return true;
        }
        else{
            return false;
        }
                
    }
    public static int sumOfDoubleEvenPlace( long number ){                    
    //Get the result from step 2
        if(number < 10){
            return 0; 
        }
        else{
            long dep = number % 100;
            if(dep<10){
                return 0 + sumOfDoubleEvenPlace(number / 100);
            }
            else{
                dep = dep / 10;
                dep = dep * 2;
                return getDigit(dep)+ sumOfDoubleEvenPlace(number / 100);
            }
            
        }

    }
    public static int getDigit( long number ){                                  
    //Return this number it is a single digit, otherwise, return the sum of the two digits
        if(number < 10){
            return (int)number;
        }
        else{
            long Tdgt = number % 10;
            return getDigit(number / 10) + (int) Tdgt;
        }
    }
    public static int sumOfOddPlace( long number ){                            
    //Return sum of sumOfOddPlace( long number )
        int sop = (int)(number % 100 % 10);
        if(number < 10){
            return (int)number;
        }
        else
            return sumOfOddPlace(number / 100) + sop;
    }
    public static int getSize( long number ){                                  
    //Return the number of digits in digit
        
        if(number<10){
            
            return 1;
        }
        else{
            
            return getSize(number / 10) + 1;
        }
    }
    public static int getPrefix( long number, int k ){                        
    //Return the first k number of digits from the number. 
    //If the number of digits in number is less than k, return number
        long Prfx = number;
        if(getSize(Prfx) < k){
            return (int)Prfx;
        }
        else{
            return getPrefix(number / 10, k);
        }
        
    }
    public static void main(String[] args) {
        while(true){
            Scanner scan =  new Scanner(System.in);
            System.out.println("Enter a credit card number as a long integer:");
            long number = scan.nextLong();             // Get the card number
            boolean cardnum = isValid(number);
            if (cardnum == true)
                System.out.println(number + "is a valid credit card number.");
            else
                System.out.println(number + "is not a valid credit card number");
        }    
    }
    
}

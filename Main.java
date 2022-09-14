package mortgage;

// Import required utility classes
import java.util.Scanner;   // To take input from user
import java.lang.Math;      // To perform math functions like rounding up numbers
import java.text.NumberFormat;  // To format amount into currency formats


public class Main {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);

        final byte months_in_years = 12;
        final byte percentage = 100;

        // Prompt user to enter principal amount
        System.out.println("Enter your Principal amount:");

        // Assign the obtained principal to a variable
        int principal = myScan.nextInt();

        // Prompt user to enter interest rate
        System.out.println("Please, enter your annual interest rate (%):");

        // Assign the interest rate obtained to a variable
        float annual_interest_rate = myScan.nextFloat();

        // Convert the annual interest rate to monthly interest rate
        float monthly_interest_rate = annual_interest_rate / percentage / months_in_years;

        //Prompt user to enter a loan tenor
        System.out.println("Please, enter your mortgage tenor:");

        //Assign the obtained tenor to a variable;
        float periodInYears = myScan.nextFloat();

        // Get the number of monthly payments required through-out the entire tenor of the loan
        float numberOfPayments = periodInYears * months_in_years;

        // Reassign all calculated values to single letter variables to make calculation easy to read
        float n = numberOfPayments;
        float r = monthly_interest_rate;
        int p = principal;

        // Perform the actual mortgage calculation
        double oldMortgage = p * (r *(Math.pow( 1 + r , n))/(Math.pow( 1 + r , n )-1));

        // Round answer to 2 decimal places
        double newMortgage = (Math.round(oldMortgage * 100));
        double mortgage = newMortgage / 100;

        // Format answer to add currency symbol
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        // Print result
        System.out.println(mortgageFormatted);


    }
}
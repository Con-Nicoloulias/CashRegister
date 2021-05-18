package source;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CashRegister
{
   public static void main(String[] args)
   {

    System.out.println("Welcome to the CAA Bar");

      String s, c = "",total = "", input = "", more="n", calcF ="", r="", q = "";
      double balance, calc=0, tenderAmt =0, qInt = 0, finalCost =0;
      int points =30;
      double itemCost = 0, itemTotal, cost =0;  
      ArrayList<String> myItems = new ArrayList<String>();
      ArrayList<Integer> myItemCosts = new ArrayList<Integer>();



      Scanner in = new Scanner(System.in);
      
      System.out.print("Please enter cash register's float:");
      s = in.nextLine();
      
      
      balance = Double.parseDouble(s);
      while (balance <0)
      {
        System.out.println("Invalid Input");

        System.out.print("Please enter cash register's float:");
          s = in.nextLine();
          balance = Double.parseDouble(s);

      }
      while(input.equals("y")== false)
      { 
      System.out.println("Do you want to exit (y/n)?");
      input = in.nextLine();
      if(input.equals("n") == false && input.equals("y") == false)
      {
        System.out.print("Invalid Input");

        System.out.println("Do you want to exit (y/n)?");
          input = in.nextLine();
      }
      
        
      if(input.equals("n") )
      {
        
        System.out.println("Drink Item List:\nFireball\nAlize\nVanilla Galliano\nVodka\nScotch\nCider\nBeer\nSoju\n");
        
        
          myItems.clear();
          calc =0;
          total = "";
          calcF = "";
          itemCost =0;

        while(more.equals("n"))
        {
          
           System.out.print("Please enter the item's name:");
             s = in.nextLine();
             
        if (s.equals("Fireball") || s.equals("Alize") || s.equals("Vanilla Galliano") || s.equals("Vodka")
            || s.equals("Scotch") || s.equals("Cider") || s.equals("Beer") || s.equals("Soju")) {
  
       
          myItems.add(s);
          System.out.print("Please enter the item's cost:");
          c = in.nextLine();
          cost = Double.parseDouble(c);
          while (cost <0)
          {
            System.out.println("Invalid Input");

              System.out.print("Please enter the item's cost:");
              c = in.nextLine();
              cost = Double.parseDouble(c);

          }
          
          System.out.print("How many would you like to buy:");
          q = in.nextLine();
          qInt = Double.parseDouble(q);
          while (qInt <0)
          {
            System.out.println("Invalid Input");

              System.out.print("How many would you like to buy:");
              q = in.nextLine();
              qInt = Double.parseDouble(q);
              

          }
          finalCost =  (qInt * cost);
          myItemCosts.add((int) finalCost);
          itemCost = itemCost + finalCost ;
          
          System.out.println("Are all items entered (y/n)?");
          more = in.nextLine();
          if(more.equals("n") == false && more.equals("y") == false)
          {
            System.out.print("Invalid Input");

            System.out.println("Do you want to exit (y/n)?");
              more = in.nextLine();
          }
        }
        else {
        System.out.println("Must enter a drink from the Drink Item List");
      }
        }
          
        for(int i=0; i< myItems.size();i++)
        {
          calc += myItemCosts.get(i);
        }
          

          Transaction trans = new Transaction(s, Double.parseDouble(c));

          System.out.print("Please enter the cash amount tendered:");
          s = in.nextLine();
          tenderAmt = Double.parseDouble(s);

          while (tenderAmt <0)
          {
            System.out.println("Invalid Input");

              System.out.print("Please enter the cash amount tendered:");
              s = in.nextLine();
              tenderAmt = Double.parseDouble(s);

          }
          
          
          calcF = Double.toString(Double.parseDouble(s) - calc);
          if((tenderAmt - calc) < 0)
          {
            System.out.println("You need to pay $" + calcF+ " amount more!");
          }
          else
          {
          System.out.println("Amount of change required = $" + calcF);
          }

          if(points >= 20)
          {
                System.out.println("You got the discount coupon for 10% off on any drinks!"); 
          }
         
          System.out.println("Do you want a receipt:");
          r = in.nextLine();
          {
            if(r.equals("y"))
            {
              
              System.out.println("------------------------");
              System.out.println("Items...");
              for(int i=0; i< myItems.size();i++)
                {
                 System.out.println(myItems.get(i) + "------------ $"+ myItemCosts.get(i ));
                 calc += myItemCosts.get(i);
                 total = Double.toString(itemCost); 
                }
              
              System.out.println("Total---------------------------$" + total);
              System.out.println("Amount tendered-----------------$" + s);
              System.out.println("Change--------------------------$" + calcF);
              System.out.println("You have " + points + "points. Please see the staff to redeem it!");
              System.out.println("------------------------------------------------------------------");
              
              points = (int)itemCost;
 
            
              
            }
          }
          total = Double.toString(balance + itemCost);
          more = "n";

      }
      
      else if (input.equals("y"))
      {
      
        System.out.println("See ya next time!");
      }
      }
      if (total.equals("")) {
        System.out.println("Balance of the Cash Register:" + balance);
      }
      else {
      System.out.println("Balance of the Cash Register: $" + total);    
      }
      }
      
      


   }



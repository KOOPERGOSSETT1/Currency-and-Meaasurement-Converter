import java.util.*;
class Main {
  public static void main(String[] args) {
    CurrencyConverter w = new CurrencyConverter();
        w.setVisible(true);

    Scanner s = new Scanner(System.in);
    System.out.println("Please type your name below: ");
    String y=s.nextLine();
    System.out.println("\nHello "+y+", this is a currency converter for your use. Choose which currency you would like to convert from and to, and type the amount that you would like to convert. Click on the solve button. This will automaticly convert the currencies and show you the answers. ");
  }
}
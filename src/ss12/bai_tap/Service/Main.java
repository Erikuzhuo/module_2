package ss12.bai_tap.Service;

import ss12.bai_tap.Controller.ProductManagment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManagment products = new ProductManagment();
        Scanner scanner = new Scanner(System.in);
       while(true) {
           System.out.println("Kindly input your option number: \n" +
                   "1. Create Product.\n" +
                   "2. Update Product.\n" +
                   "3. Remove Product.\n" +
                   "4. View Product List.\n" +
                   "5. Exit.\n" +
                   "Your Option:　");
           byte option = Byte.parseByte(scanner.nextLine());
           switch (option) {
               case 1:
                   products.createProduct();
                   products.sortList();
                   break;
               case 2:
                   products.updateProduct();
                   products.sortList();
                   break;
               case 3:
                   products.removeProduct();
                   products.sortList();
                   break;
               case 4:
                   products.displayProducts();
                   break;
               case 5:
                   System.exit(0);
           }
       }
    }
}

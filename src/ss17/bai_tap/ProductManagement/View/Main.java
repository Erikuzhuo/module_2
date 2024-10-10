package ss17.bai_tap.ProductManagement.View;
import java.util.Scanner;
import ss17.bai_tap.ProductManagement.Controller.ProductControl;



public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            ProductControl productControl = new ProductControl();
            System.out.println("1. Create Product.\n" +
                    "2. Delete Product.\n" +
                    "3. Update Product.\n" +
                    "4. Display Product.\n" +
                    "5. Exit.\n" +
                    "Kindly Choice Your Option Number: ");
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    productControl.addProduct();
                    break;
                case 2:
                    productControl.deleteProduct();
                    break;
                case 3:
                    productControl.updateProduct();
                    break;
                case 4:
                    productControl.displayProduct();
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}

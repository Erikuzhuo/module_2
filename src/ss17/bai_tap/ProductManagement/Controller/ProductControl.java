package ss17.bai_tap.ProductManagement.Controller;

import ss17.bai_tap.ProductManagement.Model.Product;

import java.util.*;

import static ss17.bai_tap.ProductManagement.Controller.MyFile.*;


public class ProductControl {
    Scanner scanner = new Scanner(System.in);
    List<Product> productList = readListFromFile();

    public void addProduct() {
        if (!productList.isEmpty()) {
            productList = new ArrayList<>();
        }
        System.out.println("How many product need to input? ");
        int count = Integer.parseInt(scanner.nextLine());
        Product[] tempList = new Product[count];
        String confirm;
        do {
            for (int i = 0; i < tempList.length; i++) {
                Product product = new Product();
                String tempID;
                do {
                    System.out.println("Input ID of Product " + (i + 1) + ". Or you can type 0 for back to Menu.");
                    tempID = scanner.nextLine();
                    if (Objects.equals(tempID, "0")) {
                        return;
                    }
                } while (checkProductExist(productList, tempID) || checkProductExist(tempList, tempID));
                product.setId(tempID);
                System.out.println("Input name of Product " + (i + 1) + ".");
                product.setName(scanner.nextLine());
                System.out.println("Input price of Product " + (i + 1) + ".");
                product.setPrice(Double.parseDouble(scanner.nextLine()));
                System.out.println("Input product type of Product " + (i + 1) + ".");
                product.setProductType(scanner.nextLine());
                System.out.println("Input description of Product " + (i + 1) + ".");
                product.setDescription(scanner.nextLine());
                tempList[i] = product;
            }
            System.out.println("Kindly Confirm for new product list below. (Y/N)\n" +
                    Arrays.toString(tempList));
            confirm = scanner.nextLine();

        } while (!confirmProcess(confirm));
        Collections.addAll(productList, tempList);
        clearFile();
        writeListToFile(productList);
        System.out.println("Products successfully created.");
    }

    public void deleteProduct() {
        if (!productList.isEmpty()) {
            String tempID, confirm;
            Product removeProduct = null;
            do {
                do {
                    System.out.println("Input ID you want to Delete or O to back to Menu.");
                    tempID = scanner.nextLine();
                    if (Objects.equals(tempID, "0")) {
                        return;
                    }
                } while (!checkProductExist(productList, tempID));

                for (Product checkProduct : productList) {
                    if (Objects.equals(checkProduct.getId(), tempID)) {
                        removeProduct = checkProduct;
                    }
                }
                System.out.println("Are you sure want to delete this Product? (Y/N): \n" + removeProduct);
                confirm = scanner.nextLine();
            } while (!confirmProcess(confirm));
            productList.remove(removeProduct);
            clearFile();
            writeListToFile(productList);
            displayProduct();
            System.out.println("Product successfully deleted.");
        } else System.out.println("File is empty");
    }

    public void updateProduct() {
        if (!productList.isEmpty()) {
            String tempID, confirm;
            Product updateProduct = null;
            int index = 0;
            do {
                do {
                    System.out.println("Input ID you want to Delete or O to back to Menu.");
                    tempID = scanner.nextLine();
                    if (Objects.equals(tempID, "0")) {
                        return;
                    }
                } while (!checkProductExist(productList, tempID));

                for (Product checkProduct : productList) {
                    if (Objects.equals(checkProduct.getId(), tempID)) {
                        updateProduct = checkProduct;
                        index = productList.indexOf(checkProduct);
                    }
                }
                System.out.println("ID is fixed element can not adjust. Kidnly input update name for " +
                        updateProduct.getName());
                updateProduct.setName(scanner.nextLine());
                System.out.println("Input update price for " + updateProduct.getPrice());
                updateProduct.setPrice(Double.parseDouble(scanner.nextLine()));
                System.out.println("Input update product type for " + updateProduct.getProductType());
                updateProduct.setProductType(scanner.nextLine());
                System.out.println("Input update description for" + updateProduct.getDescription());
                updateProduct.setDescription(scanner.nextLine());
                System.out.println("Are you sure want to update this? (Y/N): \n" + updateProduct);
                confirm = scanner.nextLine();
            } while (!confirmProcess(confirm));
            productList.set(index, updateProduct);
            clearFile();
            writeListToFile(productList);
            System.out.println("Product successfully updated.");
        } else System.out.println("File is empty");
    }

    public void displayProduct() {
        if (productList.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product show : productList) {
                System.out.println(show + "\n");
            }
        }
    }

    public boolean checkProductExist(Product[] list, String id) {
        boolean check = false;
        for (Product checkProduct : list) {
            if (checkProduct != null && Objects.equals(checkProduct.getId(), id)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public boolean checkProductExist(List<Product> list, String id) {
        boolean check = false;
        for (Product checkProduct : list) {
            if (checkProduct != null && Objects.equals(checkProduct.getId(), id)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public boolean confirmProcess(String confirm) {
        return Objects.equals(confirm, "Y") || Objects.equals(confirm, "y");
    }
}

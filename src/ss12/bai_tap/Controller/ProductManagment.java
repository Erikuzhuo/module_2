package ss12.bai_tap.Controller;

import ss12.bai_tap.Model.Product;

import java.util.*;


public class ProductManagment {
    Scanner scanner = new Scanner(System.in);
    List<Product> products = new LinkedList<>();


    public void displayProducts() {
        System.out.println("List of products:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void createProduct() {
        System.out.println("Input amount of product that you will create: ");
        int numberOfNewProduct = Integer.parseInt(scanner.nextLine());
        String confirm;
        Product[] tempList = new Product[numberOfNewProduct];
        do {
            for (int i = 0; i < tempList.length; i++) {
                tempList[i] = new Product();
                System.out.println("Kindly input id of product " + (i + 1) + ":");
                String tempID = scanner.nextLine();
                for (int j = 0; j <= i; j++) {
                    while (tempID.isEmpty() || Objects.equals(tempList[j].getId(), tempID)) {
                        System.out.println("Kindly re-input the id OR input 0 to exit: ");
                        tempID = scanner.nextLine();
                        if (Objects.equals(tempID, "0")) {
                            return;
                        }
                    }
                }
                while (isProductIDExist(tempID)) {
                    System.out.println("ID duplicate, kindly re-input the id OR input 0 to exit: ");
                    tempID = scanner.nextLine();
                    if (Objects.equals(tempID, "0")) {
                        return;
                    }
                }
                tempList[i].setId(tempID);
                do {
                    System.out.println("Kindly input name of product " + (i + 1) + ":");
                    tempList[i].setName(scanner.nextLine());
                } while (tempList[i].getName().isEmpty());
                do {
                    System.out.println("Kindly input unit type of product " + (i + 1) + ":");
                    tempList[i].setUnitType(scanner.nextLine());
                } while (tempList[i].getUnitType().isEmpty());
                do {
                    System.out.println("Kindly input unit price of product " + (i + 1) + ":");
                    try {
                        tempList[i].setUnitPrice(Double.parseDouble(scanner.nextLine()));
                    } catch (NumberFormatException e) {
                        tempList[i].setUnitPrice(-1.0);
                    }
                } while (tempList[i].getUnitPrice() < 0);
            }
            System.out.println("Do you confirm create bellowing product? (Y/N) ？");
            for (Product eachProduct : tempList) {
                System.out.println(eachProduct);
            }
            confirm = scanner.nextLine();
        } while (confirmProcess(confirm));
        Collections.addAll(products, tempList);
        System.out.println("Products has been created.");
    }

    public void removeProduct() {
        String confirm;
        Product productToRemove = new Product();
        do {
            System.out.println("Product ID need to remove: ");
            String removeID = scanner.nextLine();

            while (removeID.isEmpty() || !isProductIDExist(removeID)) {
                System.out.println("ID does not exist, Retype the ID or input 0 to exit.");
                removeID = scanner.nextLine();
                if (Objects.equals(removeID, "0")) {
                    return;
                }
            }
            for (Product removeProduct : products) {
                if (Objects.equals(removeProduct.getId(), removeID)) {
                    productToRemove = removeProduct;
                }
            }
            System.out.println("Are you sure want to remove? (Y/N) \n"
                    + productToRemove);
            confirm = scanner.nextLine();
        } while (confirmProcess(confirm));
        products.remove(productToRemove);
        System.out.println("Product has been removed.");
    }

    public void updateProduct() {
        String confirm;
        Product productToUpdate = new Product();
        do {
            System.out.println("Input ID of product that need to update:　");
            String updateID = scanner.nextLine();
            while (Objects.equals(updateID, "") || !isProductIDExist(updateID)) {
                System.out.println("ID does not exist, Retype the ID or input 0 to exit.");
                updateID = scanner.nextLine();
                if (Objects.equals(updateID, "0")) {
                    return;
                }
            }
            for (Product check : products) {
                if (Objects.equals(check.getId(), updateID)) {
                    productToUpdate = check;
                }
            }
            System.out.println("Is this product that you want to update? (Y/N) \n" +
                    productToUpdate);
            confirm = scanner.nextLine();
        } while (confirmProcess(confirm));
        do {
            System.out.println("Product ID can not be change, kindly input update name: ");

            productToUpdate.setName(scanner.nextLine());
            System.out.println("Input update type of unit: ");
            productToUpdate.setUnitType(scanner.nextLine());
            System.out.println("Input update unit price: ");
            productToUpdate.setUnitPrice(Double.parseDouble(scanner.nextLine()));
            System.out.println("Is this product new update information? (Y/N) \n" +
                    productToUpdate);
            confirm = scanner.nextLine();
        } while (confirmProcess(confirm));
        for (Product change : products) {
            if (Objects.equals(change.getId(), productToUpdate.getId())) {
                change.setName(productToUpdate.getName());
                change.setUnitPrice(productToUpdate.getUnitPrice());
                change.setUnitPrice(productToUpdate.getUnitPrice());
            }
        }
        System.out.println("Product Updated.");
    }

    public boolean isProductIDExist(String id) {
        for (Product product : products) {
            if (Objects.equals(product.getId(), id)) {
                return true;
            }
        }
        return false;
    }

    public boolean confirmProcess(String confirm) {
        return !Objects.equals(confirm, "Y");
    }

    public void sortList() {
        for (int i = 0; i < products.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < products.size(); j++) {
                if (products.get(j).getId().compareTo(products.get(minIndex).getId()) < 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                Product temp = products.get(i);
                products.set(i, products.get(minIndex));
                products.set(minIndex, temp);
            }
        }

        System.out.println("Products have been sorted by ID.");
    }
}

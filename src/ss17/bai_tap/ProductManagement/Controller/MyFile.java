package ss17.bai_tap.ProductManagement.Controller;

import ss17.bai_tap.ProductManagement.Model.Product;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class MyFile {
    private static final String PARENT_PATH = "src/ss17/bai_tap/ProductManagement/File";

    public static void writeListToFile(List<Product> productList) {
        File file = new File(PARENT_PATH, "ProductList.csv");
        try {
            if(!file.exists()) {
                file.createNewFile();
                System.out.println("File has been Created");
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productList);
            System.out.println("File has been Updated");
            objectOutputStream.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static List<Product> readListFromFile() {
        List<Product> productList = new ArrayList<>();
        try {
            File file = new File(PARENT_PATH, "ProductList.csv");
            if (file.length() > 0) {
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                productList = (List<Product>) objectInputStream.readObject();
                objectInputStream.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }
    public static void clearFile(){
            File file = new File(PARENT_PATH, "ProductList.csv");
        try {
            FileOutputStream fileOutputStream   = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeByte(0);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

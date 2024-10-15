package ss16.bai_tap.CustomerData.Controller;

import ss16.bai_tap.CustomerData.Model.Customer;
import ss17.bai_tap.ProductManagement.Controller.MyFile;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerData {
    public static final String PARENT_PATH = "src/ss16/bai_tap/CustomerData/File";

    public static List<Customer> readFromFile() {
        List<Customer> customerList = new ArrayList<>();
        File file = new File(PARENT_PATH, "CustomerData.csv");
        try {
            if (!file.exists()) {
                System.out.println("File do not exist. Creating now!");
                file.createNewFile();
                System.out.println("File Created. Reading...");
            } else System.out.println("File exist. Reading...");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] customerString = line.split(",");
                if (customerString.length == 4) {
                    String id = customerString[0].replace("Customer\\{id='","").replace("'","");
                    String name = customerString[1].replace("name='","").replace("'","");
                    LocalDate birthday = LocalDate.parse(customerString[2].replace(" birthday='","").replace("'",""));
                    String address = customerString[3].replace(" address='","").replace("'}","");

                    Customer customer = new Customer(id, name, birthday, address);
                    customerList.add(customer);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return customerList;
    }

    public static void writeToFile(List<Customer> list) {
        File file = new File(PARENT_PATH, "CustomerData.csv");
        try {
            if (!file.exists()) {
                System.out.println("File do not exist. Creating now!");
                file.createNewFile();
                System.out.println("File Created. Writing...");
            } else System.out.println("File exist. Writing...");

            FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i)!=null){
                    bufferedWriter.write(String.valueOf(list.get(i)));
                    bufferedWriter.newLine();
                    System.out.println(bufferedWriter);
                }
            }bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

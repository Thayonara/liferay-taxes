package program;

import goods.Product;
import goods.ProductType;
import receipts.Receipt;
import receipts.ReceiptGenerator;
import receipts.Sale;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {



    public static void main (String[] args) {
        try {
            List<Sale> sales = new ArrayList<Sale>();
            File myObj = new File("input_2.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] line = data.split(" ");

                String good = (data.substring(data.indexOf(" "), data.indexOf(" por "))).trim();
                int quantity = Integer.parseInt(line[0]);
                BigDecimal value = new BigDecimal(line[line.length-1].replace(",",".").replace("$",""));


                 boolean isImported = data.contains("importado") ||
                        data.contains("importada") ||
                        data.contains("importados") ||
                        data.contains("importadas");

                ProductType type = ProductType.GENERAL;


                sales.add(new Sale(new Product(good, value, value, type, isImported),
                                    new BigDecimal(quantity)));
            }

            Receipt receipt = new ReceiptGenerator(sales).execute();
            System.out.println(receipt.getDescription() +
                    "\n Imposto sobre as vendas: $" +  String.format("%.2f",receipt.getTax()) +
                    "\n Total: $" + String.format("%.2f", receipt.getTotal()));
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

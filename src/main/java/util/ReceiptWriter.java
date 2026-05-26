package util;

import models.DrinksAndChips;
import models.Order;
import models.Pizza;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {


        public static void saveReceipt(Order order) {

            try {

                // generate filename
                String timestamp = generateTimestamp();

                String fileName =
                        "src/main/resources/receipts/"
                                + timestamp
                                + ".txt";

                // create writers
                FileWriter fileWriter = new FileWriter(fileName);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                // receipt header
                bufferedWriter.write("====== PIZZA RECEIPT ======\n\n");

                // write pizzas
                for(Pizza pizza : order.getPizzas()) {

                    bufferedWriter.write(pizza.getSummary());
                    bufferedWriter.write("\n-------------------\n");
                }

                // write drinks
                bufferedWriter.write("\nDrinks:\n");

                for(DrinksAndChips drink : order.getDrinks()) {
                    bufferedWriter.write(drink.getSummary() + "\n");
                }

                // write chips
                bufferedWriter.write("\nChips:\n");

                for(DrinksAndChips chip : order.getChips()) {
                    bufferedWriter.write(chip.getSummary() + "\n");
                }

                // write total
                bufferedWriter.write("\nTotal: $" + order.getTotal());

                // close writer
                bufferedWriter.close();

                System.out.println("Receipt saved successfully.");

            }
            catch(IOException e) {

                System.out.println("Error writing receipt.");
            }
        }

        private static String generateTimestamp() {

            LocalDateTime now = LocalDateTime.now();

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

            return now.format(formatter);
        }
    }


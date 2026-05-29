package util;

import models.DrinksAndKnots;
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
                        "src/main/resources/receipts"
                                + timestamp
                                + ".txt";

                // create writers
                FileWriter fileWriter = new FileWriter(fileName);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                // receipt header
                bufferedWriter.write("========================================\n");
                bufferedWriter.write("              PIZZA LICIOUS\n");
                bufferedWriter.write("========================================\n");

                bufferedWriter.write(" Store #101   Dallas, TX\n\n");
                bufferedWriter.write(" Store Number  (214) 555-1234\n\n");

                bufferedWriter.write(" Order #1001   POS Pulse\n\n");

                bufferedWriter.write(    " " + generateDateTime() + "\n\n");

                bufferedWriter.write(" Cashier: LT | Register: 01\n\n");

                bufferedWriter.write("----------------------------------------\n\n");

                bufferedWriter.write(" PIZZAS\n");
                bufferedWriter.write("----------------------------------------\n\n");

                for (Pizza pizza : order.getPizzas()) {

                    bufferedWriter.write(
                            String.format("%-30s $%.2f%n",
                                    pizza.getSize().toUpperCase() + " " +
                                            pizza.getCrustLevel().toUpperCase() + " PIZZA",
                                    pizza.getPrice())
                    );

                    if (pizza.isStuffedCrust()) {
                        bufferedWriter.write(" Stuffed Crust\n");
                    }

                    bufferedWriter.write(" Sauce: " + pizza.getSauces() + "\n");
                    bufferedWriter.write(" Cheese: " + pizza.getCheeses() + "\n");
                    bufferedWriter.write(" Meats: " + pizza.getMeats() + "\n");
                    bufferedWriter.write(" Toppings: " + pizza.getToppings() + "\n\n");
                }

                bufferedWriter.write("----------------------------------------\n\n");

                bufferedWriter.write(" DRINKS\n");
                bufferedWriter.write("----------------------------------------\n\n");

                for (DrinksAndKnots drink : order.getDrinks()) {

                    bufferedWriter.write(
                            String.format("%-30s $%.2f%n",
                                    drink.getSize() + " " + drink.getName(),
                                    drink.getPrice())
                    );
                }

                bufferedWriter.write("\n----------------------------------------\n\n");

                bufferedWriter.write(" GARLIC KNOTS\n");
                bufferedWriter.write("----------------------------------------\n\n");

                for (DrinksAndKnots knot : order.getKnots()) {

                    bufferedWriter.write(
                            String.format("%-30s $%.2f%n",
                                    knot.getSize() + " " + knot.getName(),
                                    knot.getPrice()));
;
                }

                bufferedWriter.write("\n----------------------------------------\n\n");

                bufferedWriter.write(
                        String.format("%-30s $%.2f%n",
                                "Subtotal",
                                order.getTotal()) + "\n"
                );

                double tax = order.getTotal() * .0825;

                bufferedWriter.write(
                        String.format("%-30s $%.2f%n",
                                "Tax (8.25%)",
                                tax) + "\n"
                );

                bufferedWriter.write("----------------------------------------\n");

                bufferedWriter.write(
                        String.format("%-30s $%.2f%n",
                                "TOTAL",
                                order.getTotal() + tax));

                bufferedWriter.write("----------------------------------------\n\n");

                bufferedWriter.write(" Payment: Cash\n\n");

                bufferedWriter.write("========================================\n\n");

                bufferedWriter.write("       THANK YOU FOR VISITING!\n\n");
                System.out.println("\n");

                bufferedWriter.write("        FRESH • HOT • DELICIOUS\n\n");

                bufferedWriter.write("        www.pizzalicious.com\n\n");

                bufferedWriter.write("========================================\n");

                bufferedWriter.close();




            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        public static String generateDateTime() {

            LocalDateTime now = LocalDateTime.now();

            DateTimeFormatter dateFormatter =
                    DateTimeFormatter.ofPattern("MM/dd/yyyy");

            DateTimeFormatter timeFormatter =
                    DateTimeFormatter.ofPattern("hh:mm a");

            return "Date: "
                    + now.format(dateFormatter)
                    + " | Time: "
                    + now.format(timeFormatter);

        }
        public static String generateTimestamp() {

            LocalDateTime now = LocalDateTime.now();

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

            return now.format(formatter);
        }
    }


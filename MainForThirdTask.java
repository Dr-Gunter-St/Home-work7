package HW7;

import java.util.*;

public class MainForThirdTask {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();

        long[] arrOfIds = {1l, 2l, 2l, 4l, 5l, 5l, 7l, 8l, 9l, 10l};
        String[] arrOfNames = {"Jack", "Bob", "Bob", "Henric", "Vincent", "Vincent", "Lara", "Jennifer", "Adam", "Barak"};
        String[] arrOfSurnames = {"Jonson", "Jackson", "Jackson", "Mumphrey", "Mordekay", "Mordekay", "Humpfrey", "Not-Sure", "Petrov", "Obama"};
        String[] arrOfCities = {"Miami", "Pasadena", "Pasadena", "Kansas", "Ust-Izhevks", "Ust-Izhevks", "New Orlean", "New York", "Manchester", "Washington"};
        int[] balances = {100, 200, 200, 400, 500, 500, 700, 800, 900, 1000};

        for (int i = 0; i < 10; i++) {
            userList.add(new User(arrOfIds[i], arrOfNames[i], arrOfSurnames[i], arrOfCities[i], balances[i]));
        }

        Set<Order> treeSet = new TreeSet<>();

        long[] arrOfOrderIds = {1l, 2l, 2l, 4l, 5l, 5l, 7l, 8l, 9l, 10l};
        int[] prices = {10, 20, 20, 40, 50, 50, 70, 80, 90, 100};
        Currency[] arrOfCurrencies = {Currency.getInstance("USD"), Currency.getInstance("UAH"), Currency.getInstance("UAH"), Currency.getInstance("EUR"), Currency.getInstance("USD"),
                Currency.getInstance("USD"), Currency.getInstance("USD"), Currency.getInstance("EUR"), Currency.getInstance("UAH"), Currency.getInstance("EUR")};
        String[] arrOfItems = {"Bed", "Chair", "Chair", "Sink", "Mirror", "Mirror", "Mouse", "CPU", "Process", "Stream", "Paul-the-Slave"};
        String[] arrOfShops = {"IKEA", "IKEA", "IKEA", "IKEA", "IKEA", "IKEA", "Amazon", "InnerCompHW", "InnerCompIt", "InnerCompIt", "Amazon"};
        for (int i = 0; i < 10; i++) {
            Order order = new Order(arrOfOrderIds[i], prices[i], arrOfCurrencies[i], arrOfItems[i], arrOfShops[i], userList.get(i));
            treeSet.add(order);
         }

        System.out.print("print Order with largest price: ");
        System.out.println(treeSet.toArray()[0].toString());

        System.out.print("check if set contain Order where User’s lastName is - “Petrov”: ");
        System.out.println(findPetrov(treeSet));

        Iterator itr = treeSet.iterator();
        while (itr.hasNext()){
            Object element = itr.next();
            Order order = (Order) element;
            if (order.getCurrency().equals(Currency.getInstance("USD"))){
                itr.remove();
            }
        }

        System.out.println("delete orders where currency is USD using Iterator: ");
        System.out.println(Arrays.toString(treeSet.toArray()));
        }

        static boolean findPetrov(Set<Order> set) {
            for (Order o : set) {
                if (o.getUser().getLastName().equals("Petrov")) return true;
            }
            return false;
        }

    }

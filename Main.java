package HW7;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Order> list = new LinkedList<>();

        Random random = new Random();
        String[] arrOfItems = {"Bed", "Chair", "Table", "Sink", "Mirror", "Lamp", "Mouse", "CPU", "Process", "Stream", "Paul-the-Slave"};
        String[] arrOfShops = {"IKEA", "IKEA", "IKEA", "IKEA", "IKEA", "IKEA", "Amazon", "InnerCompHW", "InnerCompIt", "InnerCompIt", "Amazon"};
        String[] arrOfNames = {"Jack", "Bob", "Steve", "Henric", "Vincent", "Sam", "Lara", "Jennifer", "Adam", "Barak"};
        String[] arrOfSurnames = {"Jonson", "Jackson", "Kleet", "Mumphrey", "Mordekay", "Stevens", "Humpfrey", "Not-Sure", "Rudrum", "Obama"};
        String[] arrOfCities = {"Miami", "Pasadena", "Las Vegas", "Kansas", "Ust-Izhevks", "Boston", "New Orlean", "New York", "Manchester", "Washington"};
        for (int i = 0; i < 10; i++) {
            int currenc = random.nextInt(3);
            Currency currency;
            switch (currenc) {
                case 0:
                    currency = Currency.getInstance("USD");
                    break;
                case 1:
                    currency = Currency.getInstance("EUR");
                    break;
                case 2:
                    currency = Currency.getInstance("UAH");
                    break;
                default:
                    currency = Currency.getInstance("GBP");
                    break;
            }
            Order order = new Order(random.nextLong(), random.nextInt(10000), currency, arrOfItems[i], arrOfShops[i],
                    new User(random.nextLong(), arrOfNames[i], arrOfSurnames[i], arrOfCities[i], random.nextInt()));
            list.add(order);
        }
        Collections.sort(list, new FirstComparator());
        System.out.println(list);

        Collections.sort(list, new SecondComparator());
        System.out.println(list);

        Collections.sort(list, new ThirdComparator());
        System.out.println(list);

    }
}
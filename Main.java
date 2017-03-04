package HW7;

import sun.plugin.cache.OldCacheEntry;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

        //old way

        Collections.sort(list, new FirstComparator());
        System.out.println(list);

        Collections.sort(list, new SecondComparator());
        System.out.println(list);

        Collections.sort(list, new ThirdComparator());
        System.out.println(list);

        //new way

        Collections.sort(list, (a, b) -> {
            return b.getPrice() - a.getPrice();
        });
        System.out.println(list);

        Collections.sort(list, ((o1, o2) -> {
            if (o1.getPrice() - o2.getPrice() == 0) {
                return o1.getUser().getCity().compareTo(o2.getUser().getCity());
            }
            return o1.getPrice() - o2.getPrice();
        }));
        System.out.println(list);

        Collections.sort(list, ((o1, o2) -> {
            if (o1.getItemName().compareTo(o2.getItemName()) == 0) {
                if ((int) (o1.getId() - o2.getId()) == 0) {
                    return o1.getUser().getCity().compareTo(o2.getUser().getCity());
                }
                return (int) (o1.getId() - o2.getId());
            }

            return o1.getItemName().compareTo(o2.getItemName());
        }));
        System.out.println(list);

        // + other tasks from HW9

        List<Order> uniqueOrders = list.stream().
                distinct().
                collect(Collectors.toCollection(ArrayList::new));

        List<Order> expensiveOrders = list.stream().
                filter(order -> order.getPrice() >= 1500).
                collect(Collectors.toCollection(ArrayList::new));

        List<List<Order>> listOfTwoCurrencies = splitByCurrency(list);

    }

    private static List<List<Order>> splitByCurrency(List<Order> input){
        List<List<Order>> listOfCurr = new ArrayList<>();

        listOfCurr.add(input.stream().filter(order -> order.getCurrency().equals(Currency.getInstance("USD"))).collect(Collectors.toList()));
        listOfCurr.add(input.stream().filter(order -> order.getCurrency().equals(Currency.getInstance("UAH"))).collect(Collectors.toList()));

        return listOfCurr;
    }


}

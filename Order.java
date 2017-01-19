package HW7;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.*;

public class Order implements Comparable {

    private long id;
    private int price;
    private Currency currency;
    private String itemName;
    private String shopIdentifier;
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getShopIdentifier() {
        return shopIdentifier;
    }

    public void setShopIdentifier(String shopIdentifier) {
        this.shopIdentifier = shopIdentifier;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", currency=" + currency +
                ", itemName='" + itemName + '\'' +
                ", shopIdentifier='" + shopIdentifier + '\'' +
                ", user=" + user +
                "}\n";
    }

    public Order(long id, int price, Currency currency, String itemName, String shopIdentifier, User user) {
        this.id = id;
        this.price = price;
        this.currency = currency;
        this.itemName = itemName;
        this.shopIdentifier = shopIdentifier;
        this.user = user;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + price;
        result = 31 * result + currency.hashCode();
        result = 31 * result + itemName.hashCode();
        result = 31 * result + shopIdentifier.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }

    @Override
    public int compareTo(Object o) {
        Order o1 = (Order) o;
        int res;
        try{
            res = o1.getPrice() - this.getPrice();
        } catch (NullPointerException e){
            System.out.println("Might not be an Order");
            res = 0;
        }
        return res;
    }

}

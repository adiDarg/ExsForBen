public class Product {
    private String description;
    private int price;
    private int itemsInStock;
    public Product(String description, int price, int itemsInStock){
        this.description = description;
        this.price = price;
        this.itemsInStock = itemsInStock;
    }
    public int getPrice(){
        return price;
    }
    public static boolean compareProducts(Product product1, Product product2){
        return (product1.description.equals(product2.description)) && (product1.price == product2.price);
    }
    public void decreaseStock(){
        itemsInStock--;
    }
    public String toString(){
        return description + " ,Price: " + price + " ,Amount of items in stock: " + itemsInStock;
    }
}

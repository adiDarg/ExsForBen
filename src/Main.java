import java.util.Random;

public class Main {
    public static void main(String[] args){
        Store store = new Store("BassProShops",20);
        store.addSalesMan(new Salesman("Larry", "Hawk", 3000));
        store.addSalesMan(new Salesman("Terry", "Smith", 4000));
        store.addSalesMan(new Salesman("Sarah", "Lee", 3500));
        store.addProduct(new Product("Fishin rod", 5000, 10));
        store.addProduct(new Product("Sahlmen", 400, 50));
        store.addProduct(new Product("Bass", 320, 40));
        store.addProduct(new Product("Bait", 100, 80));
        store.addProduct(new Product("Red Herrin'", 500, 30));
        store.addProduct(new Product("Fishin' Hat", 600, 20));
        Random random = new Random();
        for (int i = 1; i <= 7; i++){
            for (int j = 1; j <= random.nextInt(1,4); j++){
                store.addProductAsBonus(i, random.nextInt(0, store.numberOfProducts()));
            }
        }
        store.simulate();
    }
}

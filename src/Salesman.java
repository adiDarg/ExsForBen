import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Salesman {
    private String firstName;
    private String lastName;
    private int basicSalary;
    private HashMap<Integer, List<Product>> productsSoldByDays;
    public Salesman(String firstName, String lastName, int basicSalary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.basicSalary = basicSalary;
        productsSoldByDays = new HashMap<Integer,List<Product>>();
        for (int i = 1; i <= 7; i++){
            productsSoldByDays.put(i, new LinkedList<Product>());
        }
    }
    public HashMap<Integer,List<Product>> getProductsSoldByDays(){
        return productsSoldByDays;
    }
    public void sale(int day, Product product){
        if (day < 1 || day > 7){
            System.out.println("Invalid day");
            return;
        }
        product.decreaseStock();
        productsSoldByDays.get(day).add(product);
    }
    public int getBasicSalary(){
        return basicSalary;
    }
    public String toString(){
        return firstName + " " + lastName + ": " + basicSalary;
    }
    public void updateSalary(int finalSalary){
        basicSalary = finalSalary;
    }
}

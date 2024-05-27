import java.util.*;

public class Store {
    private String name;
    private List<Salesman> salesmen;
    private List<Product> products;
    private HashMap<Integer,List<Product>> bonusProductsByDays;
    private int commissionInPercent;
    public Store(String name, int commissionInPercent){
        this.name = name;
        salesmen = new ArrayList<Salesman>();
        products = new ArrayList<Product>();
        bonusProductsByDays = new HashMap<Integer,List<Product>>();
        for (int i = 1; i <= 7; i++){
            bonusProductsByDays.put(i,new ArrayList<Product>());
        }
        this.commissionInPercent = commissionInPercent;
    }
    public void addSalesMan(Salesman salesman){
        salesmen.add(salesman);
    }
    public void addProduct(Product product){
        products.add(product);
    }
    public void addProductAsBonus(int day, int productIndex){
        if (day < 1 || day > 7){
            System.out.println("Invalid day");
        }
        else if (productIndex > products.size() - 1) {
            System.out.println("Product does not exist");
        }
        else{
            if (!bonusProductsByDays.get(day).contains(products.get(productIndex)))
                bonusProductsByDays.get(day).add(products.get(productIndex));
        }
    }
    public int numberOfProducts(){
        return products.size();
    }
    public void simulate(){
        int MAX_SALES_PER_DAY = 20;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 7; i++){
            int salesCount = random.nextInt(1,MAX_SALES_PER_DAY);
            for (Salesman salesman: salesmen){
                for (int j = 1; j <= salesCount/salesmen.size() + random.nextInt(-2,3); j++){
                    salesman.sale(i,products.get(random.nextInt(0,products.size())));
                    salesCount--;
                }
            }
        }
        int bestSalary = salesmen.get(0).getBasicSalary();
        Salesman bestSalesman = salesmen.get(0);
        for (Salesman salesman: salesmen){
            int salary = salesman.getBasicSalary();
            for (int i = 1; i <= 7; i++){
                for (Product product: salesman.getProductsSoldByDays().get(i)){
                    int salaryIncrease = product.getPrice() * commissionInPercent/100;
                    for (Product bonusProduct :  (bonusProductsByDays.get(i))){
                        if (Product.compareProducts(product,bonusProduct)){
                            salaryIncrease *= 2;
                        }
                    }
                    salary += salaryIncrease;
                }
            }
            if (salary > bestSalary){
                bestSalary = salary;
                bestSalesman = salesman;
            }
            salesman.updateSalary(salary);
        }
        System.out.println("Best Employee: " + bestSalesman);
        for (Salesman salesman : salesmen){
            if (!salesman.equals(bestSalesman)){
                System.out.println();
                System.out.println(salesman);
            }
        }
    }
}

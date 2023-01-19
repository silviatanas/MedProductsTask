import lib.ProductCategory;
import lib.ProductSupplier;
import lib.MedicinalProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StatisticData {
    private static List<MedicinalProduct> data = supplyProducts();

    public static List<MedicinalProduct> supplyProducts() {
        List<MedicinalProduct> products = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            ProductSupplier[] suppliers = ProductSupplier.values();
            ProductCategory[] categories = ProductCategory.values();

            int quantity = random.nextInt(99) + 1;
            double price = random.nextDouble() * 99 + 1;

            String invNumber = String.format("%06d", random.nextInt(1000000));
            ProductSupplier supplier = suppliers[random.nextInt(suppliers.length)];
            ProductCategory category = categories[random.nextInt(categories.length)];
            MedicinalProduct product = new MedicinalProduct(supplier, category, quantity, price, invNumber);

            products.add(product);
        }

        return products;
    }

    public static void totalCostUndefined() {
        double totalCost = data.stream()
                .filter(product -> product.getCategory() == ProductCategory.E)
                .mapToDouble(product -> product.getQuantity() * product.getPrice())
                .sum();
        System.out.printf("The total cost of Undefined products is %.2f", totalCost); // 123.45 == 123,45?
    }

    public static void groupByCategoryCounting() {
        data.stream()
                .collect(Collectors.groupingBy(MedicinalProduct::getCategory))
                .forEach((category, products) -> {
                    System.out.printf("Category %s[%s] contains %d products.%n", category, category.getValue(), products.size());
                });
    }

    public static void main(String[] args) {
        System.out.println("Executing totalCostUndefined() method:");
        totalCostUndefined();
        System.out.println("\n\nExecuting groupByCategoryCounting() method:");
        groupByCategoryCounting();
    }
}

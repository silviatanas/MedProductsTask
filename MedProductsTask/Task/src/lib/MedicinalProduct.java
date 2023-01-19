package lib;

public class MedicinalProduct  implements Comparable<MedicinalProduct> {
    private ProductSupplier supplier;
    private ProductCategory category;
    private int quantity;
    private double price;
    private final String INV_NUMBER;

    public MedicinalProduct() {
        this.supplier = null;
        this.category = null;
        this.quantity = 0;
        this.price = 0.0;
        this.INV_NUMBER = "000000";
    }

    public MedicinalProduct(ProductSupplier supplier, ProductCategory category, int quantity, double price, String INV_NUMBER) {
        this.supplier = supplier;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.INV_NUMBER = INV_NUMBER;
    }

    public MedicinalProduct(MedicinalProduct product) {
        this.supplier = product.supplier;
        this.category = product.category;
        this.quantity = product.quantity;
        this.price = product.price;
        this.INV_NUMBER = product.INV_NUMBER;
    }

    public ProductSupplier getSupplier() {
        return supplier;
    }

    public void setSupplier(ProductSupplier supplier) {
        this.supplier = supplier;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getINV_NUMBER() {
        return INV_NUMBER;
    }

    @Override
    public int compareTo(MedicinalProduct o) {
        int inv1 = Integer.parseInt(this.INV_NUMBER);
        int inv2 = Integer.parseInt(o.INV_NUMBER);
        return Integer.compare(inv2, inv1);
    }

    @Override
    public String toString() {
        return String.format("INV_NUMBER: %s, Supplier: %s, Category: %s, Quantity: %d, Price: %.2f", INV_NUMBER, supplier.getValue(), category.getValue(), quantity, price);
    }

}

package lib;
public enum ProductSupplier {
    A("Supplier A"),
    B("Supplier B"),
    C("Supplier C"),
    D("Supplier D"),
    E("Supplier E");

    private String value;

    ProductSupplier(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

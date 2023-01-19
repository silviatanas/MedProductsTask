package lib;
public enum ProductCategory {
    A("Drugs"),
    B("Vitamins"),
    C("Minerals"),
    D("Devices"),
    E("Undefined");

    private String value;

    ProductCategory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
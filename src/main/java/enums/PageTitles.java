package enums;

public enum PageTitles {

    PRODUCTS("Products");

    private final String title;

    PageTitles(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

package steps;

public enum SortingType {
    ATOZ("az", "Name (A to Z)"),
    ZTOA("za", "Name (Z to A)"),
    LOWTOHIGH("lohi", "Price (low to high)"),
    HIGHTOLOW("hilo", "Price (high to low)");

    private String value;
    private String text;

    SortingType(String value, String text){
        this.value = value;
        this.text = text;
    }

    public String getValue(){
        return value;
    }

    public String getText(){
        return text;
    }
}

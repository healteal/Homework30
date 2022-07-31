package TaxService;

public enum TypePenalty {
    AUTO_TAX("Auto"), HOME_TAX("Home"), ANOTHER_TAXES("Another");

    private final String type;

    TypePenalty(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

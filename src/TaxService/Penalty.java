package TaxService;

public class Penalty {
    private TypePenalty typePenalty;
    private String city;

    public Penalty(TypePenalty typePenalty, String city) {
        this.typePenalty = typePenalty;
        this.city = city;
    }

    public TypePenalty getTypePenalty() {
        return typePenalty;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Penalty{" +
                "typePenalty=" + typePenalty +
                ", city='" + city + '\'' +
                '}';
    }
}

package ua.knu.insurance.model;

public class AutoInsurance extends InsuranceObligation {
    private String carCategory;

    public AutoInsurance(String title, double cost, double riskLevel, String carCategory) {
        super(title, cost, riskLevel);
        this.carCategory = carCategory;
    }
}
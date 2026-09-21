package ua.knu.insurance.model;

public class HealthInsurance extends InsuranceObligation {
    private boolean includesDental;

    public HealthInsurance(String title, double cost, double riskLevel, boolean includesDental) {
        super(title, cost, riskLevel);
        this.includesDental = includesDental;
    }
}
package ua.knu.insurance.model;

import java.util.Objects;

public abstract class InsuranceObligation {
    private String title;
    private double cost;
    private double riskLevel; // Від 0.0 до 1.0 (наприклад, 0.5 = 50% ризику)

    public InsuranceObligation(String title, double cost, double riskLevel) {
        this.title = title;
        this.cost = cost;
        this.riskLevel = validateRiskLevel(riskLevel);
    }

    private double validateRiskLevel(double riskLevel) {
        if (riskLevel < 0.0 || riskLevel > 1.0) {
            throw new IllegalArgumentException("Risk level must be between 0.0 and 1.0");
        }
        return riskLevel;
    }

    public String getTitle() { return title; }
    public double getCost() { return cost; }
    public double getRiskLevel() { return riskLevel; }

    @Override
    public String toString() {
        return String.format("%s: Вартість = %.2f, Ризик = %.2f", title, cost, riskLevel);
    }
}
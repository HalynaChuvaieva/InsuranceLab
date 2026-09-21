package ua.knu.insurance.service;

import ua.knu.insurance.model.InsuranceObligation;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Derivative {
    private List<InsuranceObligation> obligations;

    public Derivative() {
        this.obligations = new ArrayList<>();
    }

    public void addObligation(InsuranceObligation obligation) {
        if (obligation != null) {
            obligations.add(obligation);
        }
    }

    public double calculateTotalCost() {
        return obligations.stream()
                .mapToDouble(InsuranceObligation::getCost)
                .sum();
    }

    public void sortByRiskDescending() {
        obligations.sort(Comparator.comparingDouble(InsuranceObligation::getRiskLevel).reversed());
    }

    public List<InsuranceObligation> findByRiskRange(double minRisk, double maxRisk) {
        return obligations.stream()
                .filter(o -> o.getRiskLevel() >= minRisk && o.getRiskLevel() <= maxRisk)
                .collect(Collectors.toList());
    }

    public List<InsuranceObligation> getObligations() {
        return new ArrayList<>(obligations); // Повертаємо копію для інкапсуляції
    }
}
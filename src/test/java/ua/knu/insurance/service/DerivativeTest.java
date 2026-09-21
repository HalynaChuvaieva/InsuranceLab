package ua.knu.insurance.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.knu.insurance.model.InsuranceObligation;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DerivativeTest {
    private Derivative derivative;

    @BeforeEach
    void setUp() {
        derivative = new Derivative();
    }

    @Test
    void shouldCalculateTotalCostCorrectly() {
        InsuranceObligation mock1 = mock(InsuranceObligation.class);
        when(mock1.getCost()).thenReturn(10000.0);

        InsuranceObligation mock2 = mock(InsuranceObligation.class);
        when(mock2.getCost()).thenReturn(15000.0);

        derivative.addObligation(mock1);
        derivative.addObligation(mock2);

        assertEquals(25000.0, derivative.calculateTotalCost(), 0.01);
    }

    @Test
    void shouldSortByRiskDescending() {
        InsuranceObligation lowRisk = mock(InsuranceObligation.class);
        when(lowRisk.getRiskLevel()).thenReturn(0.2);

        InsuranceObligation highRisk = mock(InsuranceObligation.class);
        when(highRisk.getRiskLevel()).thenReturn(0.9);

        derivative.addObligation(lowRisk);
        derivative.addObligation(highRisk);

        derivative.sortByRiskDescending();
        List<InsuranceObligation> sorted = derivative.getObligations();

        // Перевіряємо, що першим іде об'єкт із найбільшим ризиком
        assertEquals(0.9, sorted.get(0).getRiskLevel());
        assertEquals(0.2, sorted.get(1).getRiskLevel());
    }

    @Test
    void shouldFindObligationsInRiskRange() {
        InsuranceObligation mock1 = mock(InsuranceObligation.class);
        when(mock1.getRiskLevel()).thenReturn(0.1); // Не підходить

        InsuranceObligation mock2 = mock(InsuranceObligation.class);
        when(mock2.getRiskLevel()).thenReturn(0.5); // Підходить

        InsuranceObligation mock3 = mock(InsuranceObligation.class);
        when(mock3.getRiskLevel()).thenReturn(0.8); // Підходить

        derivative.addObligation(mock1);
        derivative.addObligation(mock2);
        derivative.addObligation(mock3);

        List<InsuranceObligation> found = derivative.findByRiskRange(0.4, 0.9);

        assertEquals(2, found.size());
        assertTrue(found.contains(mock2));
        assertTrue(found.contains(mock3));
        assertFalse(found.contains(mock1));
    }
}
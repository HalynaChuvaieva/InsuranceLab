package ua.knu.insurance.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AutoInsuranceTest {

    @Test
    void shouldCreateAutoInsuranceSuccessfully() {
        AutoInsurance insurance = new AutoInsurance("КАСКО", 25000, 0.7, "Легковий");

        assertEquals("КАСКО", insurance.getTitle());
        assertEquals(25000, insurance.getCost());
        assertEquals(0.7, insurance.getRiskLevel());
    }

    @Test
    void shouldThrowExceptionWhenRiskIsTooHigh() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new AutoInsurance("Невалідний ризик", 1000, 1.5, "Вантажний");
        });

        assertTrue(exception.getMessage().contains("Risk level must be between 0.0 and 1.0"));
    }

    @Test
    void shouldThrowExceptionWhenRiskIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            new AutoInsurance("Від'ємний ризик", 1000, -0.1, "Легковий");
        });
    }
}
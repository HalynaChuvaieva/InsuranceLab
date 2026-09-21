package ua.knu.insurance.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HealthInsuranceTest {

    @Test
    void shouldCreateHealthInsuranceSuccessfully() {
        HealthInsurance insurance = new HealthInsurance("Преміум медичне", 35000.0, 0.2, true);

        assertEquals("Преміум медичне", insurance.getTitle(), "Назва має збігатися");
        assertEquals(35000.0, insurance.getCost(), "Вартість має збігатися");
        assertEquals(0.2, insurance.getRiskLevel(), "Рівень ризику має збігатися");
    }

    @Test
    void shouldThrowExceptionWhenRiskIsTooHigh() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new HealthInsurance("Занадто великий ризик", 10000, 1.5, false);
        });

        assertTrue(exception.getMessage().contains("Risk level must be between 0.0 and 1.0"));
    }

    @Test
    void shouldThrowExceptionWhenRiskIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            new HealthInsurance("Від'ємний ризик", 10000, -0.3, false);
        });
    }
}
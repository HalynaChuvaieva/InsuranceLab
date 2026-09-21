package ua.knu.insurance.main;

import ua.knu.insurance.model.AutoInsurance;
import ua.knu.insurance.model.HealthInsurance;
import ua.knu.insurance.service.Derivative;

public class Main {
    public static void main(String[] args) {
        Derivative derivative = new Derivative();

        derivative.addObligation(new HealthInsurance("Базове медичне", 15000, 0.4, false));
        derivative.addObligation(new HealthInsurance("Преміум медичне (зі стоматологією)", 35000, 0.2, true));
        derivative.addObligation(new AutoInsurance("КАСКО", 25000, 0.7, "Легковий"));
        derivative.addObligation(new AutoInsurance("ОСЦПВ", 2000, 0.9, "Вантажний"));

        System.out.println("Загальна вартість деривативу: " + derivative.calculateTotalCost());

        System.out.println("\nСортування за зменшенням ризику:");
        derivative.sortByRiskDescending();
        derivative.getObligations().forEach(System.out::println);

        System.out.println("\nПошук зобов'язань з ризиком від 0.3 до 0.6:");
        derivative.findByRiskRange(0.3, 0.6).forEach(System.out::println);
    }
}
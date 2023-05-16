package vacationCalculator.service;

import org.springframework.stereotype.Service;
import vacationCalculator.model.dto.request.VacationPayRequest;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Service
public class VacationCalculatorService {

    public double calculateVacationPay(VacationPayRequest request) {
        double averageSalary = request.getAverageSalary();
        int vacationDays = request.getVacationDays();
        List<LocalDate> vacationDates = request.getVacationDates();

        double pay = averageSalary * vacationDays;

        // Учет праздников и выходных дней
        for (LocalDate date : vacationDates) {
            if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                pay -= averageSalary;
            }

            // Дополнительная логика для учета праздников
            // ...
        }

        return pay;
    }
}

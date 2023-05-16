package vacationCalculator.model.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class VacationPayRequest {
    private double averageSalary;
    private int vacationDays;
    private List<LocalDate> vacationDates;
}

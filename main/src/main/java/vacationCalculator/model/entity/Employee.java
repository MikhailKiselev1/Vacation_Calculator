package vacationCalculator.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Employee {
    @Id
    private Long id;
    private double averageSalary;
    private int vacationDays;
    private double vacationPay;
}

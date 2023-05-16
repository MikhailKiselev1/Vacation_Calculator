package vacationCalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vacationCalculator.model.dto.request.VacationPayRequest;
import vacationCalculator.service.VacationCalculatorService;

@RestController
public class VacationCalculatorController {

    private final VacationCalculatorService calculatorService;

    public VacationCalculatorController(VacationCalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/calculate")
    public double calculateVacationPay(@RequestBody VacationPayRequest request) {
        return calculatorService.calculateVacationPay(request);
    }
}

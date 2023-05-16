import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import vacationCalculator.Application;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {Application.class})
public class VacationCalculatorApplicationTests {
    @Value("${server.port}")
    private int serverPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void calculateVacationPay_WithoutSpecificDates_ReturnsCorrectAmount() {
        double averageSalary = 5000.0;
        int vacationDays = 14;

        ResponseEntity<Double> response = restTemplate.getForEntity("/calculate?averageSalary={averageSalary}&vacationDays={vacationDays}",
                Double.class, averageSalary, vacationDays);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(3500.0);
    }

    @Test
    public void calculateVacationPay_WithSpecificDates_ReturnsCorrectAmount() {
        double averageSalary = 5000.0;
        int vacationDays = 14;
        String startDate = "2023-01-01";
        String endDate = "2023-01-14";

        ResponseEntity<Double> response = restTemplate.getForEntity("/calculate?averageSalary={averageSalary}&vacationDays={vacationDays}&startDate={startDate}&endDate={endDate}",
                Double.class, averageSalary, vacationDays, startDate, endDate);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(3300.0);
    }
}

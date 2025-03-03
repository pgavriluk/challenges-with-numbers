package pavel.demo.employee;

import java.time.LocalDateTime;

public record Employee(String firstName, String lastName, LocalDateTime hireDate) {
}

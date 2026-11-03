import java.time.LocalDate;
public record Period(LocalDate startDate, LocalDate endDate) {
    public Period {
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException();
        }
    }
}
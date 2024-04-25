import java.time.LocalDate;
import java.time.LocalTime;

enum Severity {
    ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN
}

class Patient {
    private final String name;
    private final LocalDate dob;
    private Severity severity;
    private LocalTime arrivalTime;

    public Patient(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Severity getSeverity() {
        return severity;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return name +
               "\nDOB=" + dob +
               "\nseverity=" + severity +
               "\narrivalTime=" + arrivalTime + " admitted";
    }
}
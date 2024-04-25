import java.util.Comparator;
import java.time.LocalTime;

public class EmergencyRoom {
    private final Heap<Patient> patientQueue;

    public EmergencyRoom(Comparator<Patient> comparator) {
        this.patientQueue = new Heap<>(comparator);
    }

    public void checkIn(Patient patient, Severity severity) {
        patient.setSeverity(severity);
        patient.setArrivalTime(LocalTime.now());
        patientQueue.add(patient);
    }

    public Patient admit() {
        return patientQueue.remove();
    }
}

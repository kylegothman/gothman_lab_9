import java.util.Comparator;

class PatientComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient p1, Patient p2) {
        int severityCompare = p2.getSeverity().compareTo(p1.getSeverity());
        if (severityCompare != 0) return severityCompare;
        int ageCompare = p2.getDob().compareTo(p1.getDob());
        if (ageCompare != 0) return ageCompare;
        return p1.getArrivalTime().compareTo(p2.getArrivalTime());
    }
}
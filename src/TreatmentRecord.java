public class TreatmentRecord {

    private int treatmentId;
    private int patientId;
    private String patientName;
    private String doctorName;
    private String diagnosis;
    private String treatment;
    private String treatmentDate;

    public TreatmentRecord(int treatmentId, int patientId,
                           String patientName, String doctorName,
                           String diagnosis, String treatment,
                           String treatmentDate) {

        this.treatmentId = treatmentId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.treatmentDate = treatmentDate;
    }

    public int getTreatmentId() {
        return treatmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public String getTreatmentDate() {
        return treatmentDate;
    }

    public void displayTreatment() {

        System.out.println("----------------------------------------");
        System.out.println("Treatment ID : " + treatmentId);
        System.out.println("Patient ID   : " + patientId);
        System.out.println("Patient Name : " + patientName);
        System.out.println("Doctor       : " + doctorName);
        System.out.println("Diagnosis    : " + diagnosis);
        System.out.println("Treatment    : " + treatment);
        System.out.println("Date         : " + treatmentDate);
        System.out.println("----------------------------------------");
    }
}
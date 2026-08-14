/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medicalrecords;

import java.time.LocalDate;

/**
 *
 * @author jprod
 */
public class MedicalRecord {
    private LocalDate date;
    private String consultationReason;
    private String diagnosis;
    private String treatment;
    private String notes;

    public LocalDate getDate() {
        return date;
    }

    public String getConsultationReason() {
        return consultationReason;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public String getNotes() {
        return notes;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public MedicalRecord(String consultationReason, String diagnosis, String treatment, String notes) {
        this.date = LocalDate.now();
        this.consultationReason = consultationReason;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.notes = notes;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinic;

import appointments.Appointment;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import patients.Patient;
import clinic.views;


/**
 *
 * @author kevin
 */
public class ClinicController {
    private final Clinic clinic;

    public ClinicController(views vista, Clinic clinic) {
    this.clinic = clinic;
}
    
    public void registrPaciente(Patient patient){
        if (clinic.addPatient(patient)){
            vista.showMessage("El paciente se ha registrado corrrectamente");
            vista.clear();
        }else{
            vista.showError("No se pudo registrar el paciente");
        }
    }
    
    public Patient buscarPaciente(String id){
        Patient patient = clinic.findPatient(id);
        if (patient == null){
            vista.showError("!No se encontro registro");
        }else{
            vista.showData(patient);
        }
        return patient;
    }
    
    public void eliminarPaciente( String id){
        if (clinic.removePatient(id)){
            vista.showMessage("Paciente elimnado..");
        }else{
            vista.showError("!No se pudo eliminar el paciente!");
        }
    }
    
    public Iterator<Patient> listarPacientes(){
        return clinic.getPatients();
    }
    
    public void agendarCita(Appointment appointment){
        if (clinic.scheduleAppointment(appointment)){
            vista.showMessage("Cita agendada..");
            vista.clear();
        }else{
            vista.showError("!No se pudo agendar la cita!");
        }
    }
    
    public void reprogramarCita(String code, LocalDate newDate, LocalTime newTime){
        if (clinic.rescheduleAppointment(code, newDate, newTime)){
            vista.showMessage("Cita reprogramada correctamente");
        }else{
            vista.showError("No se pudo reprogramar la cita");
        }
    }
    
    public void cancelarCita(String code){
        if(clinic.cancelAppointment(code)){
        vista.showMessage("Cita cancelada correctamente");
    }else{
            vista.showError("No se pudo cancelar la cita");
        }
    }
    
    public Iterator<Appointment> listarCitas(){
        return clinic.getAppointments();
    }
    
    public void registrarLlegada(String patientId) {
        if (clinic.checkInPatient(patientId)) {
            vista.showMessage("Paciente registrado en sala de espera.");
        } else {
            vista.showError("El paciente no tiene una cita pendiente para hoy.");
        }
    }

    public void atenderSiguiente() {
        Patient patient = clinic.attendNextPatient();

        if (patient == null) {
            vista.showError("No hay pacientes en espera.");
            return;
        }

        vista.showData(patient);
    }

    public int cantidadEnEspera() {
        return clinic.getWaitingPatientCount();
        
    } 
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinic;

import appointments.Appointment;
import appointments.AppointmentList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import patients.Patient;
import patients.PatientsList;
import waitingrooms.WaitingRoomList;

/**
 *
 * @author kevin
 */
public class Clinic {
    private PatientsList patients;
    private AppointmentList appointments;
    private WaitingRoomList waitingRoom;
    
    public Clinic(){
        this.patients = new PatientsList();
        this.appointments = new AppointmentList();
        this.waitingRoom = new WaitingRoomList();
        
    }
    
    public boolean addPatient(Patient patient) {
        return patients.add(patient);
    }

    public Patient findPatient(String id) {
        return patients.get(id);
    }

    public boolean removePatient(String id) {
        return patients.remove(id);
    }

    public Iterator<Patient> getPatients() {
        return patients.getAll();
    }

    public boolean scheduleAppointment(Appointment appointment) {
        return appointments.add(appointment);
    }

    public Appointment findAppointment(String code) {
        return appointments.get(code);
    }

    public boolean rescheduleAppointment(String code, LocalDate newDate, LocalTime newTime) {
        if(appointments.isEmpty())return false;
        Appointment appo = appointments.get(code);
        if(appo==null) return false;
        appo.reschedule(newDate, newTime);
        return true;
    }

    public boolean cancelAppointment(String code) {
         if (appointments.isEmpty()) {
            return false;
        }

        Appointment appo = appointments.get(code);

        if (appo == null) {
            return false;
        }

        appo.cancel();
        return true;
    }

    public Iterator<Appointment> getAppointments() {
        return appointments.getAll();
    }

    public boolean checkInPatient(String patientId) {
  Iterator<Appointment> itAppo = appointments.getAll();

        while (itAppo.hasNext()) {

            Appointment appo = itAppo.next();

            if (appo.getPatient().getId().equals(patientId)
                    && appo.isToday()
                    && appo.isPending()) {

                return waitingRoom.add(appo.getPatient());
            }
        }

        return false;
    }

    public Patient getNextPatient() {
      return waitingRoom.get();
    }

    public Patient attendNextPatient() {
          Patient patient = waitingRoom.get();

        if (patient == null) {
            return null;
        }

        waitingRoom.remove();

        return patient;
    }

    public int getWaitingPatientCount() {
          return waitingRoom.size();
    }

    public boolean isPatientWaiting(String patientId) {
        Iterator<Patient> iterator = waitingRoom.getAll();

        if (iterator == null) {
            return false;
        }

        while (iterator.hasNext()) {

            Patient patient = iterator.next();

            if (patient.getId().equals(patientId)) {
                return true;
            }
        }

        return false;
    }
}
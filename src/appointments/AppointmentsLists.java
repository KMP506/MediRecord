/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appointments;

import clinic.KeyDynamicsList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author kevin
 */
public class AppointmentsLists implements KeyDynamicsList<Appointment, String> {

    private Map<String, Appointment> appointments;

    public AppointmentsLists() {
        appointments = new TreeMap<>();
    }

   
    public boolean add(Appointment item) {
        if (item == null || item.getCode() == null) {
            return false;
        }

        if (appointments.containsKey(item.getCode())) {
            return false;
        }

        appointments.put(item.getCode(), item);
        return true;
    }

    
    public Appointment get(String code) {
        return appointments.get(code);
    }

    
    public boolean remove(String code) {
        if (!appointments.containsKey(code)) {
            return false;
        }

        appointments.remove(code);
        return true;
    }

    
    public Iterator getAll() {
        return appointments.values().iterator();
    }

    
    public int size() {
        return appointments.size();
    }

    
    public boolean isEmpty() {
        return appointments.isEmpty();
    }

    @Override
    public boolean add(Object item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

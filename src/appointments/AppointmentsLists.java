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
    
    @Override
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
    
    @Override
    public Appointment get(String code) {
        return appointments.get(code);
    }

    
    @Override
    public boolean remove(String code) {
        if (!appointments.containsKey(code)) {
            return false;
        }

        appointments.remove(code);
        return true;
    }

    
    @Override
    public Iterator getAll() {
        return appointments.values().iterator();
    }

    
    @Override
    public int size() {
        return appointments.size();
    }

    
    @Override
    public boolean isEmpty() {
        return appointments.isEmpty();
    }

}

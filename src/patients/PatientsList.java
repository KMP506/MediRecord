/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patients;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author kevin
 */
public class PatientsList {
 private Map<String, Patient> patients;

    public PatientsList() {
        patients = new HashMap<>();
    }

    
    public boolean add(Patient item) {
        if (item == null || item.getId() == null) {
            return false;
        }

        if (patients.containsKey(item.getId())) {
            return false;
        }

        patients.put(item.getId(), item);
        return true;
    }

    
    public Patient get(String id) {
        return patients.get(id);
    }

    
    public boolean remove(String id) {
        if (!patients.containsKey(id)) {
            return false;
        }

        patients.remove(id);
        return true;
    }

    
    public Iterator getAll() {
        return patients.values().iterator();
    }

    
    public int size() {
        return patients.size();
    }

    
    public boolean isEmpty() {
        return patients.isEmpty();
    }
}

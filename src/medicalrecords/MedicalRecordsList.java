/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medicalrecords;

import java.util.Iterator;
import java.util.Stack;
import waitingrooms.SequentialDynamicsLists;

/**
 *
 * @author kevin
 */
public class MedicalRecordsList implements SequentialDynamicsLists<MedicalRecord>{
    
    private Stack<MedicalRecord> medicalHistory;
    
    public MedicalRecordsList(){
        this.medicalHistory = new Stack();
    }

    @Override
    public MedicalRecord get() {
        if (medicalHistory.isEmpty()) {
            return null;
        }

        return medicalHistory.peek();
    }

    @Override
    public boolean remove() {
        if (medicalHistory.isEmpty()) {
            return false;
        }

        medicalHistory.pop();
        return true;
    }

    @Override
    public boolean add(MedicalRecord item) {
        if (item == null) {
            return false;
        }

        medicalHistory.push(item);
        return true;
    }

    @Override
    public Iterator getAll() {
        return medicalHistory.iterator();
    }

    @Override
    public int size() {
        return medicalHistory.size();
    }

    @Override
    public boolean isEmpty() {
        return medicalHistory.isEmpty();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package waitingrooms;

import java.util.LinkedList;
import java.util.Queue;
import patients.Patient;

/**
 *
 * @author Student
 */
public class WaitingRoomList implements SequentialDynamicsLists<Patient> {
    private Queue<Patient> waitingList;
    public WaitingRoomList(){
        this.waitingList = new LinkedList();
    }
    
}

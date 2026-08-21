/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package waitingrooms;

import java.util.Iterator;
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

    @Override
    public Patient get() {
     return waitingList.peek();
    }

    @Override
    public boolean remove() {
      if (waitingList.isEmpty()){
          return false;
      }
      waitingList.poll();
      return true;
    }

    @Override
    public boolean add(Patient item) {
      if (item == null){
          return false;
      }
      return waitingList.offer(item);
    }

    @Override
    public Iterator getAll() {
        return waitingList.iterator();
    }

    @Override
    public int size() {
       return waitingList.size();
    }

    @Override
    public boolean isEmpty() {
        return waitingList.isEmpty();
    }
    
    
}

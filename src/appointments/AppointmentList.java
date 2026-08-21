/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appointments;
import clinic.KeyDynamicsList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author isaac
 */
public class AppointmentList implements KeyDynamicsList<Appointment, String>{
    private TreeSet<Appointment> appointments;
     
    public AppointmentList(){
        this.appointments= new TreeSet<>(); 
    }
    
    
    public Appointment get(String code){
        for(Appointment appo: appointments){
            if(appo.getCode().equals(code))
            return appo;
        }
        return null;
    }

    @Override
    public boolean remove(String code) {
        Appointment appo=get(code);
        if(appo==null){
            return false;
        }
        return appointments.remove(appo);
    }

    @Override
    public boolean add(Appointment item) {
        if(item==null){
            return false;
        }
        if(get(item.getCode())!=null){
            return false;
        }
        return appointments.add(item);
    }

    @Override
    public Iterator getAll() {
        return appointments.iterator();
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

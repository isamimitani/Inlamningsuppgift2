package uppgift2_oop;

import java.time.*;
import java.util.*;

/**
 * Klassen beskriver en kund
 * @author isami
 */
public class Customer {
    
    private String name;
    private String personalnumber;
    private LocalDate feePaidDate;
    

    //-- Constructors --//
    public Customer(){}
    
    public Customer(String name, String personalnumber) {
        this.name = name;
        this.personalnumber = personalnumber;
    }

    public Customer(String name, String personalnumber, LocalDate feePaidDate) {
        this.name = name;
        this.personalnumber = personalnumber;
        this.feePaidDate = feePaidDate;
    }
    
    //-- Instance methods --//
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.personalnumber, other.personalnumber)) {
            return false;
        }
        return true;
    }
    

    //-- Getters and Setters --//
    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
       if(!name.matches("[^0-9]+")){
           throw new IllegalArgumentException("Namn innehåller siffra");
       } else {
           this.name = name;
       }
    }

    public String getPersonalnumber() {
        return personalnumber;
    }

    public void setPersonalnumber(String personalnumber) throws IllegalArgumentException{
       if(personalnumber.matches("[^0-9]+") || personalnumber.length() != 10){
           throw new IllegalArgumentException("Perspnnummer innehåller n@got annat än siffra");
       } else {
           this.personalnumber = personalnumber;
       }        
    }

    public LocalDate getFeePaidDate() {
        return feePaidDate;
    }

    public void setFeePaidDate(LocalDate feePaidDate) {
        this.feePaidDate = feePaidDate;
    }

}

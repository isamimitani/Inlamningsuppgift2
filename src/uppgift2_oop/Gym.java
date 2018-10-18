package uppgift2_oop;

import java.nio.file.*;
import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.time.format.DateTimeFormatter;
/**
 * Klassen beskriver ett gym
 * @author isami
 */
public class Gym {
    
    private String name;
    private List<Customer> customerList = new ArrayList<>();
    private Path customerFile = Paths.get("src/uppgift2_oop/customers.txt");
    private Path visitRecordFile = Paths.get("src/uppgift2_oop/visit_records.txt");

    //-- Constructors --//
    public Gym(){
        initCustomerList();
    }
    
    public Gym(String name) {
        this.name = name;
        initCustomerList();
    }

    //-- Instance methods --//
    
    private void initCustomerList(){
        if(!Files.exists(customerFile, LinkOption.NOFOLLOW_LINKS)){
            System.out.println("Ett fel har uppstått när programmet försökte läsa kundfilen.");
            System.exit(0);
        }
        
        try(Scanner sc = new Scanner(customerFile)){
            while(sc.hasNextLine()){
                Customer cus = new Customer();
                String line = sc.nextLine();
                int index = line.indexOf(",");
                String name = line.substring(index+1).trim();
                String pnum = line.substring(0, index).trim();                
                cus.setName(name);
                cus.setPersonalnumber(pnum);
                if(sc.hasNextLine()){
                    line = sc.nextLine();
                    LocalDate date = Utilities.stringToLocalDate(line);
                    cus.setFeePaidDate(date);                   
                }
                addCustomer(cus);                      
            }
        } catch(IOException ioe){
            System.out.println("Ett fel har uppstått när programmet försökte läsa kundfilen.");
        }
       
    }
    
    public void checkMembership(String str){
        
        Customer c = findCustomer(str);
        if(c!=null && c.getFeePaidDate()!=null){
            LocalDate ld = c.getFeePaidDate();
            LocalDate today = LocalDate.now();
            Duration d = Duration.between(ld.atStartOfDay(), today.atStartOfDay());
            
            System.out.println(d.toDays());
            if(d.toDays() < 365){
                System.out.println(c.getName() + " har ett giltigt medlemskap.");
                System.out.println("Sista betalningsdatum var: " + c.getFeePaidDate() + "\n");
                recordVisitHistory(c);
            } else {
                System.out.println(c.getName() + " är inte medlem längre.");
                System.out.println("Sista betalningsdatum var: " + c.getFeePaidDate() + "\n");
            }
                
        } else if(c!=null && c.getFeePaidDate()==null){
            System.out.println(c.getName() + ": betalningsdatum saknas.");
        } else {
            System.out.println("Kunde inte hitta kunden i kundlistan");
        }        
    }
    
    public Customer findCustomer(String str){
        Customer customer = null;
        
        for(Customer c : customerList){
            if(str.toLowerCase().equals(c.getName().toLowerCase())){
                customer = c;
            }
            if(str.equals(c.getPersonalnumber())){
                customer = c;
            }
        }         
        return customer;
    }
    
    private void recordVisitHistory(Customer customer){
        try{
            if(!Files.exists(visitRecordFile, LinkOption.NOFOLLOW_LINKS)){
                Files.createFile(visitRecordFile);
            }
            
            try(BufferedWriter bw = 
                    Files.newBufferedWriter(visitRecordFile,StandardCharsets.UTF_8, 
                            StandardOpenOption.APPEND)){
                StringBuilder sb = new StringBuilder();
                sb.append("Namn: ").append(customer.getName()).append("\n");
                sb.append("Personnummer: ").append(customer.getPersonalnumber()).append("\n");
                sb.append("Datum: ").append(LocalDateTime.now().
                        format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("\n\n");
                bw.write(sb.toString());
                
            } catch(IOException ioe){
                System.out.println("Ett fel Har uppstått när programmet försökte skriv till en fil");
            }            
        } catch(IOException ioe){
            System.out.println("Ett fel Har uppstått när programmet försökte skriv till en fil");
        } 
            
    }
    
    public void showRecordFile(){
        
        try{
            Scanner sc = new Scanner(visitRecordFile);
            while(sc.hasNextLine()){
               System.out.println(sc.nextLine());
            }
        } catch(IOException ioe){
            System.out.println("Ett fel har uppstått. Kunde inte visa filen.");
        }
    }
        
    public void addCustomer(Customer customer){
        customerList.add(customer);        
    }
    
    public void removeCustomer(Customer customer){
        customerList.remove(customer);
    }
    
    
    //-- Getters and Setters --//
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public Path getCustomerFile() {
        return customerFile;
    }

    public void setCustomerFile(Path customerFile) {
        this.customerFile = customerFile;
    }

    public Path getVisitRecordFile() {
        return visitRecordFile;
    }

    public void setVisitRecordFile(Path visitRecordFile) {
        this.visitRecordFile = visitRecordFile;
    }
    
}

package uppgift2_oop;

import java.time.*;
import java.time.format.DateTimeParseException;
import java.util.*;

/**
 * Utility Klass
 * @author isami
 */
public class Utilities {
    
    //-- Class methods --//
    
    public static void showMenu(){
        
        System.out.println("*****************************************************");
//        System.out.println("Välkommen till Gymsystemet");
//        System.out.println();
        System.out.println("Välj någon av följande alternativ och mata in siffra(0-3).");
        System.out.println("----------------------------------");
        System.out.println("0. Avsluta programmet");
        System.out.println("1. Kolla medlemskap");
        System.out.println("2. Visa historikfilen");
        System.out.println("----------------------------------");
        System.out.println("*****************************************************");
        
    }
    
    public static String getInput(){
        
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().trim();

    }
    
    public static boolean checkInput(String str){
        if(str==null || str.length()!=1 || str.equals("")){
            return false;
        } else if(str.matches("[0-9]+")){
            return true;
        }
        
        return false;
    }
    
    public static void executeSelected(Gym gym, String select){
        
        if(gym==null){
            System.out.println("Kunde inte hitta gymmet. Avslutar programmet.");
            System.exit(0);
        } else {
            switch(select){
                case "0": 
                    System.out.println("\nAvslutar programmet..");
                    System.exit(0);
                    break;
                case "1":
                    System.out.println("\nSkriv in fullständigt namn eller personnummer på personen:");
                    String input = getInput();                 
                    gym.checkMembership(input);
                    break;
                case "2":
                    System.out.println("\nFilnamn: " + gym.getVisitRecordFile().toAbsolutePath());
                    System.out.println();
                    gym.showRecordFile();
                    break;
                default:
                    System.out.println("Ogiltig siffra. Försök igen");
            }
        }  
    }
    
    public static String getErrorMessege(){
        return "Ogiltig inmatning. Försök igen.";
    }
    
    public static LocalDate stringToLocalDate(String str){
        
        LocalDate lt = null;
        
        try{
            lt = LocalDate.parse(str.trim());
        }
        catch(DateTimeParseException e){
            return lt;
        }
         
        return lt;
    }  
    
}

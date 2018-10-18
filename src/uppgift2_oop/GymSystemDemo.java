package uppgift2_oop;

import static uppgift2_oop.Utilities.*;
/**
 * Klassen utför programmet
 * @author isami
 */
public class GymSystemDemo {
    
    public GymSystemDemo(){
    
        Gym gym = new Gym("Best Gym Ever");
        
        while(true){

            showMenu();

            String input = getInput();

            if(checkInput(input)){
                executeSelected(gym, input);
            } else {
                System.out.println(getErrorMessage());
            }
  
        }                
    
    }
    
}

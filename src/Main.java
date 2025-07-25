import LowLevelDesign.DesignATM.ATMRoom;

public class Main {
    public static void main(String[] args){
        // This is the original console-based ATM demo
        // For the web UI, run: mvn spring-boot:run
        // Then visit: http://localhost:8080
        
        System.out.println("=== Console ATM Demo ===");
        ATMRoom atmRoom = new ATMRoom();
        ATMRoom.main(args);
        
        System.out.println("\n=== Web UI Available ===");
        System.out.println("To use the web interface:");
        System.out.println("1. Run: mvn spring-boot:run");
        System.out.println("2. Open: http://localhost:8080");
        System.out.println("3. Use PIN: 112211");
    }
}
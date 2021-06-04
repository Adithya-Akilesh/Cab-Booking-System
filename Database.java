import java.util.*;
public class Database 
{

    static Scanner sc = new Scanner(System.in);
    static HashMap<String,Customer> userDatabase = new HashMap<>();
    static HashMap<String,Rider> riderDatabase = new HashMap<>();
    static HashMap<String,ArrayList<Ride>> userHistory = new HashMap<>();
    static HashMap<String,Vehicle> vehicleDtabase = new HashMap<>();
    static final HashMap<String,Integer> RATE_DETAILS = new HashMap<>();


    static
    {
        RATE_DETAILS.put("Cab",30);
        RATE_DETAILS.put("Mini",15);
        RATE_DETAILS.put("Sedan",50);
        RATE_DETAILS.put("Suv",100);
        RATE_DETAILS.put("Micro",75);
        RATE_DETAILS.put("Bike",15);
        vehicleDtabase.put("123",new Vehicle("123", "Cab", "Akilesh", "9094100875", 10D, 10D));
        vehicleDtabase.put("124",new Vehicle("124", "Mini", "Adithya", "9094100876", 10D, 20D));
        vehicleDtabase.put("125",new Vehicle("125", "Sedan", "Kumar", "9094100877", 10D, 30D));
        vehicleDtabase.put("126",new Vehicle("126", "Suv", "Rishi", "9094100878", 10D, 5D));
        vehicleDtabase.put("127",new Vehicle("127", "Cab", "Yudhish", "9094100879", 40D, 10D));
        vehicleDtabase.put("128",new Vehicle("128", "Micro", "Shailesh", "9094100880", 60D, 10D));
        vehicleDtabase.put("129",new Vehicle("129", "Bike", "Varman", "9094100881", 30D, 10D));
        vehicleDtabase.put("130",new Vehicle("130", "Sedan", "Babu", "9094100882", 80D, 10D));
    }


    static void signUp()
    {
        System.out.println("\nEnter Details to Sign Up");
        System.out.println("Enter your name");
        String name = sc.next();
        System.out.println("Enter Username : ");
        String username = sc.next();
        System.out.println("Enter Password : ");
        String password = sc.next();
        if(userDatabase.get(username) != null)
        {
            System.out.println("\n\n\nUsername already Exists");
            System.out.println("Try again\n\n\n");
            signUp();
        }
        else
        {
            userDatabase.put(username,(new Customer(name,username,password)));
            System.out.println("\n\n\nUser Created Successfully\n\n\n");
            return;
        }
        return;
    }
    

    static Customer logIn()
    {
        System.out.println("\nEnter Login Details :");
        System.out.println("Username : ");
        String username = sc.next();
        System.out.println("Pass : ");
        String password = sc.next();
        Customer c = null;
        if(userDatabase.get(username) != null)
        {
            c = userDatabase.get(username);
            if( (c.getUsername()).equals(username) && (c.getPassword()).equals(password) )
            {
                System.out.println("\n\n\nLogin Approved\n\n\n");
                return c;
            }
            else
            {
                System.out.println("\n\n\nInvalid Username and Password");
                System.out.println("Try Again\n\n\n");
                logIn();
            }
        }
        else
        {
            System.out.println("\n\n\nInvalid Username and Password");
            System.out.println("Try Again\n\n\n");
            c = logIn();
        }
        return c;
    }

    
    public static void riderSignUp()
    {
        System.out.println("\nEnter Details to Sign Up");
        System.out.println("Enter your name");
        String name = sc.next();
        System.out.println("Enter Username : ");
        String username = sc.next();
        System.out.println("Enter Password : ");
        String password = sc.next();
        if(userDatabase.get(username) != null)
        {
            System.out.println("\n\n\nUsername already Exists");
            System.out.println("Try again\n\n\n");
            signUp();
        }
        else
        {
            System.out.println("Enter Your Phone Number");
            String riderNumber = sc.next();
            System.out.println("Enter Vehicle Number");
            String vechicleNumber = sc.nextLine();
            System.out.println("Enter Vehicle Type");
            String vehicleType = sc.nextLine();
            riderDatabase.put(username,new Rider(name, username, password, vechicleNumber, riderNumber, vehicleType));
            System.out.println("\n\n\nRider Created Successfully\n\n\n");
            return;
        }
        return;
    }


    public static Rider riderLogIn()
    {
        System.out.println("\nEnter Login Details :");
        System.out.println("Username : ");
        String username = sc.next();
        System.out.println("Pass : ");
        String password = sc.next();
        Rider r = null;
        if(riderDatabase.get(username) != null)
        {
            r = riderDatabase.get(username);
            if( (r.getUsername()).equals(username) && (r.getPassword()).equals(password) )
            {
                System.out.println("\n\n\nLogin Approved\n\n\n");
                return r;
            }
            else
            {
                System.out.println("\n\n\nInvalid Username and Password");
                System.out.println("Try Again\n\n\n");
                riderLogIn();
            }
        }
        else
        {
            System.out.println("\n\n\nInvalid Username and Password");
            System.out.println("Try Again\n\n\n");
            r = riderLogIn();
        }
        return r;
    }


    public static Vehicle findNearsetVehicle(Double latitude, Double longitude, Double maxDistance) {
        TreeMap<Double, Vehicle> nearestVehicleMap = new TreeMap<>();
        for(String vehicleNumber : vehicleDtabase.keySet()){
            Vehicle vehicle = vehicleDtabase.get(vehicleNumber);
            Double distance = Math.sqrt(Math.pow((vehicle.getLatitude()-latitude), 2) + Math.pow((vehicle.getLongitude()-longitude), 2));
            if(distance <= maxDistance) {
                nearestVehicleMap.put(distance, vehicle);
            }
        }
        return nearestVehicleMap.pollFirstEntry().getValue();
    }

}
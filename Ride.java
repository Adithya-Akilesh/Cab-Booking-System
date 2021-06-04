import java.util.*;
import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;
public class Ride 
{
    private Double sourceLatitude;
    private Double sourceLongitude;
    private Double destinationLatitude;
    private Double destinationLongitude;
    private Double rideFare;
    static Scanner sc = new Scanner(System.in);
    private Vehicle vehicleDetails;


    Ride(Double sourceLatitude, Double sourceLongitude,Double destinationLatitude,Double destinationLongitude)
    {
        this.sourceLatitude = sourceLatitude;
        this.sourceLongitude = sourceLongitude;
        this.destinationLatitude = destinationLatitude;
        this.destinationLongitude = destinationLongitude;
    }


    public static void getRide(String username) throws InterruptedException
    {
        System.out.println("\n\nEnter your Location Latitude");
        Double sourceLatitude = sc.nextDouble();
        System.out.println("Enter your Location Longitude");
        Double sourceLongitude = sc.nextDouble();
        System.out.println("Enter Destiantion Latitude");
        Double destinationLatitude = sc.nextDouble();
        System.out.println("Enter Destiantion Longitude");
        Double destinationLongitude = sc.nextDouble();
        Ride r = new Ride(sourceLatitude,sourceLongitude,destinationLatitude,destinationLongitude);
        try
        {
            r.vehicleDetails = Vehicle.findVehicle(r.sourceLatitude,r.sourceLongitude);
            System.out.println("Grabbing you a ride please wait");
            TimeUnit.SECONDS.sleep(10);
            System.out.println("\n\nCaught you an ride :");
            System.out.println("Ride Details");
            r.calculateFare();
            System.out.println(r);
            System.out.println("\n\nDo You want to confrim ride (y/n)?");
            char confirmChoice = sc.next().charAt(0);
            if(confirmChoice == 'y')
            {
                Database.vehicleDtabase.remove(r.vehicleDetails.getVehicleNumber());
                System.out.println("\nYour Ride has been booked");
                ArrayList<Ride> rideHistory = new ArrayList<>();
                if(Database.userHistory.containsKey(username))
                {
                    rideHistory = Database.userHistory.get(username);
                    rideHistory.add(r);
                } 
                else 
                {
                    rideHistory.add(r);
                    Database.userHistory.put(username, rideHistory);
                }
            }
            else
            {
                System.out.println("You've Declined the ride");
            }
        }
        catch(NullPointerException e)
        {
            System.out.println("\n\nSorry No rides found at this time");
        }
    }


    public static void getHistory(String username)
    {   
        if(Database.userHistory.get(username) == null) 
        {
            System.out.println("\nSorry No History Found\n");
        }
        else
        {
            ArrayList<Ride> rideHistory = Database.userHistory.get(username);
            System.out.println(rideHistory);
        }

    }


    public Vehicle getVehicleInformation()
    {
        return this.vehicleDetails;
    }


    private void calculateFare()
    {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        double rate = Database.RATE_DETAILS.get(this.vehicleDetails.getVehicleType());
        double distance = Math.sqrt(Math.pow(this.destinationLatitude - this.sourceLatitude, 2) + 
                          Math.pow(this.destinationLongitude - this.sourceLongitude, 2));
        this.rideFare = Double.parseDouble(nf.format((distance/10) * rate));

    }


    @Override
    public String toString()
    {
        return "\nPickup Location Latitude : "+this.sourceLatitude+
        "\nPickup Location Longitude : "+this.sourceLongitude+
        "\nDestination Latitude : "+this.destinationLatitude+
        "\nDestination Latitude : "+this.destinationLongitude+
        "\nVehicle Details : \n"+this.vehicleDetails+
        "\nRide Fare : Rs."+this.rideFare+"\n";
    }
    
}
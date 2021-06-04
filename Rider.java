import java.util.concurrent.TimeUnit;

public class Rider 
{
    private String riderName;
    private String username;
    private String password;
    private String riderNumber;
    private String vehicleType;
    private String vehicleNumber;
    private Double latitude;
    private Double longitude;

    Rider(String riderName , String username , String password , String vechicleNumber , String riderNumber , String vehicleType)
    {
        this.riderName = riderName;
        this.username = username;
        this.password = password;
        this.vehicleNumber = vechicleNumber;
        this.riderNumber = riderNumber;
        this.vehicleType = vehicleType;
    }


    @Override
    public String toString()
    {
        return "Name: "+this.riderName+" Username: "+this.username+" Pass: "+this.password;
    }


    public void setDetails(Double latitude , Double longitude )
    {
        this.latitude = latitude;
        this.longitude = longitude;
        Database.vehicleDtabase.put(this.vehicleNumber, new Vehicle(this.vehicleNumber, this.vehicleType, this.riderName, this.riderNumber, this.latitude, this.latitude));
        System.out.println("\nDetails Set Successfully\n");
       // this.showStatus();
    }


    public void updateLocation(Double latitude , Double longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
        Database.vehicleDtabase.put(this.vehicleNumber, new Vehicle(this.vehicleNumber, this.vehicleType, this.riderName, this.riderNumber, this.latitude, this.longitude) );
        System.out.println("\nUpdate Location Successfully\n");
        //this.showStatus();
    }


    public void makeUnavailable() throws InterruptedException
    {
        System.out.println("Please Wait...");
        TimeUnit.SECONDS.sleep(3);
        if(Database.vehicleDtabase.get(this.vehicleNumber) != null)
        {
            Database.vehicleDtabase.remove(this.vehicleNumber);
            System.out.println("\nYou have been made UNAVAILABLE for Accepting Rides\n");
        }
        else
        {
            System.out.println("\nYou are already UNAVAILABLE for Accepting Rides\n");
        }
        //this.showStatus();
    }


    public void makeAvailable() throws InterruptedException
    {
        if(Database.vehicleDtabase.get(this.vehicleNumber) != null)
        {
            System.out.println("\nYou are Already made AVAILABLE for Accepting Rides\n");
        }
        else
        {
            TimeUnit.SECONDS.sleep(3);
            this.setDetails(latitude, longitude);
            System.out.println("\nYou are now made AVAILABLE for Accepting Rides\n");
        }
       // this.showStatus();
    }


    public String getUsername()
    {
        return this.username;
    }


    public String getPassword()
    {
        return this.password;
    }


    public String getName()
    {
        return this.riderName;
    }

    // public void showStatus()
    // {
    //     System.out.println(Database.vehicleDtabase.get(this.vehicleNumber));
    // }
}

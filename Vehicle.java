public class Vehicle
{
    private String vehicleNumber;
    private Double latitude;
    private Double longitude;
    private String vehicleType;
    private String driverName;
    private String driverNumber;


    Vehicle(String vehicleNumber,String vehicleType,String driverName,String driverNumber,Double latitude,Double longitude)
    {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.driverName = driverName;
        this.driverNumber = driverNumber;
        this.latitude = latitude;
        this.longitude = longitude;
        //System.out.println(toString());
    }


    public static Vehicle findVehicle(Double latitude , Double longitude)
    {
        return Database.findNearsetVehicle(latitude, longitude, 50D);
    }


    public String getVehicleNumber()
    {
        return this.vehicleNumber;
    }


    public Double getLatitude()
    {
        return this.latitude;
    }


    public Double getLongitude()
    {
        return this.longitude;
    }


    public String getVehicleType()
    {
        return this.vehicleType;
    }


    @Override
    public String toString()
    {
        return "\tVehicle Number : " + this.vehicleNumber +
        "\n\tVechile Type : "+ this.vehicleType +
        "\n\tDriver Name : "+ this.driverName+
        "\n\tDriver Number : "+ this.driverNumber+"\n"+
        "\tDriver Latitude : "+this.latitude+
        "\n\tDriver Longitude : "+this.longitude;
    }
}
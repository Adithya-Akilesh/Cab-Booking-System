import java.util.*;
public class RiderConsole 
{
    public static void main(String[] args) throws InterruptedException 
    {
        Scanner sc = new Scanner(System.in);
        int mainMenuChoice;
        System.out.println("\n\nWelcome to Cab Booking System");
        do
        {
            System.out.println("\n\n1 - Sign Up");
            System.out.println("2 - Login");
            System.out.println("3 - Exit\n\n");
            System.out.println("Enter Your Choice");
            mainMenuChoice = sc.nextInt();
            switch(mainMenuChoice)
            {
                case 1:
                {
                    Database.riderSignUp();
                    break;
                }
                case 2:
                {
                    Rider r = Database.riderLogIn();
                    int riderChoice;
                    System.out.println("\nWelcome "+ r.getName());
                    do{
                        System.out.println("\n\nWhat would you like to do ?");
                        System.out.println("1.Set Details");
                        System.out.println("2.Update Location");
                        System.out.println("3.Make Available");
                        System.out.println("4.Make Unavailable");
                        System.out.println("5.Exit\n\n");
                        System.out.println("Enter your choice : ");
                        riderChoice = sc.nextInt();
                        switch(riderChoice)
                        {
                            case 1:
                            {
                                System.out.println("\n\nSetting Details");
                                System.out.println("Enter your Latitude");
                                Double latitude = sc.nextDouble();
                                System.out.println("Enter your Longitude");
                                Double longitude = sc.nextDouble();
                                r.setDetails(latitude, longitude);
                                break;
                            }
                            case 2:
                            {
                                System.out.println("\n\nUpdating Location");
                                System.out.println("Enter your Latitude");
                                Double latitude = sc.nextDouble();
                                System.out.println("Enter your Longitude");
                                Double longitude = sc.nextDouble();
                                r.updateLocation(latitude, longitude);
                                break;
                            }
                            case 3:
                            {
                                System.out.println("\n\nMaking You Available.....");
                                r.makeAvailable();
                                break;
                            }
                            case 4:
                            {
                                System.out.println("\n\nMaking You Unavailable......");
                                r.makeUnavailable();
                                break;
                            }
                            case 5:
                            {
                                r.makeUnavailable();
                                System.out.println("Logging Out and Exiting");
                                sc.close();
                                System.exit(0);
                            }
                            default :
                            {
                                System.out.println("Enter values from 1-5");
                            }
                        }
                    }while(true);
                }
                case 3:
                {
                    System.out.println("Exiting");
                    sc.close();
                    System.exit(0);
                    break;
                }
                default :
                {
                    System.out.println("Enter Values only from 1 - 3");
                    break;
                }
            }
        }while(true);
    }   
}

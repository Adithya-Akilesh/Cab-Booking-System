import java.util.*;
public class UserConsole 
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
                    Database.signUp();
                    break;
                }
                case 2:
                {
                    Customer c = Database.logIn();
                    int bookingChoice;
                    System.out.println("\nWelcome "+ c.getName());
                    do{
                        System.out.println("\n\nWhat would you like to do ?");
                        System.out.println("1.Book New Ride");
                        System.out.println("2.View Booking History");
                        System.out.println("3.Exit\n\n");
                        System.out.println("Enter your choice : ");
                        bookingChoice = sc.nextInt();
                        switch(bookingChoice)
                        {
                            case 1:
                            {
                                Ride.getRide(c.getUsername());
                                break;
                            }
                            case 2:
                            {
                                System.out.println("\n\nPrevious Rides");
                                Ride.getHistory(c.getUsername());
                                break;
                            }
                            case 3:
                            {
                                System.out.println("Logging Out and Exiting");
                                sc.close();
                                System.exit(0);
                            }
                            default :
                            {
                                System.out.println("Enter values from 1-3");
                            }
                        }
                    }while(true);
                }
                case 3:
                {
                    System.out.println("Thank You for using our service");
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
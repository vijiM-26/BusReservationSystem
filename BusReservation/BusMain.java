import java.util.*;
import java.sql.*;

public class BusMain {
    public static void main(String[] args) throws SQLException {
            Scanner sc= new Scanner(System.in);
    // now we have to display the details of the buses from the database to the users
    BusDAO busDAO = new BusDAO();
    try{
    busDAO.displayBusInfo();
    
    while(true){
        
        System.out.println("Enter 1 -> Book" +"\n"+"Enter 2 -> Exit");
        // now get choice from the user
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                // Booking option is selected
                Booking booking = new Booking(); // Booking constructor is called while creating this object
                if(booking.isAvailable()){
                    // if available we have to confirm booking by inserting the booking info into booking table
                    BookingDAO bookingDAO = new BookingDAO();
                    // inside booking object we have all booking informations, 
                    // so send this object to BookingDAO to insert the record into Booking table
                    bookingDAO.addBooking(booking);
                    System.out.println("Booking Confirmed!");
                }else
                    System.out.println("Sorry! Bus is full. Try other bus or date");
                break;
            case 2:
                System.exit(0);   // if choice is 2 it gets out of while loop => so the program exits
                break;
            default:
                System.out.println("Enter valid choice");
                break;
        }
    }  
    }catch(Exception e){
        System.out.println(e);
    }finally{
        sc.close();
    }
}
}

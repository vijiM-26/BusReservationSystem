import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Booking {
    String passengerName;
    int busNo;
    Date date;

    Booking() throws ParseException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of the passenger: ");
        passengerName = scanner.nextLine();
        System.out.println("Enter bus no: ");
        busNo = scanner.nextInt();
        System.out.println("Enter date (in this format dd-mm-yyyy):");
        // we are getting the input as string and then converting it to date format
        String dateInput = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        // now str=oring the converted date into date variable
        date = dateFormat.parse(dateInput); 
    }

    // Booking() throws ParseException {
    //     Scanner scanner = new Scanner(System.in);
    //     System.out.println("Enter name of the passenger: ");
    //     passengerName = scanner.nextLine();

    //     // Input validation for bus number
    //     boolean validBusNo = false;
    //     while (!validBusNo) {
    //         try {
    //             System.out.println("Enter bus no: ");
    //             busNo = Integer.parseInt(scanner.nextLine());
    //             validBusNo = true;
    //         } catch (NumberFormatException e) {
    //             System.out.println("Invalid bus number. Please enter a valid number.");
    //         }
    //     }

    //     // Input validation for date format
    //     boolean validDate = false;
    //     SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    //     while (!validDate) {
    //         try {
    //             System.out.println("Enter date (in this format dd-mm-yyyy):");
    //             String dateInput = scanner.nextLine();
    //             date = dateFormat.parse(dateInput);
    //             validDate = true;
    //         } catch (ParseException e) {
    //             System.out.println("Invalid date format. Please use dd-mm-yyyy.");
    //         }
    //     }
    // }

// First
    // now we want to get the capacity of the bus which is now booked by the user
// Secondly
    // we need to get the total number of already booked users for the bus 
    // which is now booked by the user in the same date
    public boolean isAvailable() throws SQLException{
            // to get capacity of the given bus we need to access bus table => we already have BusDAO for that
            BusDAO busDAO = new BusDAO();
            int capacity = busDAO.getCapacity(busNo);

            // now create BookingDAO to access booking table
            BookingDAO bookingDAO = new BookingDAO();
            int booked = bookingDAO.getBookedCount(busNo, (java.util.Date) date);

            return booked<=capacity?true:false;
    }
}

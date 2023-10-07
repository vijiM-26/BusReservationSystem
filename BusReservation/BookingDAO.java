import java.sql.*;
import java.util.Date;

public class BookingDAO {
    public int getBookedCount(int busNo, Date date) throws SQLException{
        String query = "SELECT COUNT(passenger_name) FROM booking WHERE bus_no=? AND travel_date=?";
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime()); // used to convert the java date to sql understanding date
        // so that the sql gets the date in its own format
        pst.setInt(1, busNo);
        pst.setDate(2, sqlDate);

        ResultSet rs = pst.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    public void addBooking(Booking booking) throws SQLException {
        String query = "INSERT INTO booking VALUES(?,?,?)";
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, booking.passengerName);
        pst.setInt(2, booking.busNo);
        java.sql.Date sqlDate = new java.sql.Date(booking.date.getTime());
        pst.setDate(3, sqlDate);

        pst.executeUpdate();
    }

}

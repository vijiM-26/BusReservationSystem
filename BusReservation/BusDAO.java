// bus database access object
// - usually data is fetched, updated or deleted from database through this class
// -by creating an object in main method we can access the methods from this class

import java.sql.*;;

public class BusDAO {
    public void displayBusInfo() throws SQLException{
        // create query for selecting all records from table bus
        String query = "SELECT * FROM bus";
        // now we have to create connection to database
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        // from resultset rs, we are printing the records
        while(rs.next()){
            System.out.print("Bus No:" + rs.getInt(1)); // getting first column (bus number)
            if(rs.getInt(2) == 0){ // getting second column (ac means 1/ non-ac means 0)
                System.out.print(" NON-AC");
            }else{
                System.out.print(" AC");
            }
            System.out.println(" Capacity:" + rs.getInt(3)); // getting third column (capacity of the bus)
        }

        System.out.println("--------------------------------------------------------");
    }

    public int getCapacity(int busNo) throws SQLException{
        String query = "SELECT capacity FROM bus WHERE id =" + busNo;
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        rs.getInt(1);
        return busNo;
    }
}

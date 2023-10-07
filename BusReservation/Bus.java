public class Bus {
    // MODEL in MVC -> (In class we define variables from database) Model of the database represented in class
    int busNo;
    boolean ac;
    int capacity;
    Bus(int no, boolean ac, int cap){
        this.busNo = no;
        this.ac = ac;
        this.capacity = cap;
    }

    public int getCapacity(){
        return capacity;
    }
    public void setCapacity(int cap){
        capacity = cap;
    }
    public int getBusNo(){
        return busNo;
    }

    public boolean isAc(){
        return ac;
    }

    public void setAc(boolean val){
        ac = val;
    }

}

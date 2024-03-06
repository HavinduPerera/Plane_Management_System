public class Ticket {
    private String row;
    private int seat;
    private double price;
    private Person person;

    public Ticket(String row, int seat, double price, Person person){
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public String getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return ("Person Name : " + person.getName()+ "\nPerson Surname : " + person.getSurname() + "\nPerson Email : " + person.getEmail() +
                "\nRow : " + getRow() + "\nSeat : " + getSeat() + "\nPrice : " + getPrice());
    }

    public void print(){
        System.out.println(toString());
    }
}

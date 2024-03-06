import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PlaneManagement {
    public static int[] rowA = new int[14];
    public static int[] rowB = new int[12];
    public static int[] rowC = new int[12];
    public static int[] rowD = new int[14];
    public static ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option = 0;

        System.out.println("""
                ****************************************************
                \t Welcome to the Plane Management application
                *****************************************************
                """);


        label:
        while (true) {
            try {
                System.out.println("""
                        *************************************************
                        *\t \t \t \t  Menu Options  \t \t \t \t*
                        *************************************************
                                        
                        \t1) Buy a seat
                        \t2) Cancel a seat
                        \t3) Find first available seat
                        \t4) Show seating plan
                        \t5) Print tickets information and total sales
                        \t6) Search ticket
                        \t0) Quit
                                        
                        *************************************************
                        """);

                option = input.nextInt();
                switch (option) {
                    case 1:
                        buy_seat();
                        break;

                    case 2:
                        cancel_seat();
                        break;

                    case 3:
                        find_first_available();
                        break;

                    case 4:
                        show_seating_plan();
                        break;

                    case 5:
                        print_tickets_info();
                        break;

                    case 6:
                        search_ticket();
                        break;

                    case 0:
                        System.out.println("Thank You");
                        break label;

                    default:
                        System.out.println("Please enter a valid input.");
                        break;
                }
            } catch (Exception e){
                System.out.println("Invalid Input");
                input.nextLine();
            }
        }
    }

    public static void buy_seat(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Row Letter : ");
        while (!input.hasNext("[A,B,C,D,a,b,c,d]")){
            System.out.println("Wrong Row Letter");
            input.next();
        }
        String row = input.next().toUpperCase();

        if (row.equals("A")){
            System.out.println("Enter the Seat Number : ");
            int seat = input.nextInt();
            if (seat < rowA.length+1){
                if (rowA[seat - 1] == 1){
                    System.out.println("Sorry, Already Booked!");
                }else {
                    rowA[seat - 1] = 1;
                    add_details(row,seat);
                    System.out.println("Successfully Booked!");
                    save(row , seat);
                }
            }else {
                System.out.println("Wrong Seat Number");
            }

        } else if (row.equals("B")) {
            System.out.println("Enter the Seat Number : ");
            int seat = input.nextInt();
            if (seat < rowB.length+1) {
                if (rowB[seat-1] == 1){
                    System.out.println("Sorry, Already Booked!");
                }else {
                    rowB[seat - 1] = 1;
                    add_details(row,seat);
                    System.out.println("Successfully Booked!");
                    save(row , seat);
                }
            } else {
                System.out.println("Wrong Seat Number");
            }
        }else if (row.equals("C")) {
            System.out.println("Enter the Seat Number : ");
            int seat = input.nextInt();
            if (seat < rowC.length+1) {
                if (rowC[seat-1] == 1){
                    System.out.println("Sorry, Already Booked!");
                }else {
                    rowC[seat - 1] = 1;
                    add_details(row,seat);
                    System.out.println("Successfully Booked!");
                    save(row , seat);
                }
            } else {
                System.out.println("Wrong Seat Number");
            }
        }else if (row.equals("D")) {
            System.out.println("Enter the Seat Number : ");
            int seat = input.nextInt();
            if (seat < rowD.length+1) {
                if (rowD[seat-1] == 1){
                    System.out.println("Sorry, Already Booked!");
                }else {
                    rowD[seat - 1] = 1;
                    add_details(row,seat);
                    System.out.println("Successfully Booked!");
                    save(row , seat);
                }
            } else {
                System.out.println("Wrong Seat Number");
            }
        }else {
            System.out.println("Wrong Row Letter");
        }

    }

    public static void cancel_seat(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Row Letter : ");
        while (!input.hasNext("[A,B,C,D,a,b,c,d]")){
            System.out.println("Wrong Row Letter");
            input.next();
        }
        String row = input.next().toUpperCase();

        if (row.equals("A")){
            System.out.println("Enter the Seat Number : ");
            int seat = input.nextInt();
            if (seat < rowA.length+1){
                if (rowA[seat-1] == 1) {
                    rowA[seat-1] = 0;
                    cancel_details(row , seat);
                    System.out.println("Successfully Canceled!");

                }else{
                    System.out.println("Seat Already Available");
                }
            }else {
                System.out.println("Wrong Seat Number");
            }

        }
        if (row.equals("B")){
            System.out.println("Enter the Seat Number : ");
            int seat = input.nextInt();
            if (seat < rowB.length+1){
                if (rowB[seat-1] == 1) {
                    rowB[seat-1] = 0;
                    cancel_details(row , seat);
                    System.out.println("Successfully Canceled!");

                }else{
                    System.out.println("Seat Already Available");
                }
            }else {
                System.out.println("Wrong Seat Number");
            }

        }
        if (row.equals("C")){
            System.out.println("Enter the Seat Number : ");
            int seat = input.nextInt();
            if (seat < rowC.length+1){
                if (rowC[seat-1] == 1) {
                    rowC[seat-1] = 0;
                    cancel_details(row , seat);
                    System.out.println("Successfully Canceled!");

                }else{
                    System.out.println("Seat Already Available");
                }
            }else {
                System.out.println("Wrong Seat Number");
            }

        }
        if (row.equals("D")){
            System.out.println("Enter the Seat Number : ");
            int seat = input.nextInt();
            if (seat < rowD.length+1){
                if (rowD[seat-1] == 1) {
                    rowD[seat-1] = 0;
                    cancel_details(row , seat);
                    System.out.println("Successfully Canceled!");

                }else{
                    System.out.println("Seat Already Available");
                }
            }else {
                System.out.println("Wrong Seat Number");
            }

        }
    }

    public static void find_first_available(){
        for (int i = 0; i < rowA.length; i++) {
            if (rowA[i] == 0) {
                System.out.println("Row A Seat "+(i+1));
                break;
            } else if (rowB[i] == 0) {
                System.out.println("Row B Seat "+(i+1));
            } else if (rowC[i] == 0) {
                System.out.println("Row C Seat "+(i+1));
            } else if (rowD[i] == 0) {
                System.out.println("Row D Seat "+(i+1));
            }else {
                System.out.println("No available seats");
            }
        }
    }

    public static void show_seating_plan(){
        for (int i = 0; i < rowA.length; i++) {
            if (rowA[i] == 1){
                System.out.print("X");
            }else {
                System.out.print("O");
            }


        }
        System.out.println();

        for (int i = 0; i < rowB.length; i++) {
            if (rowB[i] == 1){
                System.out.print("X");
            }else {
                System.out.print("O");
            }

        }
        System.out.println();

        for (int i = 0; i < rowC.length; i++) {
            if (rowC[i] == 1){
                System.out.print("X");
            }else {
                System.out.print("O");
            }

        }
        System.out.println();

        for (int i = 0; i < rowD.length; i++) {
            if (rowD[i] == 1){
                System.out.print("X");
            }else {
                System.out.print("O");
            }

        }
        System.out.println();
    }

    public static void add_details(String row, int seat){
        Scanner input = new Scanner(System.in);

        while (true){
            try {
                System.out.println("Enter your name : ");
                String name = input.nextLine();
                System.out.println("Enter your surname : ");
                String surname = input.nextLine();
                System.out.println("Enter your Email : ");
                String email = input.nextLine();
                if (email.contains("@") == false){
                    System.out.println("Wrong Email.");
                    continue;
                }

                double price = 0;

                if (seat < 5){
                    price = 200;
                } else if (seat < 9) {
                    price = 150;
                }else {
                    price = 180;
                }

                Person person = new Person(name, surname, email);
                Ticket ticket = new Ticket(row, seat, price, person);
                tickets.add(ticket);
                break;
            }catch (Exception e){
                System.out.println("Invalid Input.");
                input.nextLine();
            }
        }
    }

    public static void cancel_details(String row, int seat){
        for (int i = 0; i < tickets.size(); i++) {
            Ticket ticket = tickets.get(i);
            if (ticket.getRow() == row && ticket.getSeat() == seat){
                tickets.remove(ticket);
                break;
            }
        }
    }

    public static void print_tickets_info(){
        double totalPrice = 0;

        for (int i = 0; i < tickets.size(); i++) {
            Ticket ticket = tickets.get(i);
            ticket.print();
            System.out.println();

            totalPrice = totalPrice + ticket.getPrice();
        }

        System.out.println();
        System.out.println("Total : " + totalPrice);
    }

    public static void search_ticket(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the Row Letter : ");
        while (!input.hasNext("[A,B,C,D,a,b,c,d]")){
            System.out.println("Wrong Row Letter");
            input.next();
        }
        String row = input.next().toUpperCase();

        if (row.equals("A")){
            System.out.println("Enter the Seat Number : ");
            int seat = input.nextInt();

            if (rowA[seat-1] == 1) {
                for (int i = 0; i < tickets.size(); i++) {
                    Ticket ticket = tickets.get(i);
                    ticket.print();
                    break;
                }
            }else {
                System.out.println("This seat is available.");
            }
        }else if (row.equals("B")){
            System.out.println("Enter the Seat Number : ");
            int seat = input.nextInt();

            if (rowB[seat-1] == 1) {
                for (int i = 0; i < tickets.size(); i++) {
                    Ticket ticket = tickets.get(i);
                    ticket.print();
                    break;
                }
            }else {
                System.out.println("This seat is available.");
            }
        }if (row.equals("C")){
            System.out.println("Enter the Seat Number : ");
            int seat = input.nextInt();

            if (rowC[seat-1] == 1) {
                for (int i = 0; i < tickets.size(); i++) {
                    Ticket ticket = tickets.get(i);
                    ticket.print();
                    break;
                }
            }else {
                System.out.println("This seat is available.");
            }
        }if (row.equals("D")){
            System.out.println("Enter the Seat Number : ");
            int seat = input.nextInt();

            if (rowD[seat-1] == 1) {
                for (int i = 0; i < tickets.size(); i++) {
                    Ticket ticket = tickets.get(i);
                    ticket.print();
                    break;
                }
            }else {
                System.out.println("This seat is available.");
            }
        }
    }

    public static void save(String row, int seat){
        try {
            FileWriter planeFile = new FileWriter(row + seat + ".txt");

            for (int i = 0; i < tickets.size(); i++) {
                if (tickets.get(i).getRow().equals(row) && tickets.get(i).getSeat() == seat){
                        planeFile.write(tickets.get(i).toString());
                    }
            }
            planeFile.close();
            System.out.println("File Saved Successfully");

        } catch (IOException e){
            System.out.println("An error occurred");
        }
    }
}

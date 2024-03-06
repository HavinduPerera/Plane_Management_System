public class Person {
    private String name;
    private String surname;
    private String email;

    public Person(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public void print(){
        System.out.println("Name : " + getName());
        System.out.println("Surname : " + getSurname());
        System.out.println("Email : " + getEmail());
    }
}

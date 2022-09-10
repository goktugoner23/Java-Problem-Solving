import java.time.LocalDate;

public class AggregatedClass {
    private int ID;
    private String name;
    private String surname;
    private LocalDate dob;

    public AggregatedClass(int ID, String name, String surname, LocalDate dob) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.dob = dob;
    }
    public int getID()
    {
        return ID;
    }
    public String getname()
    {
        return name;
    }
    public String getsurname()
    {
        return surname;
    }
    public LocalDate getdob()
    {
        return dob;
    }

    public String variables()
    {
        return name + " " + surname + " " + dob;
    }

    //theres another method by declaring a public string method and taking the variables into it.
}

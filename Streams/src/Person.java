import java.util.ArrayList;

public class Person {
    public String firstName;
    public String lastName;
    public int birthYear;

    public Person(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getBirthYear() {
        return this.birthYear;
    }

    public static void main(String[] args) {
        ArrayList<Person> personas = new ArrayList<>();

        personas.add(new Person("Juan", "Pérez", 1960));
        personas.add(new Person("Pedro", "Martínez", 1980));
        personas.add(new Person("Rodrigo", "Juárez", 2005));

        //Contamos los que nacieron antes de 1970
        long nacidosAntes = personas.stream()
                .mapToInt(s -> Integer.valueOf(s.getBirthYear()))
                .filter(number -> number < 1970)
                .count();

        System.out.println("En la lista de personas hay " + nacidosAntes + " nacido/s antes de 1970");
    }
}
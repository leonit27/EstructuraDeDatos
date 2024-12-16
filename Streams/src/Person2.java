import java.util.ArrayList;

public class Person2 {
    public static void main(String[] args) {
        ArrayList<Person> personas = new ArrayList<>();

        personas.add(new Person("Juan", "Abarca", 1960));
        personas.add(new Person("Pedro", "Abascal", 1980));
        personas.add(new Person("Rodrigo", "Juárez", 2005));

        //Contamos las cuales sus apellido empieza por 'A'
        long nacidosAntes = personas.stream()
                .filter(lastName -> lastName.getLastName().charAt(0) == 'A')
                .count();

        System.out.println("En la lista de personas hay " + nacidosAntes + " nacido/s antes de 1970");
    }
}

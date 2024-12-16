import java.util.ArrayList;
import java.util.stream.Collectors;

public class Person3 {
    public static void main(String[] args) {
        ArrayList<Person> personas = new ArrayList<>();

        personas.add(new Person("Juan", "Abarca", 1960));
        personas.add(new Person("Pedro", "Abascal", 1980));
        personas.add(new Person("Rodrigo", "Juárez", 2005));

        //Contamos las cuales sus apellido empieza por 'A'

    }
}

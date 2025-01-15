import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Ejemplo de uso de estructuras de datos básicas en Java

        // 1. ArrayList: Un array dinámico que permite elementos duplicados y mantiene el orden de inserción.
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Item1");
        arrayList.add("Item2");
        System.out.println("ArrayList: " + arrayList);
        // Operaciones adicionales con ArrayList
        arrayList.set(1, "NewItem2"); // Modifica un elemento
        System.out.println("Elemento en índice 1: " + arrayList.get(1));
        System.out.println("Contiene 'Item1': " + arrayList.contains("Item1"));
        arrayList.remove("Item1"); // Elimina un elemento
        System.out.println("ArrayList después de eliminar: " + arrayList);
        Collections.sort(arrayList); // Ordena la lista
        System.out.println("ArrayList ordenado: " + arrayList);

        // 2. HashMap: Una colección de pares clave-valor que permite valores y claves nulos. No garantiza el orden.
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Key1", 100);
        hashMap.put("Key2", 200);
        System.out.println("HashMap: " + hashMap);
        // Operaciones adicionales con HashMap
        System.out.println("Valores: " + hashMap.values());
        System.out.println("Claves: " + hashMap.keySet());
        System.out.println("Valor de 'Key1': " + hashMap.get("Key1"));
        System.out.println("Valor predeterminado: " + hashMap.getOrDefault("Key3", 0));
        hashMap.remove("Key1");
        System.out.println("HashMap después de eliminar 'Key1': " + hashMap);
        System.out.println("Contiene clave 'Key2': " + hashMap.containsKey("Key2"));

        // 3. TreeMap: Un mapa ordenado que mantiene el orden natural o un comparador personalizado.
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("KeyA", 300);
        treeMap.put("KeyB", 400);
        System.out.println("TreeMap: " + treeMap);
        // Operaciones adicionales con TreeMap
        System.out.println("Claves ordenadas: " + treeMap.keySet());
        System.out.println("Valores ordenados: " + treeMap.values());
        System.out.println("Valor de 'KeyA': " + treeMap.get("KeyA"));

        // 4. LinkedList: Una lista doblemente enlazada que puede usarse como lista, cola o deque.
        List<String> linkedList = new LinkedList<>();
        linkedList.add("Node1");
        linkedList.add("Node2");
        System.out.println("LinkedList: " + linkedList);
        // Operaciones adicionales con LinkedList
        linkedList.add(1, "InsertedNode"); // Inserta en un índice específico
        System.out.println("LinkedList después de insertar: " + linkedList);
        linkedList.remove("Node1"); // Elimina un elemento
        System.out.println("LinkedList después de eliminar: " + linkedList);

        // 5. HashSet: Una colección que no permite elementos duplicados y no garantiza el orden.
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Element1");
        hashSet.add("Element2");
        System.out.println("HashSet: " + hashSet);
        // Operaciones adicionales con HashSet
        hashSet.add("Element3");
        System.out.println("HashSet después de añadir 'Element3': " + hashSet);
        hashSet.remove("Element2");
        System.out.println("HashSet después de eliminar 'Element2': " + hashSet);
        System.out.println("Contiene 'Element1': " + hashSet.contains("Element1"));

        // 6. Streams: Una forma moderna de procesar colecciones usando conceptos de programación funcional.
        arrayList.stream()
                .filter(item -> item.startsWith("Item"))
                .forEach(System.out::println);

        // 7. BufferedReader: Utilizado para leer archivos de texto de manera eficiente línea por línea.
        try (BufferedReader br = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 8. Interfaz Comparable: Permite que los objetos se comparen para ordenar implementando compareTo.
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 30));
        Collections.sort(people);
        System.out.println("Personas ordenadas: " + people);

        // 9. Stack: Una estructura de datos LIFO (Último en entrar, primero en salir).
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        System.out.println("Stack: " + stack);
        System.out.println("Popped: " + stack.pop());
        System.out.println("Elemento en la cima: " + stack.peek()); // Devuelve el elemento en la cima sin eliminarlo

        // 10. Queue: Una estructura de datos FIFO (Primero en entrar, primero en salir). Offer es preferido sobre add ya que no lanza excepciones en caso de fallo.
        Queue<String> queue = new LinkedList<>();
        queue.offer("First");
        queue.offer("Second");
        System.out.println("Queue: " + queue);
        System.out.println("Polled: " + queue.poll());
        System.out.println("Elemento en la cabeza: " + queue.peek()); // Devuelve el elemento en la cabeza sin eliminarlo
    }

    // Clase para demostrar la interfaz Comparable
    static class Person implements Comparable<Person> {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Person other) {
            return Integer.compare(this.age, other.age);
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }
}
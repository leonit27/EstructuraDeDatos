import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;

public class Felipe {
    public static void main(String[] args) {
        List<Tarea>  tareas = new ArrayList<>();
        tareas.add(new Tarea(1, 6));
        tareas.add(new Tarea(2, 4));
        tareas.add(new Tarea(3, 5));
        System.out.print(ordenar(tareas));
        System.out.println("---");

        tareas = new ArrayList<>();
        tareas.add(new Tarea(30, 7));
        tareas.add((new Tarea(30, 2)));
        System.out.print(ordenar(tareas));
        System.out.println("---");
    }

    public static String ordenar(List<Tarea> tareas){
        StringBuilder sb = new StringBuilder();
        Collections.sort(tareas);
        for (Tarea t:tareas) {
            sb.append(t).append("\n");
        }
        return sb.toString();
    }
}

class Tarea implements Comparable<Tarea>{
    int prioridad, duracion;
    Tarea(int p, int d) {
        this.prioridad = p;
        this.duracion = d;
    }

    @Override
    public String toString(){
        return this.prioridad + " " + this.duracion;
    }
    @Override
    public int compareTo(Tarea other){
        if (this.prioridad == other.prioridad) return this.duracion - other.duracion;

        return other.prioridad - this.prioridad;
    }
}
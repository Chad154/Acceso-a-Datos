import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class CrearDir {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        File d = new File("NUEVODIR"); // directorio que creo
        File f1 = new File(d, "FICHERO1.TXT");
        File f2 = new File(d, "FICHERO2.TXT");
        d.mkdir();// CREAR DIRECTORIO

        try {
            if (f1.createNewFile())
                System.out.println("FICHERO1 creado correctamente...");
            else
                System.out.println("No se ha podido crear FICHERO1...");

            if (f2.createNewFile())
                System.out.println("FICHERO2 creado correctamente...");
            else
                System.out.println("No se ha podido crear FICHERO2...");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        f1.renameTo(new File(d, "FICHERO1NUEVO.TXT"));// renombro FICHERO1

        try {
            File f3 = new File("NUEVODIR/FICHERO3.TXT");
            if (f3.createNewFile())// crea FICHERO3 en NUEVODIR
                System.out.println("Se ha creado el FICHERO3 correctamente");
            else
                System.out.println("No se ha podido crear FICHERO3");
            System.out.println("Introduzca el nombre para renombrar el Fichero3");
            f3.renameTo(new File(d, teclado.nextLine()));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println("Introduzca el nombre para renombrar el Fichero2");
        f2.renameTo(new File(d, teclado.nextLine()));
        if (f1.delete() == true)
            System.out.println("El fichero se ha borrado correctamente");
        else
            System.out.println("El fichero no se ha podido borrar correctamente");

        long milisegundos = f2.lastModified();
        Date fecha = new Date(milisegundos);
        System.out.println("Fecha de la ultima modificacion" + fecha);
    }
}
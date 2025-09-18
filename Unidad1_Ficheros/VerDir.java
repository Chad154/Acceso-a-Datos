import java.io.File;

public class VerDir {
    public static void main(String[] args) {
        // String dir = "."; //directorio actual
        String dir = "/home/chad/Escritorio/Acceso a Datos";
        File f = new File(dir);
        String[] archivos = f.list();
        File[] archivo = f.listFiles();

        System.out.printf("Ficheros en el directorio actual: %d %n", archivos.length);

        for (int i = 0; i < archivos.length; i++) {
            File f2 = new File(f, archivos[i]);
            System.out.printf("Nombre: %s, es fichero?: %b, es directorio?: %b %n", archivos[i], f2.isFile(),
                    f2.isDirectory());
        }
        System.out.println();
        for (int i = 0; i < archivo.length; i++) {
            System.out.println(archivo[i].getName());

        }
    }
}


package codigoAyuda;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Main {
    private Scanner leer;

    public Main() {
        leer = new Scanner(System.in);
    }

    public int get(int Codigo) {
        System.out.println("Introduce el código del producto:");
        int codigo = leer.nextInt();
        return codigo;
    }

    public String get(String Nombre) {
        System.out.println("Introduce el nombre del producto:");
        String nombre = leer.next();
        return nombre;
    }

    public double get(double Precio) {
        System.out.println("Introduce el precio del producto:");
        double precio = leer.nextDouble();
        return precio;
    }

    public void agregarArticulo() {
        try {
            FileWriter fw = new FileWriter("consulta.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(get(1));
            pw.print("," + get(""));
            pw.print("," + get(1.1) + "\n");
            pw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        System.out.println("Se ha añadido el siguiente artículo al inventario:");
        mostrarArticulo();
    }

    public void mostrarArticulo() {
        File archivo = new File("consulta.txt");
    try {
        BufferedReader brCablon = new BufferedReader(new FileReader(archivo));
        String st;
        Vector<String> v = new Vector(40);

        while ((st = brCablon.readLine()) != null) {
            v.addElement(st);
        }
        String[] Arreglo = v.toArray(new String[v.size()]);
        for (String articulo : Arreglo) {
            System.out.println(articulo);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public void modificarArticulo() {
    try {
        File archivo = new File("consulta.txt");
        File archivoTemporal = new File("consulta_temp.txt");

        BufferedReader br = new BufferedReader(new FileReader(archivo));
        PrintWriter pw = new PrintWriter(new FileWriter(archivoTemporal));

        String linea;
        int codigoModificar;

        System.out.println("Introduce el código del artículo a modificar:");
        codigoModificar = leer.nextInt();

        boolean encontrado = false;

        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(",");
            int codigo = Integer.parseInt(partes[0]);

            if (codigo == codigoModificar) {
                encontrado = true;
                System.out.println("Introduce el nuevo código:");
                int nuevoCodigo = leer.nextInt();
                System.out.println("Introduce el nuevo nombre:");
                leer.nextLine(); // Consumir el salto de línea pendiente después de leer el entero
                String nuevoNombre = leer.nextLine();
                System.out.println("Introduce el nuevo precio:");
                double nuevoPrecio = leer.nextDouble();
                pw.println(nuevoCodigo + "," + nuevoNombre + "," + nuevoPrecio);
                System.out.println("El artículo ha sido modificado.");
            } else {
                pw.println(linea);
            }
        }

        br.close();
        pw.close();

        archivo.delete();
        archivoTemporal.renameTo(archivo);

        if (!encontrado) {
            System.out.println("No se encontró ningún artículo con el código especificado.");
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public static void main(String[] args) {
        Main programa = new Main();
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Agregar artículo");
            System.out.println("2. Mostrar artículo");
            System.out.println("3. Modificar artículo");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = programa.leer.nextInt();

            switch (opcion) {
                case 1:
                    programa.agregarArticulo();
                    break;
                case 2:
                    programa.mostrarArticulo();
                    break;
                case 3:
                    programa.modificarArticulo();
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 4);
    }
}
                  
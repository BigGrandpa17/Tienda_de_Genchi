package TiendaDeAbarrotes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JOptionPane;

public class TiendaDeAbarrotes {//Daddy

    public static Scanner leer = new Scanner(System.in);
    int codigo; //Variable de tipo entera Publica llamada "codigo"
    String nombre;//Variable de tipo String Publica llamada "nombre"

    public TiendaDeAbarrotes(int Codigo, String Nombre, double Precio) {//Constructor la clase papá
        this.codigo = Codigo;
        this.nombre = Nombre;
    }

}

class Articulo extends TiendaDeAbarrotes {

    double precio;//Variable de tipo Dobule Publica llamada "precio"
    int stock;

    Articulo(int codigo, String nombre, double precio) {
        super(codigo, nombre, precio);
    }

    public int get(int Codigo) {
        System.out.println("Introduce el codigo del nuevo producto:");
        codigo = leer.nextInt();
        return codigo;
    }

    public String get(String Nombre) {
        System.out.println("Introduce el nombre del nuevo producto:");
        nombre = leer.next();
        return nombre;
    }

    public double get(double Precio) {
        System.out.println("Introduce el precio del nuevo producto:");
        precio = leer.nextDouble();
        return precio;
    }

    public void menuRoles() {
        int respuestaUser = 0;
        do {
            System.out.println("Bienvenido a la tienda de abarrotes");
            System.out.println("1.- Soy un cliente    2.-Soy el dueno   3.-Salir del sistema");
            respuestaUser=leer.nextInt();
            switch (respuestaUser) {
                case 1:
                    menuCliente();
                    break;
                case 2:
                    menuDueno();
                    break;
                case 3:
                    System.out.println("Hasta luego y vuelve pronto!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion Invalida, Ingresa de nuevo");
            }
        } while (respuestaUser != 3);
    }

    public void menuCliente() {
        int respuestaCliente = 0;
        do {
            leer.nextLine(); //Limpieza del buffer del scanner
            System.out.println("Que deseas hacer?");
            System.out.println("1.-Adquirir articulos     2.-Ver carrito     3.-Pagar carrito       4.- Regresar al menu anterior   5.-Salir del sistema");
            respuestaCliente = leer.nextInt();
            switch (respuestaCliente) {
                case 1:
                    adquirirArticulos();
                    break;
                case 2:
                    verCarrito();
                    break;
                case 3:
                    pagarCarrito();
                    break;
                case 4:
                    menuRoles();
                    break;
                case 5:
                    System.out.println("Hasta luego y vuelve pronto!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion invalida, Intentalo de nuevo");
            }
        } while (respuestaCliente != 5);
    }

    public void adquirirArticulos() {

    }

    public void verCarrito() {

    }

    public void pagarCarrito() {

    }

    public void menuDueno() {
        int respuestaMenu = 0;
        do {
            leer.nextLine(); //Limpieza del buffer del scanner
            System.out.println("\nMenu:");
            System.out.println("1. Anadir proveedores");
            System.out.println("2. Anadir productos");
            System.out.println("3. Mostrar Proveedores");
            System.out.println("4. Mostrar productos");
            System.out.println("5. Consultar productos");
            System.out.println("6. Consultar proveedores");
            System.out.println("7. Eliminar productos");
            System.out.println("8. Eliminar Proveedores");
            System.out.println("9. Regresar al menu anterior");
            System.out.print("Selecciona una opcion: ");

            respuestaMenu = leer.nextInt();

            switch (respuestaMenu) {
                case 1:
                    anadirProveedores();
                    break;
                case 2:
                    anadirArticulo();
                    break;
                case 3:
                    mostrarProveedores();
                    break;
                case 4:
                    mostarArticulo();
                    break;
                case 5:
                    consultarProductos();
                    break;
                case 6:
                    consultarProveedores();
                    break;
                case 7:
                    eliminarProductos();
                    break;
                case 8:
                    eliminarProveedores();
                    break;
                case 9:
                    menuRoles();
                    break;
                default:
                    System.out.println("Opcion invalida, Inténtalo de nuevo.");
                    break;
            }
        } while (respuestaMenu != 9);
    }

    public void anadirProveedores() {

    }

    public void anadirArticulo() {

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
        System.out.println("Se ha anadido el siguiente articulo al inventario:");
        mostarArticulo();
    }

    public void mostrarProveedores() {

    }

    public void mostarArticulo() {
        File archivo = new File("consulta.txt");
        try {
            FileWriter crear = new FileWriter(archivo, true);
            BufferedReader brCablon = new BufferedReader(new FileReader(archivo));
            PrintWriter escribir = new PrintWriter(crear);
            String st;
            Vector<String> v = new Vector(40);
            for (int i = 0; (st = brCablon.readLine()) != null; i++) {
                v.addElement(st);

            }
            String[] Arreglo = v.toArray(new String[v.size()]);
            System.out.println(Arreglo[(Arreglo.length - 1)]);

        } catch (IOException e) {
        }

    }

    public void consultarProductos() {

    }

    public void consultarProveedores() {

    }

    public void eliminarProductos() {

    }

    public void eliminarProveedores() {

    }

}

class Minero {

    public static void main(String[] args) {
        Articulo articulo = new Articulo(1, "", 1);
        articulo.menuRoles();
    }

}

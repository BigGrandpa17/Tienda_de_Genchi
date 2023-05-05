/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tienda_de_abarrotes;

/**
 *
 * @author Rec17
 */
import java.io.*;
import java.util.*;

// Clase base para artículos
class Articulo {

    private int codigo;
    private String nombre;
    private double precio;

    public Articulo(int codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String toString() {
        return "Código: " + codigo + "\nNombre: " + nombre + "\nPrecio: " + precio;
    }
}

// Clase para gestionar la tienda
class Tienda {

    private ArrayList<Articulo> inventario = new ArrayList<>();
    private String archivoInventario = "inventario.dat";

    // Constructor de la clase
    public Tienda() {
        // Cargar el inventario desde el archivo
        cargarInventario();
    }

    // Método para mostrar el menú
    public void mostrarMenu() {
        int opcion = 0;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Comprar");
            System.out.println("2. Anadir productos");
            System.out.println("3. Eliminar productos");
            System.out.println("4. Consultar productos");
            System.out.println("5. Modificar productos");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opcion: ");

            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    comprar();
                    break;
                case 2:
                    anadirProducto();
                    break;
                case 3:
                    eliminarProducto();
                    break;
                case 4:
                    consultarProductos();
                    break;
                case 5:
                    modificarProducto();
                    break;
                case 6:
                    guardarInventario();
                    System.out.println("¡Gracias por usar la tienda! Hasta pronto.");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        } while (opcion != 6);
    }

    // Método para comprar un producto
    public void comprar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el código del producto que deseas comprar:");
        int codigo = sc.nextInt();

        Articulo articulo = buscarArticulo(codigo);

        if (articulo != null) {
            System.out.println("Has comprado el siguiente articulo:");
            System.out.println(articulo);
        } else {
            System.out.println("No se ha encontrado ningún articulo con ese codigo.");
        }
    }

    // Método para añadir un producto al inventario
    public void anadirProducto() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el codigo del nuevo producto:");
        int codigo = sc.nextInt();

        // Comprobar si el artículo ya existe
        if (buscarArticulo(codigo) != null) {
            System.out.println("Ya existe un artículo con ese codigo.");
            return;
        }

        System.out.println("Introduce el nombre del nuevo producto:");
        String nombre = sc.next();

        System.out.println("Introduce el precio del nuevo producto:");
        double precio = sc.nextDouble();

        Articulo articulo = new Articulo(codigo, nombre, precio);
        inventario.add(articulo);

        System.out.println("Se ha añadido el siguiente articulo al inventario:");
        System.out.println(articulo);
    }

// Método para eliminar un producto del inventario
    public void eliminarProducto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el codigo del producto que deseas eliminar:");
        int codigo = sc.nextInt();

        Articulo articulo = buscarArticulo(codigo);

        if (articulo != null) {
            inventario.remove(articulo);
            System.out.println("Se ha eliminado el siguiente articulo del inventario:");
            System.out.println(articulo);
        } else {
            System.out.println("No se ha encontrado ningún articulo con ese codigo.");
        }
    }

// Método para consultar los productos del inventario
    public void consultarProductos() {
        System.out.println("Inventario:");
        for (Articulo articulo : inventario) {
            System.out.println(articulo);
        }
    }

// Método para modificar un producto del inventario
    public void modificarProducto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el codigo del producto que deseas modificar:");
        int codigo = sc.nextInt();

        Articulo articulo = buscarArticulo(codigo);

        if (articulo != null) {
            System.out.println("Introduce el nuevo precio del producto:");
            double precio = sc.nextDouble();

            articulo.setPrecio(precio);

            System.out.println("El producto se ha modificado correctamente:");
            System.out.println(articulo);
        } else {
            System.out.println("No se ha encontrado ningún articulo con ese código.");
        }
    }

// Método para buscar un artículo por su código
    public Articulo buscarArticulo(int codigo) {
        for (Articulo articulo : inventario) {
            if (articulo.getCodigo() == codigo) {
                return articulo;
            }
        }
        return null;
    }

// Método para cargar el inventario desde el archivo
    public void cargarInventario() {
        try {
            FileInputStream fileIn = new FileInputStream(archivoInventario);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            inventario = (ArrayList<Articulo>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se ha podido cargar el inventario.");
        }
    }

// Método para guardar el inventario en el archivo
    public void guardarInventario() {
        try {
            FileOutputStream fileOut = new FileOutputStream(archivoInventario);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(inventario);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.println("No se ha podido guardar el inventario.");
        }
    }
}

// Clase principal del programa
public class TiendaArticulos {

    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        tienda.mostrarMenu();
    }
}

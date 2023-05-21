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

    int codigo; //Variable de tipo entera Publica llamada "codigo"
    String nombre;//Variable de tipo String Publica llamada "nombre"

    public TiendaDeAbarrotes(int Codigo, String Nombre, double Precio) {//Constructor la clase papá
        this.codigo = Codigo;
        this.nombre = Nombre;
    }

}

class Articulo extends TiendaDeAbarrotes {

    Scanner leer = new Scanner(System.in);
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

    public void mostrarMenu() {
        
        int respuestaMenu = 0;

        System.out.println("\nMenu:");
        System.out.println("1. Añadir proveedores");
        System.out.println("2. Anadir productos");
        System.out.println("3. Eliminar productos");
        System.out.println("4. Consultar productos");
        System.out.println("5. Modificar productos");
        
        System.out.println("6. Mostrar Carrito");
        System.out.println("7. Salir");
        System.out.print("Selecciona una opcion: ");

        Scanner sc = new Scanner(System.in);
        respuestaMenu = sc.nextInt();

        if (respuestaMenu == 1) {
            
        } else if (respuestaMenu == 2) {
            añadirArticulo();
        } else if (respuestaMenu == 3) {
            
        } else if (respuestaMenu == 4) {
            mostarArticulo();
        } else if (respuestaMenu == 5) {
            
        } else if (respuestaMenu == 6) {
            System.out.println("Productos en el carrito:");
            
        } else if (respuestaMenu == 7) {
            
            System.out.println("Gracias por usar la tienda! Hasta pronto.");
        } else {
            System.out.println("Opcion invalida, Inténtalo de nuevo.");
        }

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
    
    public void añadirArticulo() {

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
    
   

   
    
    
}
class Minero{
    public static void main(String[] args) {
        Articulo artico = new Articulo(1, "", 1);
    artico.mostrarMenu();
    }
    
}

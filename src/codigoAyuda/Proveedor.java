package codigoAyuda;

import java.util.Scanner;

public class Proveedor {

    String id;
    String nombre;
    String empresa;

    public Proveedor(String id, String nombre, String empresa) {
        this.id = id;
        this.nombre = nombre;
        this.empresa = empresa;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmpresa() {
        return empresa;
    }

    public static void main(String[] args) {
        String id = "";
        String nombre = "";
        String empresa = "";

        Scanner leer = new Scanner(System.in);
        Scanner leerint = new Scanner(System.in);
        Proveedor[] arregloProveedores = new Proveedor[100]; // Creamos un arreglo de objetos Proveedor con capacidad para 100 elementos
        int proveedoresExistentes = 0; // Variable para contar el número de proveedores ingresados
        int respuestaProvedor = 0;
        int contadorProvedores = 0;

        while (contadorProvedores < 1) {

            System.out.println("Menu Provedores");
            System.out.println("Presiona 1 para agregar");
            System.out.println("Presiona 2 para mostrar");
            System.out.println("Presiona 3 para salir");
            respuestaProvedor = leerint.nextInt();

            if (respuestaProvedor == 1) {
                System.out.print("Ingresa el ID del proveedor: ");
                id = leer.nextLine();

                System.out.print("Ingresa el nombre del proveedor: ");
                nombre = leer.nextLine();

                System.out.print("Ingresa la empresa del proveedor: ");
                empresa = leer.nextLine();
            
            }
            if (respuestaProvedor == 2) {
                arregloProveedores[proveedoresExistentes] = new Proveedor(id, nombre, empresa); // Creamos un nuevo objeto Proveedor con los datos ingresados y lo agregamos al arreglo
                proveedoresExistentes++; // Incrementamos el contador de proveedores ingresados

                System.out.println("Se han ingresado " + proveedoresExistentes + " proveedores:");

                for (int i = 0; i < proveedoresExistentes; i++) {
                    System.out.println("Proveedor " + (i + 1) + " - ID: " + arregloProveedores[i].getId() + ", Nombre: " + arregloProveedores[i].getNombre() + ", Empresa: " + arregloProveedores[i].getEmpresa());
                }
              
            }
            if (respuestaProvedor == 3) {
                if (proveedoresExistentes > 0) {
                    int idEliminado=0;
                        System.out.print("Ingrese el ID del proveedor a eliminar: ");
                        idEliminado = leerint.nextInt();
                        int indiceEliminar = -1;
                        for (int i = 0; i < numProveedores; i++) {
                            if (proveedores[i].idProveedor == idEliminar) {
                                indiceEliminar = i;
                                break;
                            }
                        }
                        if (indiceEliminar != -1) {
                            for (int i = indiceEliminar; i < numProveedores - 1; i++) {
                                proveedores[i] = proveedores[i+1];
                            }
                            numProveedores--;
                            System.out.println("Proveedor eliminado con éxito");
                        } else {
                            System.out.println("No se encontró un proveedor con ese ID");
                        }
                    } else {
                        System.out.println("No hay proveedores registrados");
                    }
            }

        }
        contadorProvedores = 0;

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigoAyuda;

import java.util.Scanner;

public class Proveedor1 {
    int idProveedor;
    String nombreProveedor;
    String empresaProveedor;
    
    public Proveedor1(int idProveedor, String nombreProveedor, String empresaProveedor) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.empresaProveedor = empresaProveedor;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Proveedor1[] proveedores = new Proveedor1[10]; // Se puede cambiar el tamaño del arreglo según se necesite
        int opcion = 0;
        int numProveedores = 0;
        
        do {
            System.out.println("\n=== Menú de opciones ===");
            System.out.println("1. Agregar proveedor");
            System.out.println("2. Mostrar proveedores");
            System.out.println("3. Eliminar proveedor");
            System.out.println("4. Salir");
            System.out.print("Ingrese la opción deseada: ");
            
            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
                    if (numProveedores < proveedores.length) {
                        System.out.print("Ingrese el ID del proveedor: ");
                        int idProveedor = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Ingrese el nombre del proveedor: ");
                        String nombreProveedor = sc.nextLine();
                        System.out.print("Ingrese la empresa del proveedor: ");
                        String empresaProveedor = sc.nextLine();
                        proveedores[numProveedores] = new Proveedor1(idProveedor, nombreProveedor, empresaProveedor);
                        numProveedores++;
                        System.out.println("Proveedor agregado con éxito");
                    } else {
                        System.out.println("No se pueden agregar más proveedores, el límite ha sido alcanzado");
                    }
                    break;
                case 2:
                    if (numProveedores > 0) {
                        System.out.println("\n=== Proveedores registrados ===");
                        for (int i = 0; i < numProveedores; i++) {
                            System.out.println("ID: " + proveedores[i].idProveedor + "\tNombre: " + proveedores[i].nombreProveedor + "\tEmpresa: " + proveedores[i].empresaProveedor);
                        }
                    } else {
                        System.out.println("No hay proveedores registrados");
                    }
                    break;
                case 3:
                    if (numProveedores > 0) {
                        System.out.print("Ingrese el ID del proveedor a eliminar: ");
                        int idEliminar = sc.nextInt();
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
                    break;
                case 4:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 4);
    }
}
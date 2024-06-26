/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete4;

import java.util.ArrayList;
import paquete2.Arriendo;
import paquete3.ArriendoLocalComercial;
import paquete3.ArriendoLocalComida;
import paquete3.ArriendoLocalSesiones;
import java.util.Scanner;
public class Ejecutor2 {

    public static void main(String[] args) {
        
        ArrayList<Arriendo> listaArriendos = new ArrayList<>();
         
        Scanner sc= new Scanner (System.in);
        System.out.print("¿Cuántos arriendos desea agregar? ");
        int cantidadArriendos = sc.nextInt();
        sc.nextLine();  

        for (int i = 0; i < cantidadArriendos; i++) {
            System.out.println("Seleccione el tipo de arriendo:");
            System.out.println("1. Arriendo Local Comida");
            System.out.println("2. Arriendo Local Comercial");
            System.out.println("3. Arriendo Local Sesiones");
            System.out.print("Opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del arrendatario: ");
                    String nombreComida = sc.nextLine();
                    System.out.print("Ingrese el valor base del arriendo: ");
                    double valorBaseComida = sc.nextDouble();
                    sc.nextLine();  

                    ArriendoLocalComida arriendoComida = new ArriendoLocalComida(nombreComida, valorBaseComida);
                    System.out.print("Ingrese el IVA (en porcentaje): ");
                    double iva = sc.nextDouble();
                    arriendoComida.establecerIva(iva);
                    System.out.print("Ingrese el valor del agua: ");
                    double valorAgua = sc.nextDouble();
                    arriendoComida.establecerValorAgua(valorAgua);
                    System.out.print("Ingrese el valor de la luz: ");
                    double valorLuz = sc.nextDouble();
                    arriendoComida.establecerValorLuz(valorLuz);
                    listaArriendos.add(arriendoComida);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del arrendatario: ");
                    String nombreComercial = sc.nextLine();
                    System.out.print("Ingrese el valor base del arriendo: ");
                    double valorBaseComercial = sc.nextDouble();
                    sc.nextLine();  

                    ArriendoLocalComercial arriendoComercial = new ArriendoLocalComercial(nombreComercial, valorBaseComercial);
                    System.out.print("Ingrese el valor adicional fijo: ");
                    double valorAdicionalFijo = sc.nextDouble();
                    arriendoComercial.establecerValorAdicionalFijo(valorAdicionalFijo);
                    listaArriendos.add(arriendoComercial);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del arrendatario: ");
                    String nombreSesiones = sc.nextLine();
                    System.out.print("Ingrese el valor base del arriendo: ");
                    double valorBaseSesiones = sc.nextDouble();
                    sc.nextLine();  

                    ArriendoLocalSesiones arriendoSesiones = new ArriendoLocalSesiones(nombreSesiones, valorBaseSesiones);
                    System.out.print("Ingrese el valor de las sillas: ");
                    double valorSillas = sc.nextDouble();
                    arriendoSesiones.establecerValorSillas(valorSillas);
                    System.out.print("Ingrese el valor de la amplificación: ");
                    double valorAmplificacion = sc.nextDouble();
                    arriendoSesiones.establecerValorAmplificacion(valorAmplificacion);
                    listaArriendos.add(arriendoSesiones);
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }

        for (Arriendo arriendo : listaArriendos) {
            arriendo.establecerArriendoMensual();
        }

        CentroComercial centro = new CentroComercial("La Pradera", listaArriendos);
        centro.establecerTotalArriendosBaseMensual();
        centro.establecerTotalArriendosFinalMensual();
        System.out.println(centro);
    }
}

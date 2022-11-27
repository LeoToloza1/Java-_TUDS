/**
 **************** EJERCICIO 2 Y EJERCICIO  3****************
 *
 * Siguiendo el ejercicio anterior, en el main vamos a crear un ArrayList de
 * Electrodomésticos para guardar 4 electrodomésticos, ya sean lavadoras o
 * televisores, con valores ya asignados.
 * Luego, recorrer este array y ejecutar el método precioFinal() en cada
 * electrodoméstico. Se deberá también mostrar el precio de cada tipo de objeto,
 * es decir, el precio de todos los televisores y el de las lavadoras. Una vez hecho
 * eso, también deberemos mostrar, la suma del precio de todos los
 * Electrodomésticos. Por ejemplo, si tenemos una lavadora con un precio de 2000
 * y un televisor de 5000, el resultado final será de 7000 (2000+5000) para
 * electrodomésticos, 2000 para lavadora y 5000 para televisor
 */
package Logica;

import java.util.ArrayList;
import java.sql.*;//siempre importar la libreria de SQL
import java.util.Scanner;


public class Ejercicio2_Guia5 {

    public static void main(String[] args) throws SQLException {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Electrodomestico e1 = new Electrodomestico();
        Televisor t1;
        ArrayList<Electrodomestico> lista = new ArrayList();
        Lavadora l1;
        int opc;
        char s;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try { //las conexiones siempre deben estar encerradas en un bloque tray - catch
            Class.forName("org.mariadb.jdbc.Driver").newInstance();// paso 1 para establecer conexion con el conector de MariaDB
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electrodomesticos", "prueba", "123456");// paso 2 para buscar la base de datos y establecer la conexion
            System.out.println("Conexion exitosa!"); // cartel para mostrar si la conexion fue correcta
        do {
            
            System.out.println("******** MENU ********");
            System.out.println("");
            System.out.println("1 -> Para crear Lavadora");
            System.out.println("2 -> Para crear Televisor");
            System.out.println("3 -> Para crear un Electrodomestico");
            opc = leer.nextInt();
            t1 = new Televisor();
            l1 = new Lavadora();
            switch (opc) {
                case 1:
                    l1.crearLavadora();//se crea el objeto
                    lista.add(l1);//se agrega a un array (para este ejercicio puntual)
                    //el query es la consulta para hacerle al BD
                    // el insert to es para agregar datos desde netbeans porque es sintaxis embebida en java
                    // en formato string agregar el nombre de la tabla con sus columnas
                    // y para agregar los valores, se pueden setear a mano, o en este caso, atravez del objeto con getters
                    String query = "INSERT INTO lavadora (precio, color, consumo, peso, carga) VALUES ('" + l1.precioFinal() + "','" + l1.getColor() + "','" + l1.getConsumo() + "','" + l1.getPeso() + "','" + l1.getCarga() + "')";
                    
                    ps = conn.prepareStatement(query);
                    ps.executeUpdate(query);
                    ps = conn.prepareStatement("SELECT * FROM lavadora");
                    rs = ps.executeQuery();
                    break;
                case 2:
                    t1.crearTelevisor();
                    lista.add(t1);
                    String sql = "INSERT INTO televisor (precio, color, consumo, peso, resolucion ,sintonizador) VALUES ('" + t1.precioFinal() + "','" + t1.getColor() + "','" + t1.getConsumo() + "','" + t1.getPeso() + "','" + t1.getResolucion() + "','" + t1.getSintonizadorEntero() + "')";
                    ps = conn.prepareStatement(sql);
                    ps.executeUpdate(sql);
                    ps = conn.prepareStatement("SELECT * FROM televisor");
                    rs = ps.executeQuery();
                    break;
                default:
                    e1.crearElectrodomestico();
                    lista.add(e1);
            }
            System.out.println("Desea seguir agregando electrodomesticos a la lista?");
            System.out.println("Presione s / n");
            s = leer.next().charAt(0);

            } while (s != 'n');
//            if (!rs.next()) 
//                System.out.println("No hay registros");
//            else do {
//                   System.out.println("Lavadora -> "+rs.getDouble("Precio") + " " + rs.getDouble("carga") + " " + rs.getString("color"));
//                   System.out.println("Televisor -> "+rs.getDouble("Precio") + " " + rs.getDouble("resolucion") + " " + rs.getString("color"));
//                } while (rs.next());
        } catch (Exception e) {
            System.out.println("Error -> "+e);}
        finally{
            conn.close();
            System.out.println("Desconectando....");
        }
//        System.out.println("Lista de elcetrodomesticos cargados: ");
//        for (Electrodomestico aux : lista) {
//            System.out.println(aux);
//        }
//        //System.out.println("Lista de elcetrodomesticos cargados: ");
//        System.out.println("Precio final:");
//        double cont = 0;
//        for (Electrodomestico aux : lista) {
//            cont = cont + aux.precioFinal();
//        }
//        System.out.println("El precio final es: " + cont);

    }
}

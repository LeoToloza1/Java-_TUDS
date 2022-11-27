/*
 Se debe crear también una subclase llamada Televisor con los siguientes
atributos: resolución (en pulgadas) y sintonizador TDT (booleano), además de los
atributos heredados.
Los constructores que se implementarán serán:
• Un constructor vacío.
• Un constructor con la resolución, sintonizador TDT y el resto de atributos
heredados. Recuerda que debes llamar al constructor de la clase padre.
Los métodos que se implementara serán:
• Método get y set de los atributos resolución y sintonizador TDT.
• Método crearTelevisor(): este método llama a crearElectrodomestico() de la
clase padre, lo utilizamos para llenar los atributos heredados del padre y
después llenamos los atributos del televisor.
• Método precioFinal(): este método será heredado y se le sumará la siguiente
funcionalidad. Si el televisor tiene una resolución mayor de 40 pulgadas, se
incrementará el precio un 30% y si tiene un sintonizador TDT incorporado,
aumentará $500. Recuerda que las condiciones que hemos visto en la clase
Electrodomestico también deben afectar al precio.
 */
package Logica;


import java.util.Scanner;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Televisor extends Electrodomestico {
    @Id
    protected int id;
    @Basic
    private Integer resolucion;
    private boolean sintonizador = false;
    private int sintonizadorEntero;

    public Televisor() {
    }

    public Televisor(double precio, String color, char consumo, double peso, Integer resolucion, boolean sintonizador) {
        super(precio, color, consumo, peso);
        this.resolucion = resolucion;
        this.sintonizador = sintonizador;
        }

    public Integer getResolucion() {
        return resolucion;
    }

    public void setResolucion(Integer resolucion) {
        this.resolucion = resolucion;
    }

    public boolean isSintonizador() {
        return sintonizador;
    }

    public void setSintonizador(boolean sintonizador) {
        this.sintonizador = sintonizador;
    }

    public int getSintonizadorEntero() {
        sintonizadorEntero = sintonizador ? 1:0;
        return sintonizadorEntero;
    }

    public void setSintonizadorEntero(int sintonizadorEntero) {
        this.sintonizadorEntero = sintonizadorEntero;
    }
    
    public void crearTelevisor() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("********Televisor********");
        System.out.println("");
        crearElectrodomestico();
        System.out.println("Ingrese la resolucion: ");
        resolucion = leer.nextInt();
        System.out.println("Tiene sintonizador?: \n(si // no)");
        String confirm = leer.next();
        if (confirm.equalsIgnoreCase("si")) {
            sintonizador = true;
        }
        comprobarColor();
        comprobarConsumo();
        getSintonizadorEntero();
      
    }

    @Override
    public double precioFinal() {
       super.precioFinal();
        if (resolucion >= 40) {
         precio = (precio * 1.30);
        }
         if (sintonizador == true) {
            precio += 500;
        }
        
        return precio;
    }

    @Override
    public String toString() {
        return "\n************Televisor************" + "\nresolucion -> " + resolucion + "\nsintonizador -> " + sintonizador 
                + "\ncolor -> " + color +"\nPrecio -> " + precioFinal() +"\nConsumo -> " 
                + consumo + "\nPeso -> " + peso;
    }


    
}

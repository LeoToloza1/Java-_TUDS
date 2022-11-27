/*A continuación se debe crear una subclase llamada Lavadora, con el atributo
carga, además de los atributos heredados.
Los constructores que se implementarán serán:
• Un constructor vacío.
• Un constructor con la carga y el resto de atributos heredados. Recuerda que
debes llamar al constructor de la clase padre.
Los métodos que se implementara serán:
• Método get y set del atributo carga.
• Método crearLavadora (): este método llama a crearElectrodomestico() de la
clase padre, lo utilizamos para llenar los atributos heredados del padre y
después llenamos el atributo propio de la lavadora.
• Método precioFinal(): este método será heredado y se le sumará la siguiente
funcionalidad. Si tiene una carga mayor de 30 kg, aumentará el precio en $500,
si la carga es menor o igual, no se incrementará el precio. Este método debe
llamar al método padre y añadir el código necesario. Recuerda que las
condiciones que hemos visto en la clase Electrodoméstico también deben
afectar al precio.*/

package Logica;

import java.util.Scanner;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity

public class Lavadora extends Electrodomestico {
    @Id
    protected int id;
    @Basic
    private double carga = 0d;

    public Lavadora() {//constructor vacio
    }

    public Lavadora(double precio, String color, char consumo, double peso, double carga) {
        super(precio, color, consumo, peso);
        this.carga = carga;
        //constructor lleno con herencia de la superclase **Electrodomestico**
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }

    public void crearLavadora() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("********Lavadora********");
        System.out.println("");
        crearElectrodomestico();
        System.out.println("Cuanto es la carga del lavarropas?");
        carga = leer.nextDouble();
        comprobarColor();
        comprobarConsumo();
    }

    @Override
    public double precioFinal() {
          super.precioFinal();
        if (carga >= 30) {
            precio += 500;
        }
        
        return precio;
    }

    @Override
    public String toString() {
        return "\nlavadora" + "\ncarga-> " + carga + "\ncolor -> " + color + "\nPrecio -> "
                + precioFinal() + "\nConsumo -> " + consumo + "\nPeso -> " + peso;
    }

}

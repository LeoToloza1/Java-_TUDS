/*Crear una superclase llamada Electrodoméstico con los siguientes atributos:
precio, color, consumo energético (letras entre A y F) y peso.
Los constructores que se deben implementar son los siguientes:
 */
package Logica;

import java.util.Scanner;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Electrodomestico {
    @Id
    protected int id;
    @Basic
    protected double precio = 1000d;
    protected String color;
    protected char consumo;
    protected double peso;
//• Un constructor vacío

    public Electrodomestico() {
    }
//• Un constructor con todos los atributos pasados por parámetro.

    public Electrodomestico(double precio, String color, char consumo, double peso) {
        this.precio = precio;
        this.color = color;
        this.consumo = consumo;
        this.peso = peso;
    }
    // Métodos getters y setters de todos los atributos.

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getConsumo() {
        return consumo;
    }

    public void setConsumo(char consumo) {
        this.consumo = consumo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    //Método comprobarConsumoEnergetico(char letra): comprueba que la letra
//es correcta, sino es correcta usara la letra F por defecto. Este método se debe
//invocar al crear el objeto y no será visible.

    public char comprobarConsumo() {
        if (!(consumo != 'a' || consumo != 'b' || consumo != 'c' || consumo != 'd' || consumo != 'e' || consumo != 'f')) {
            consumo = 'f';
        }

        return consumo;
    }

    /**
     * Método comprobarColor(String color): comprueba que el color es correcto,
     * y si no lo es, usa el color blanco por defecto. Los colores disponibles
     * para los electrodomésticos son blanco, negro, rojo, azul y gris. No
     * importa si el nombre está en mayúsculas o en minúsculas. Este método se
     * invocará al crear el objeto y no será visible
     *
     * @return
     */
    public String comprobarColor() {
        if (!("blanco".equalsIgnoreCase(color)|| "negro".equalsIgnoreCase(color)|| "rojo".equalsIgnoreCase(color)|| "azul".equalsIgnoreCase(color)|| "gris".equalsIgnoreCase(color))) {
            color = "Blanco";
        }
        return color;
    }

    /*• Metodo crearElectrodomestico(): le pide la información al usuario y llena el
  electrodoméstico, también llama los métodos para comprobar el color y el
  consumo. Al precio se le da un valor base de $1000. */
    public void crearElectrodomestico() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese los datos del electrodomestico");
        System.out.println("Ingrese el color: ");
        color = leer.next();
        System.out.println("Ingrese la letra correspondiente al consumo: ");
        consumo = (leer.next().charAt(0));
        System.out.println("Ingrese el peso: ");
        peso = leer.nextDouble();

    }

    /*Método precioFinal(): según el consumo energético y su tamaño, aumentará
el valor del precio.*/
    public double precioFinal() {
        switch (consumo) {
            case 'a':
                precio += 1000d;
                break;
            case 'b':
                precio += 800d;
                break;
            case 'c':
                precio += 600d;
                break;
            case 'd':
                precio += 500d;
                break;
            case 'e':
                precio += 300d;
                break;
            case 'f':
                precio += 100d;
        }

        if (peso >= 1 && peso <= 19) {
            precio += 100d;
        } else if (peso >= 20 && peso <= 49) {
            precio += 500d;
        } else if (peso >= 50 && peso <= 79) {
            precio += 800d;
        } else if (peso >= 80) {
            precio += 1000d;

        }
        // precio += cont;
        // System.out.println("El precio final del producto es: " + precio);
        return precio;

    }

    @Override
    public String toString() {
        return "**********Electrodomestico**********\n" + "precio: " + precioFinal() + "\n color: " + color + "\n consumo: " + consumo + "\n peso: " + peso;
    }
}

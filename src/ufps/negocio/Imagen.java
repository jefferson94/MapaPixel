/*
 Clase Imagen
 */
package ufps.negocio;

import java.awt.Color;
import ufps.util.Secuencia;
import ufps.util.ExceptionUFPS;

/**
 *
 * @author FERNEY JARAMILLO VEGA-1150671
 * @author VALERIA GABRIELA SALAZAR-1150674
 */
/**
 * La clase Imagen tiene un atributo Secuencia de tipo FilaColor
 */
public class Imagen {

    Secuencia<FilaColor> filaColores;

    /**
     * Constructor vacío de la clase Imagen
     *
     */
    public Imagen() {
    }

    /**
     * Constructor de la clase Imagen con parámetros
     *
     * @param n : Número de filas que tendrá la secuencia.
     * @param m: Número de Columnas utilizada para crear una secuencia de
     * Filacolor.
     */
    public Imagen(int n, int m) throws ExceptionUFPS {


        if (n < 3 || n > 50 || m > 50 || m < 3 || n == 0 || m == 0 || m < 3) {

            throw new ExceptionUFPS("error no se puede crear , digite numeros validos  entre 3 y 50");

        }

        filaColores = new Secuencia<FilaColor>(n);

        for (int i = 0; i < filaColores.length(); i++) {

            filaColores.set(i, new FilaColor(m));

        }

    }

    /**
     * Método que permite crear el marco a la Imagen Volviendo todos los píxeles
     * de la filas y columnas de los extremos en negro
     *
     */
    public void crearMarco() {

        int ultimo = filaColores.get(0).getPixeles().length() - 1;


        for (int i = 0; i < filaColores.length(); i++) {



            if (i == 0 || i == filaColores.length() - 1) {

                for (int j = 0; j < filaColores.get(i).getPixeles().length(); j++) {

                    this.filaColores.get(i).getPixeles().get(j).cambiarANegro();

                }
            } else {

                this.filaColores.get(i).getPixeles().get(0).cambiarANegro();

                this.filaColores.get(i).getPixeles().get(ultimo).cambiarANegro();


            }

        }


    }

    /**
     * Método que permite realizar cambio de filas (la primera con la última, la
     * siguiente con la penúltima y asi sucesivamente)
     */
    public void flipHorizontal() {

        int i = 0;

        int j = filaColores.length() - 1;

        for (; i < filaColores.length() / 2; i++, j--) {

            FilaColor aux = filaColores.get(i);
            filaColores.set(i, filaColores.get(j));
            filaColores.set(j, aux);

        }
    }

    /**
     * Método que permite cambiar a su gamma de grises un color.
     *
     * @param tipoColorRGB: color al cual deseamos convertir a su escala de
     * grises.
     * @throws ExceptionUFPS Excepción que captura el error si el color recibido
     * por parametro es diferente al"Rojo,Verde,Azul"
     */
    public void invertirGama(String tipoColorRGB) throws ExceptionUFPS {
        if (!(tipoColorRGB.equalsIgnoreCase("rojo") || !(tipoColorRGB.equalsIgnoreCase("azul")) || !(tipoColorRGB.equalsIgnoreCase("verde")))) {

            throw new ExceptionUFPS("El color debe ser ROJO,VERDE o AZUL");
        }


        for (int i = 0; i < filaColores.length(); i++) {
            this.filaColores.get(i).invertirGamma(tipoColorRGB);

        }
    }

    /**
     * Método que permite detectar si un color es de una gamma específica
     * (Roja,Verde,Azul) y si hay mas de dos colores de la misma gamma seguidos
     * en la secuencia se cambian a blanco.
     *
     * @param tipoColorRGB color al que deseamos buscarle un patron.
     */
    public void detectarPatron(String tipoColorRGB) {

//         if (!(tipoColorRGB.equalsIgnoreCase("rojo"))||!(tipoColorRGB.equalsIgnoreCase("Azul"))||!(tipoColorRGB.equalsIgnoreCase("verde"))){
//         throw new ExceptionUFPS("Solo se puede detectar los colores Azul , verde , rojo");
//         }

        for (int i = 0; i < this.filaColores.length(); i++) {
            this.filaColores.get(i).detectarPatron(tipoColorRGB);


        }
    }

    /**
     * Método que permite cortar una sección de la Imagen
     *
     * @param fila: posición de la que se desea comenzar a cortar.
     * @param columna: Columna de la que se desa comenzar a cortar.
     * @param ancho: ancho que se desa recortar.
     * @param alto :número de píxeles que se desean cortar
     *
     */
    public void cortar(int fila, int columna, int ancho, int alto) throws ExceptionUFPS {

        if (fila < 0 || fila > this.filaColores.length() || fila + alto >= this.filaColores.length() || columna < 0 || columna > this.filaColores.get(0).getPixeles().length() || columna + ancho >= this.filaColores.get(0).getPixeles().length()) {

            throw new ExceptionUFPS("Valor fuera de Rango");
        }


        for (int i = fila; i < ancho + columna; i++) {

            for (int j = fila; j < fila + alto; j++) {

                this.filaColores.get(i).getPixeles().get(j).cambiarABlanco();

            }


        }
    }
}
    
    
   /**
    * Fin de la clase Imagen
    */
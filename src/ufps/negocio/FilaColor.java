/*
 * Clase Filacolor que representa una Secuencia de Píxeles.
 */
package ufps.negocio;

import ufps.util.Secuencia;
import ufps.negocio.Pixel;

/**
 *
 * @author FERNEY JARAMILLO VEGA-1150671
 * @author VALERIA GABRIELA SALAZAR-1150674
 */
public class FilaColor {

    Secuencia<Pixel> pixeles;

    /**
     * Constructor vacío de la clase FilaColor.
     */
    public FilaColor() {
    }

    /**
     * Contructor con parámetros de la Clase FilaColor
     *
     * @param filas recibe un entero para crear una nueva Secuencia de píxeles.
     */
    public FilaColor(int filas) {

        this.pixeles = new Secuencia<Pixel>(filas);

        for (int i = 0; i < pixeles.length(); i++) {
            int dato = (int) (Math.random() * 200);
            int dato2 = (int) (Math.random() * 200);
            int dato3 = (int) (Math.random() * 200);
            pixeles.set(i, new Pixel(dato, dato2, dato3));

        }

    }

    /**
     * Método get de la Clase Secuencia<pixel> que retorna la secuencia de
     * píxeles actual.
     *
     * @return Secuencia
     */
    public Secuencia<Pixel> getPixeles() {
        return this.pixeles;

    }

    /**
     * Método set de la clase Secuencia<pixel> que permite modificar la
     * secuencia actual por una nueva.
     *
     * @param val variable para realizar su respectivo cambio
     */
    public void setPixeles(Secuencia<Pixel> val) {
        this.pixeles = val;

    }

    /**
     * Método que consiste en colocar en blanco los píxeles que se encuentren
     * bajo un patrón de una gama determinada.
     *
     * @param tipoColorRGB color que llega para realizar la búsqueda de patrones
     * de manera contigua en una fila
     */
    public void detectarPatron(String tipoColorRGB) {


        int cont = 0;

        for (int i = 0; i < this.getPixeles().length(); i++) {

            if (this.getPixeles().get(i).isGamma(tipoColorRGB)) {

                if (cont == 1) {

                    this.getPixeles().get(i - 1).cambiarABlanco();
                    this.getPixeles().get(i).cambiarABlanco();

                }
                if (cont > 1) {
                    this.getPixeles().get(i).cambiarABlanco();
                }
                cont++;
            } else {

                cont = 0;
            }
        }
    }

    /**
     * Operación que permite invertir los píxeles de la imagen (volverlos a tono
     * de grises) que pertenezcan a una gama determinada.
     *
     * @param tipoColorRGB gama elegida por el usuario para ser invertida.
     */
    public void invertirGamma(String tipoColorRGB) {

        for (int j = 0; j < this.getPixeles().length(); j++) {

            boolean c = this.getPixeles().get(j).isGamma(tipoColorRGB);
            if (c) {
                this.getPixeles().get(j).pintarEnGris();
            }

        }

    }
}
    /**
     * Fin De la Clase FilaColor
     */
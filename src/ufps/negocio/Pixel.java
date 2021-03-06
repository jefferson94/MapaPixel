/**
 * Clase que representa un Píxel.
 */
package ufps.negocio;

import java.awt.Color;

/**
 * @author FERNEY JARAMILLO-1150671
 * @author VALERIA GABRIELA SALAZAR-1150674
 */
public class Pixel {

    private Color rgb;

    /**
     * Constructor Vacío de la clase Píxel.
     */
    public Pixel() {
    }

    /**
     * Constructor con parámetro de la clase Píxel
     *
     * @param red:cantidad de rojo en un píxel.
     * @param green:cantidad de verde en un píxel.
     * @param blue:cantidad de azul en un píxel.
     */
    public Pixel(int red, int green, int blue) {

        this.rgb = new Color(red, green, blue);

    }

    /**
     * Método get de la clase Píxel, retorna el contenido RGB de el pixel.
     *
     * @return  el contenido RGB del píxel.
     */
    public Color getRgb() {

        return this.rgb;

    }

    /**
     * Método set de la clase Píxel , permite cambiar el color actual del píxel
     * por uno nuevo.
     *
     * @param valor:Nuevo color al que se desea cambiar.
     */
    public void setRgb(Color valor) {

        this.rgb = valor;

    }

    /**
     * Método que permite cambiar el color de un píxel a Negro.
     */
    public void cambiarANegro() {
        this.setRgb(new Color(0, 0, 0));

    }

    /**
     * Método que permite cambiar el color de un Píxel a Blanco.
     */
    public void cambiarABlanco() {
        this.setRgb(new Color(255, 255, 255));

    }

    /**
     * Método que permite cambiar el color de un Píxel a su gamma en Gris.
     */
    public void pintarEnGris() {
        int color = (this.rgb.getRed() + rgb.getBlue() + rgb.getBlue()) / 3;
        Color x = new Color(color, color, color);
        this.setRgb(x);

    }

    /**
     * Método booleano que permite saber si un color es gamma de otro color.
     *
     * @param val: String al cual deseamos preguntar su gamma.
     * @return true: si el String pertenece a una gamma indicada.
     * @return False: si el String no pertenece a ninguna gamma.
     */
    public boolean isGamma(String val) {

        if (val.equalsIgnoreCase("rojo")) {

            if (rgb.getRed() >= rgb.getGreen() && rgb.getRed() >= rgb.getBlue()) {

                return true;

            }

        }

        if (val.equalsIgnoreCase("Azul")) {

            if (rgb.getBlue() > rgb.getGreen() && rgb.getBlue() > rgb.getRed()) {


                return true;

            }

        }

        if (val.equalsIgnoreCase("verde")) {

            if (rgb.getGreen() > rgb.getRed() && rgb.getGreen() >= rgb.getBlue()) {

                return true;

            }

        }
        return false;

    }
}
/**
 * Fin de la Clase Pixel
 */
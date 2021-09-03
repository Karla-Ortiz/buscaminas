/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corp.karby.buscaminas.images;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Gabriela}
 */
public class rutaImagenes {

    private static final String bandera = "src/corp/karby/buscaminas/images/banderaRoja.png";
    private static final String mina = "src/corp/karby/buscaminas/images/mina.png";
    private static final String explosion = "src/corp/karby/buscaminas/images/explosion.png";
    private static final String uno = "src/corp/karby/buscaminas/images/uno.png";
    private static final String dos = "src/corp/karby/buscaminas/images/dos.png";
    private static final String tres = "src/corp/karby/buscaminas/images/tres.png";
    private static final String cuatro = "src/corp/karby/buscaminas/images/cuatro.png";
    private static final String cinco = "src/corp/karby/buscaminas/images/cinco.png";
    private static final String seis = "src/corp/karby/buscaminas/images/seis.png";
    private static final String siete = "src/corp/karby/buscaminas/images/siete.png";
    private static final String ocho = "src/corp/karby/buscaminas/images/ocho.png";
    private static final String logo = "src/corp/karby/buscaminas/images/logo.png";
    private static final String flor = "src/corp/karby/buscaminas/images/flor.png";

    private static ImageIcon resizable(String imagen, int v) {
        BufferedImage icono = null;
        try {
            BufferedImage image = ImageIO.read(new File(imagen));
            icono = new BufferedImage(v, v, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = icono.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(image, 0, 0, v, v, null);
            g2.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ImageIcon(icono);
    }

    public static ImageIcon getBandera() {
        return resizable(bandera, 35);
    }

    public static ImageIcon getMina() {
        return resizable(mina, 35);
    }

    public static ImageIcon getExplosion() {
        return resizable(explosion, 35);
    }

    public static ImageIcon getUno() {
        return resizable(uno, 35);
    }

    public static ImageIcon getDos() {
        return resizable(dos, 35);
    }

    public static ImageIcon getTres() {
        return resizable(tres, 35);
    }

    public static ImageIcon getCuatro() {
        return resizable(cuatro, 35);
    }

    public static ImageIcon getCinco() {
        return resizable(cinco, 35);
    }

    public static ImageIcon getSeis() {
        return resizable(seis, 35);
    }

    public static ImageIcon getSiete() {
        return resizable(siete, 35);
    }

    public static ImageIcon getOcho() {
        return resizable(ocho, 35);
    }

    public static ImageIcon getLogo() {
        return resizable(logo, 75);
    }
    
    public static ImageIcon getFlor(){
        return resizable(flor, 35);
    }
}

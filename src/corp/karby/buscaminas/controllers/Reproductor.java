/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corp.karby.buscaminas.controllers;

import java.io.File;
import javazoom.jlgui.basicplayer.BasicPlayer;

/**
 *
 * @author Gabriela}
 */
public class Reproductor {

    private BasicPlayer player;

    public Reproductor() {
        player = new BasicPlayer();
    }

    public void Play() throws Exception {
        player.play();
    }

    public void AbrirFichero(String ruta) throws Exception {
        player.open(new File(ruta));
    }

}

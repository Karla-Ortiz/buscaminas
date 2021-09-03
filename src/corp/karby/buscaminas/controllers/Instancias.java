/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corp.karby.buscaminas.controllers;

import corp.karby.buscaminas.gui.Inicio;
import corp.karby.buscaminas.gui.JuegoExperto;
import corp.karby.buscaminas.gui.JuegoFacil;

/**
 *
 * @author Gabriela}
 */
public class Instancias {
    private static final JuegoExperto experto = new JuegoExperto();
    private static final JuegoFacil facil = new JuegoFacil();
    private static final Inicio inicio = new Inicio();

    public static JuegoExperto getExperto() {
        return experto;
    }

    public static JuegoFacil getFacil() {
        return facil;
    }

    public static Inicio getInicio() {
        return inicio;
    }
    
}

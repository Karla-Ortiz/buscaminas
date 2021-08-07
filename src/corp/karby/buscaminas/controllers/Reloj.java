/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corp.karby.buscaminas.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;

/**
 *
 * @author Gabriela}
 */
public class Reloj {
    public Reloj(JLabel etiqueta){
        DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaActual = f.format(LocalDateTime.now());
    }
}

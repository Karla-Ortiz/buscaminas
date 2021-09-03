/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corp.karby.buscaminas.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Gabriela}
 */
public class Reloj {

    public static String hora() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm:ss");
        return f.format(LocalDateTime.now());
    }
}

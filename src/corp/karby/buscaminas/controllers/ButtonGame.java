/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corp.karby.buscaminas.controllers;

import corp.karby.buscaminas.images.rutaImagenes;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javafx.scene.paint.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author KORTIZ
 */
public class ButtonGame extends JButton {

    private int cox = 0, coy = 0;
    private boolean selec = false;
    private boolean descubierto = false;
    private boolean dificil = false, gameOver = false, win = false;
    private JButton boton;
    private JButton explotado;
    public int valor;

    public ButtonGame() {
    }

    public ButtonGame(int x, int y, boolean dif, logicaJuego logic, JButton b) {
        this.dificil = dif;
        this.boton = b;
        this.cox = x;
        this.coy = y;
        this.boton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                valor = logic.buscarMina(cox, coy, dificil);
                if (e.getButton() == MouseEvent.BUTTON3) {
                    if (!descubierto) {
                        if (selec) {
                            if (valor == 9) {
                                if (dificil) {
                                    logic.setTotalDificil(logic.getTotalDificil() + 1);
                                } else {
                                    logic.setTotalFacil(logic.getTotalFacil() + 1);
                                }
                            }
                            selec = false;
                            boton.setIcon(null);
                        } else {
                            if (valor == 9) {
                                if (dificil) {
                                    if (logic.getTotalDificil() == 1) {
                                        win(boton);
                                    } else {
                                        logic.setTotalDificil(logic.getTotalDificil() - 1);
                                        System.out.println(logic.getTotalDificil());
                                    }
                                } else {
                                    if (logic.getTotalFacil() == 1) {
                                        win(boton);
                                    } else {
                                        logic.setTotalFacil(logic.getTotalFacil() - 1);
                                        System.out.println(logic.getTotalFacil());
                                    }
                                }
                            }
                            selec = true;
                            boton.setIcon(rutaImagenes.getBandera());
                        }
                    }
                } else if (e.getButton() == MouseEvent.BUTTON1) {
                    if (!selec && !descubierto) {
                        descrubir(boton);
                    }
                }
            }

            private void gameOver(JButton b) {
                explotado = b;
                gameOver = true;
                int tamanio = dificil ? 10 : 5;
                Component botones[] = b.getParent().getComponents();
                for (int i = 0; i < botones.length; i++) {
                    for (int x = 0; x < tamanio; x++) {
                        for (int y = 0; y < tamanio; y++) {
                            descrubir((JButton) botones[i]);
                            i++;
                        }
                    }
                }
                explotado.setIcon(rutaImagenes.getExplosion());
                JOptionPane.showMessageDialog(null, "¡Has perdido! ¡suerte a la proxima! :P");
            }

            private void win(JButton b) {
                win = true;
                int tamanio = dificil ? 10 : 5;
                Component botones[] = b.getParent().getComponents();
                for (int i = 0; i < botones.length; i++) {
                    for (int x = 0; x < tamanio; x++) {
                        for (int y = 0; y < tamanio; y++) {
                            descrubir((JButton) botones[i]);
                            i++;
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "¡Has ganado! ¡FELICIDADES! :D");
            }

            private void descrubir(JButton boton) {
                if (valor != 9) {
                    switch (valor) {
                        case 1:
                            boton.setIcon(rutaImagenes.getUno());
                            descubierto = true;
                            break;
                        case 2:
                            boton.setIcon(rutaImagenes.getDos());
                            descubierto = true;
                            break;
                        case 3:
                            boton.setIcon(rutaImagenes.getTres());
                            descubierto = true;
                            break;
                        case 4:
                            boton.setIcon(rutaImagenes.getCuatro());
                            descubierto = true;
                            break;
                        case 5:
                            boton.setIcon(rutaImagenes.getCinco());
                            descubierto = true;
                            break;
                        case 6:
                            boton.setIcon(rutaImagenes.getSeis());
                            descubierto = true;
                            break;
                        case 7:
                            boton.setIcon(rutaImagenes.getSiete());
                            descubierto = true;
                            break;
                        case 8:
                            boton.setIcon(rutaImagenes.getOcho());
                            descubierto = true;
                            break;
                        default:
                            boton.setBackground(java.awt.Color.DARK_GRAY);
                            boton.setEnabled(false);
                            descubierto = true;
                            break;
                    }
                } else {
                    if (!gameOver && !win) {
                        boton.setIcon(rutaImagenes.getExplosion());
                        gameOver(boton);
                    } else if (win){
                        boton.setIcon(rutaImagenes.getFlor());
                    }else {
                        boton.setIcon(rutaImagenes.getMina());
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corp.karby.buscaminas.controllers;

import java.util.Random;

/**
 * @author KORTIZ
 */
public class logicaJuego {

    private static int[][] Dificil = new int[10][10];
    private static int[][] facil = new int[5][5];
    private int totalFacil;
    private int totalDificil;

    /**
     * Se crean las matrices
     */
    public logicaJuego() {
        colocarMinas();
        llenarMatriz();
        ImprimirMatriz();
    }

    /**
     *
     * @param x coordenada x en la matriz
     * @param y coordenada y en la matriz
     * @param dificil boolean indicando la dificultad
     * @return 9 si es mina
     */
    public int buscarMina(int x, int y, boolean dificil) {
        return dificil ? Dificil[x][y] : facil[x][y];
    }

    /**
     * Coloca las minas ambas matrices
     */
    private void colocarMinas() {
        int cantidad_de_minasFac = 5 + generateIntRandom(5);
        int cantidad_de_minasDif = 10 + generateIntRandom(5);
        totalFacil = cantidad_de_minasFac;
        totalDificil = cantidad_de_minasDif;
        System.out.println("Minas colocadas en facil:" + cantidad_de_minasFac);
        System.out.println("Minas colocadas en dificil:" + cantidad_de_minasDif);
        int x, y;
        for (int i = 0; i < cantidad_de_minasFac; i++) {
            x = generateIntRandom(5);
            y = generateIntRandom(5);
            if (facil[x][y] == 9) {
                do {
                    x = generateIntRandom(5);
                    y = generateIntRandom(5);
                } while (facil[x][y] == 9);
            }
            facil[x][y] = 9;
        }

        for (int i = 0; i < cantidad_de_minasDif; i++) {
            x = generateIntRandom(10);
            y = generateIntRandom(10);
            if (Dificil[x][y] == 9) {
                do {
                    x = generateIntRandom(10);
                    y = generateIntRandom(10);
                } while (Dificil[x][y] == 9);
            }
            Dificil[x][y] = 9;
        }

    }

    /**
     * llena los numeros restantes en base a su cercania con una mina
     */
    private void llenarMatriz() {
        //DIFICIL
        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                if (Dificil[i][j] == 9) {
                    sumarIdentificador(i - 1, j, true);
                    sumarIdentificador(i + 1, j, true);
                    sumarIdentificador(i - 1, j - 1, true);
                    sumarIdentificador(i, j - 1, true);
                    sumarIdentificador(i + 1, j - 1, true);
                    sumarIdentificador(i - 1, j + 1, true);
                    sumarIdentificador(i, j + 1, true);
                    sumarIdentificador(i + 1, j + 1, true);
                }
            }
        }
        //FACIL
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (facil[i][j] == 9) {
                    sumarIdentificador(i - 1, j, false);
                    sumarIdentificador(i + 1, j, false);
                    sumarIdentificador(i - 1, j - 1, false);
                    sumarIdentificador(i, j - 1, false);
                    sumarIdentificador(i + 1, j - 1, false);
                    sumarIdentificador(i - 1, j + 1, false);
                    sumarIdentificador(i, j + 1, false);
                    sumarIdentificador(i + 1, j + 1, false);
                }
            }
        }

    }

    /**
     * Suma los digitos
     *
     * @param i coordenada i
     * @param j coordenada j
     * @param dificil tipo de matriz
     */
    private void sumarIdentificador(int i, int j, boolean dificil) {
        int limite = dificil ? 10 : 5;
        if (i >= 0 && j >= 0 && i < limite && j < limite) {
            int actual = dificil ? Dificil[i][j] : facil[i][j];
            if (!dificil) {
                if (actual != 9) {
                    facil[i][j] = actual + 1;
                }
            } else {
                if (actual != 9) {
                    Dificil[i][j] = actual + 1;
                }
            }
        }
    }

    /**
     * genera un numero random
     *
     * @param max limite superior
     * @return int random
     *
     */
    private int generateIntRandom(int max) {
        Random r = new Random();
        return r.nextInt(max);
    }

    /**
     * Imprime xd
     */
    private void ImprimirMatriz() {
        System.out.println(" ");
        System.out.println(" ----------DIFICIL---------");
        System.out.println(" ");
        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {
                System.out.print(Dificil[i][j] + " ");
            }
            System.out.println(" ");
        }
        //FACIL
        System.out.println(" ");
        System.out.println(" ----------FACIL---------");
        System.out.println(" ");
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {
                System.out.print(facil[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public int getTotalFacil() {
        return totalFacil;
    }

    public void setTotalFacil(int totalFacil) {
        this.totalFacil = totalFacil;
    }

    public int getTotalDificil() {
        return totalDificil;
    }

    public void setTotalDificil(int totalDificil) {
        this.totalDificil = totalDificil;
    }
}

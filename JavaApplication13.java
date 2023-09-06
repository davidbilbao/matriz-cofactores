/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

import java.util.Scanner;
public class JavaApplication13 {
    public static final int MAX = 10;
    public static final Scanner entrada = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int matriz[][];
        int orden;
        System.out.print("Ingresa el orden de la matriz (máximo " + MAX + "): ");
        orden = entrada.nextInt();
        while (orden < 0 || orden > MAX) {
            System.out.printf("\nEl orden de la matriz no puede ser mayor que %d\n", MAX);
            System.out.printf("Ingrese nuevamente el orden de la matriz: ");
            orden = entrada.nextInt();
        }
        // Se instancia la matriz
        matriz = new int[orden][orden];
        // Lectura de elementos de la matriz
        System.out.printf("\nIngrese los elementos de la matriz:\n\n");
        leerMatriz(matriz);
        // Escritura de elementos de la matriz
        System.out.printf("\nMostrando la matriz ingresada:\n");
        mostrarMatriz(matriz);
        // Cálculo del determinante de la matriz
        System.out.printf("\nEl determinante es: %d\n", determinante(matriz));
    }

    public static void leerMatriz(int matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = entrada.nextInt();
            }
        }

    }

    public static void mostrarMatriz(int matriz[][]) {
        System.out.printf("\nOrden: %d\n", matriz.length);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.printf("\t%d", matriz[i][j]);
            }
            System.out.println();
        }
    }

    public static int determinante(int matriz[][]) {
        int det = 0;
        if (matriz.length == 1) {
            return matriz[0][0];
        } else {
            for (int j = 0; j < matriz.length; j++) {
                det = det + matriz[0][j] * cofactor(matriz, 0, j);
            }
        }
        return det;
    }

    public static int cofactor(int matriz[][], int fila, int columna) {
        int submatriz[][];
        int n = matriz.length - 1;
        submatriz = new int[n][n];
        int x = 0;
        int y = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i != fila && j != columna) {
                    submatriz[x][y] = matriz[i][j];
                    y++;
                    if (y >= n) {
                        x++;
                        y = 0;
                    }
                }
            }
        }
        return (int) Math.pow(-1.0, fila + columna) * determinante(submatriz);
    }
    
}

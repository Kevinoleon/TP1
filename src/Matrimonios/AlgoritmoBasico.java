/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimonios;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author kevin_000
 */
public class AlgoritmoBasico {
    public static int[] emparejar(int[][] MM, int[][] MH) {
        int M;
        int h;
        int[] VM = new int[MM.length];
//Emparejamos a todas las mujeres con su primera opcion.
        for (int i = 0; i < MM.length; i++) {
            VM[i] = 0;
        }
//Emparejamos a todos los hombres con la mujer imaginaria
        int[] VH = new int[MH.length];
        for (int i = 0; i < MH.length; i++) {
            VH[i] = -1;
        }
        int[][] P = GetPreferencias(MH);
        int k = 0;
        while (k < MM.length) {
            M = k;  
            while (M != -1) {
                h = MM[M][VM[M]];
                if ((P[h][M + 1] > P[h][VH[h] + 1])) {
                    int t = VH[h];
                    VH[h] = M;
                    M = t;
                }
                if (M != -1) {
                    VM[M] = VM[M] + 1;
                }
            }
            k++;
        }
        return VM;
    }    
    public static int[][] GetPreferencias(int[][] MH) {
        int[][] P = new int[MH.length][MH[0].length + 1];
        for (int i = 0; i < P.length; i++) {
            P[i][0] = 0;
            for (int j = 1; j < P[0].length; j++) {
                P[i][j] = MH[0].length - BuscarPos(MH, i, j - 1);
            }
        }
        return P;
    }

    private static int BuscarPos(int[][] MH, int fila, int j) {
        int l = 0;
        for (int i = 0; i < MH[0].length; i++) {
            if (MH[fila][i] == j) {
                l = i;
            }
        }
        return l;
    }

    public static void mostrarEmparejamiento(int[][] MM, int[] VM) {
        for (int i = 0; i < VM.length; i++) {
            System.out.println("(" + i + "," + MM[i][VM[i]] + ")");
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimonios;

/**
 *
 * @author kevin_000
 */
public class AlgoritmoComp {

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
        int[][] P = Algoritmo.GetPreferencias(MH);
        int k = 0;
        while (k < MM.length) {
            M = k;
            while (M != -1) {
                if (VM[M] < MM[0].length) {
                    h = MM[M][VM[M]];
                    if (AlgoritmoComp.amorMutuo(MH, M, h)) {
                        if ((P[h][M + 1] > P[h][VH[h] + 1])) {
                            int t = VH[h];
                            VH[h] = M;
                            M = t;
                        }
                        if (M != -1) {
                            VM[M] = VM[M] + 1;
                        }
                    } else {
                        VM[M] = VM[M] + 1;
                    }
                } else {
                    VM[M] = -1;
                    M = -1;
                }
            }
            k++;
        }
        return VM;
    }

    private static boolean amorMutuo(int[][] MH, int M, int h) {
        boolean b = false;
        int i = 0;
        while (!b) {
            if (MH[h][i] == M) {
                b = true;
            }
            i++;
        }
        return b;
    }
    public static void mostrarEmparejamiento(int[][] MM, int[] VM) {
        for (int i = 0; i < VM.length; i++) {
            if (VM[i] != -1) {
                System.out.println("(" + i + "," + MM[i][VM[i]] + ")");
            } else {
                System.out.println("(" + i + ",-1)");
            }
        }
    }
}

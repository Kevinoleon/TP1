/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospitales;
import Matrimonios.*;

/**
 *
 * @author kevin_000
 */
public class AlgoReducido {
    
    public int[] Q;
    public int[][]H;
    public int[][] E;
    
    public static int[][] hosp_Homb(int[][] M, int[] Q){
        //se busca contar la cantidad de filas que tendrá la nueva matriz,
        //es decir, se suma la cant de vacantes de cada hosp
        
        int f=0;
        for (int i = 0; i<Q.length; i++) {
            f+=Q[i];
        }
        //se genera la matriz que tendrá los hosp repetidos (filas )
        //y el ranking de estudiantes (columnas)
        int[][] MatHosp= new int[f][M[0].length];
        int FMatHosp=0; // la fila de MatHosp a la que se copia para cda Hosp
        for (int i = 0; i < M.length; i++) {
            //se copia su lista de preferencias de a cuerdo a sus vacantes
            for (int j = 0; j < Q[i]; j++) {
                System.arraycopy(M[i], 0, MatHosp[FMatHosp], 0, M[i].length);
                FMatHosp++;
            }            
        }
        return MatHosp;
    }
    
    //para crear la Nueva matriz de residentes será necesario cambiar
    //cada hosp por sus hospitales correspondientes en la nueva Mat_hosp
    
    //para esto, se utilizará un vector auxiliar
    private static int[] vecAux(int[] Q){
        int[] aux= new int[Q.length];
        aux[0]=0;
        for (int i = 1; i < aux.length; i++) {
            aux[i]=aux[i-1]+Q[i-1];
        }
        return aux;
    }
    
    
    //se convierte la matriz de mujeres en la de residentes
    
    public static int[][] Res_Muj(int[][] E, int[] Q){
        int[] vaux=vecAux(Q);
        //se cuenta el numero de nuevos hospitales
        int n=0;
        for (int i = 0; i < Q.length; i++) {
            n=n+Q[i];
        }
        //ahora se crea la matriz Res_Muj con las filas de E y
        // n columnas 
        int[][] MatRes=new int[E.length][n];
        
        //para cada residente
        for (int i = 0; i < E.length; i++) {
            int l=0;
            //para cada hospital
            for (int j = 0; j < E[0].length; j++) {
                int h=E[i][j];
                //se comprueba que no sea el hosp deseado
                if(h !=-1){
                    for (int k = 0; k < Q[h]; k++) {
                        MatRes[i][l]=vaux[h]+k;
                        l++;
                    }
                } else {
                    //en caso de ser el hospital, se copia
                    MatRes[i][l]=-1;
                    l++;
                }
            }
            //en caso de que queden huecos en MatRes se rellenan 
            //con -1
            while(l<n){
                MatRes[i][l]=-1;
                l++;
            }
        }
        return MatRes;
    }    
    public AlgoReducido(){
        Entrada in= new Entrada();
        Q=in.arreglo_q;
        H= new int[in.H.size()][in.H.get(0).size()];
        E= new int[in.E.size()][in.E.get(0).size()];
        
        //se adaptan las entradas
        for (int i = 0; i < in.H.size(); i++) {
            for (int j = 0; j < in.H.get(i).size(); j++) {
                H[i][j]= Integer.parseInt(in.H.get(i).get(j));
            }
        }
        for (int i = 0; i < in.E.size(); i++) {
            for (int j = 0; j < in.E.get(i).size(); j++) {
                E[i][j]= Integer.parseInt(in.E.get(i).get(j));
            }
        }
        
        int[] parejas=Algoritmo.emparejar(E, H);
        Algoritmo.mostrarEmparejamiento(H, parejas);
    
               
        
        /*
        
        imprimir el vector auxiliar
        
        
        //imprimimos las matrices hosp , res  modificadas----
        
        int [][] mat2= hosp_Homb(H, Q);
        String aux2="";
        for (int i = 0; i < mat2.length; i++) {
            aux2+="\n";
            for (int j = 0; j < mat2[0].length; j++) {
                aux2+=mat2[i][j]+" ";
            }
        }
        System.out.println(aux2);
        
        int [][] mat= Res_Muj(E, Q);
        String aux="";
        for (int i = 0; i < mat.length; i++) {
            aux+="\n";
            for (int j = 0; j < mat[0].length; j++) {
                aux+=mat[i][j]+" ";
            }
        }
        System.out.println(aux);
        
        ------------------------   
        
        
        
        
        imprimir la entrada-------------------
        
        String aux2="";
        for (int i = 0; i < in.E.size(); i++) {
            aux2+="\n";
            for (int j = 0; j < in.E.get(0).size(); j++) {
                aux2+=E[i][j]+" ";
            }
        }
        System.out.println(aux2+ "\n"+"E");  
        
        String aux="";
        for (int i = 0; i < in.H.size(); i++) {
            aux+="\n";
            for (int j = 0; j < in.H.get(0).size(); j++) {
                aux+=H[i][j]+" ";
            }
        }
        System.out.println(aux);
        ------------------------------------
        
        */    
        
       
    }
    public static void main(String[] args) {
        AlgoReducido al= new AlgoReducido();
    }
}

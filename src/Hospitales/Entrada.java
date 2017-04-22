/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospitales;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author kevin_000
 */
public class Entrada {
    
    private int m;
    private int n;
    private String entrada;
    public int[] arreglo_q;
    public List<List<String>> E;
    public List<List<String>> H;
    public String Q="";
    
    public Entrada(){
        this.m=2000;
        this.n=2000;
        
        //this.gen_h(n);
        entrada=n+"\r\n\r\n"+this.gen_e(n,m)+"\r\n"+m+"\r\n\r\n"+this.gen_h(n,m)+"\r\n"+this.gen_q(m)+"\r\n";
        //crearchivo(entrada);
    }
    public void crearchivo(String entrada){
       this.entrada=entrada;
       try{
        // creamos el archivo
        String path="C:\\Users\\kevin_000\\Desktop\\entrada.txt";
        File file = new File(path);

        // creamos el archivo en caso de no existir
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        
        // escritor de arch
        bw.write(entrada);
        
        // cerrar conexion con el arch
        bw.close();
            
        }catch(Exception e){
                System.out.println(e);
        } 
       
    }
    
    
    public String gen_q(int m){
        this.m=m;
        this.arreglo_q= new int[m];
        
        for (int i = 0; i < m; i++) {            
            arreglo_q[i]= (int)(1+Math.random() * 5);                         
            Q+=arreglo_q[i]+" ";
        }   
        return Q;
        
        
    }
    
    public String gen_e(int n, int m){
        this.m=m;
        this.n=n;
        String aux="";
        E = new ArrayList<List<String>>();
          
        for (int i = 0; i < n; i++) {
            List<String> List = new ArrayList<String>();
            String aux2="";
            for (int j = 0; j < m; j++) {
                List.add(Integer.toString(j));                 
            }
            Collections.shuffle(List);  
            aux2=List.toString().replace(",", "").replace("[", "").replace("]", "").trim();
            E.add(List);  
            
            aux+=aux2+"\r\n";
        }
        
        return aux;
    }
    
    public String gen_h(int n, int m){
        this.m=m;
        this.n=n;
        String aux="";
        H = new ArrayList<List<String>>();
          
        for (int i = 0; i < m; i++) {
            List<String> List = new ArrayList<String>(); 
            String aux2="";
            for (int j = 0; j < n; j++) {
                List.add(Integer.toString(j));            
            }
            Collections.shuffle(List);            
            H.add(List); 
            aux2=List.toString().replace(",", "").replace("[", "").replace("]", "").trim();
            
            aux+=aux2+"\r\n";
        }        
        return aux;
    }
}

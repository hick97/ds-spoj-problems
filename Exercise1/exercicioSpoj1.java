/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author Ze Carlos
 */
public class exercicioSpoj1 {
    static int n;
    static int m;
   
    public static int[] naoPertence = new int[200];
    
    
    
    public static void main(String args[]){
        int contador;
        Scanner sc = new Scanner(System.in);
        int k;
        
        n = sc.nextInt(); 
        int[] integerS = new int[n];
        
        for(k=0;k<n;k++){
            integerS[k] = sc.nextInt();
        }
        m = sc.nextInt();
        int[] integerQ = new int[m];
         
        for(k=0;k<m;k++){
            integerQ[k] = sc.nextInt();
        }
        contador = Compara(integerS,integerQ,n,m);
      
        
        for(k=0;k<contador;k++){
            System.out.printf("%d ", naoPertence[k]);
           
            
        }
    }
    //Função que verifica se o elemento do primeiro array está no segundo:
    public static int Compara(int a[], int b[], int tam1, int tam2){
        int contador=0,i,j,aux;
        
        for(i=0;i<tam1;i++){
            aux = 0;
            for(j=0;j<tam2;j++){
                
                if(a[i]== b[j]){
                    aux++;
                }
            }
            if(aux == 0){
                naoPertence[contador] = a[i];
                contador++;
             
            }
        }
        return contador;
       
    }
    
}
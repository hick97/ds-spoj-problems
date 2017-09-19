
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ze Carlos
 */
public class Adaindex {
    
       
       static class No{
        private String conteudo;
        private No prox;
        
        public No(){
            prox = null;
	}
        public void setProx(No prox) {
            this.prox = prox;
        }
        
        public String getConteudo() {
            return conteudo;
        }

        public void setConteudo(String conteudo) {
            this.conteudo = conteudo;
	}
	
        public No getProx() {
            return prox;
	}

    }
    
    static class Listas{
        protected No cabeca;
        protected int tamanho;
        protected boolean vazia;
        
        public Listas(int t){
            cabeca = null;		
            tamanho = t;
            vazia = true;
        }
        
        // Metedo que permite inserir as Strings na lista:
        public void insere(String p){
            No novoNo = new No();
            novoNo.setConteudo(p);
            novoNo.setProx(null);

            //Caso a lista esteja vazia, insere no começo:
            if(vazia){
                cabeca = novoNo;
                vazia = false;
            }else{
                No aux = cabeca;
                
                while(aux.getProx() != null){
                    aux = aux.getProx();
                }

                aux.setProx(novoNo);
            }
        }
        
        //Metodo que permite varrer a lista e verificar quantos tem o mesmo prefixo:
        public int quantosComecamEm(String p){
            int contador = 0;
            No aux = cabeca;
            
            for(int i = 0; i <= tamanho; i++){
                if(aux.getConteudo().startsWith(p)){
                    contador++;
                }
                aux = aux.getProx();
            }

            return contador;
        }
        
    }
        public static void main(String args[]){
            
            Scanner sc = new Scanner (System.in);
            // Tamnho da lista TODO:
            int n = sc.nextInt();
            // Quantidade de prefixos nas buscas:
            int p = sc.nextInt();
            int i;
            String words,prefix;
            // Recebendo a lista TODO:        
            Listas toDO = new Listas(n);
            
            for(i=0;i<=n;i++){
                words = sc.nextLine();
                toDO.insere(words);
            }
            // Recebendo o prefixo e chamando a função de verificação:
            for(i=0;i<p;i++){
                prefix = sc.nextLine();
                System.out.println(toDO.quantosComecamEm(prefix));
            }
        }
}

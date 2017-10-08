
import java.util.LinkedList;
import java.util.Scanner;


public class Stack {
    static class PilhaSeq {
	private char dados[]; // Vetor que contÃ©m os dados da lista 
	private int topo; 
	private int tamMax;
    
    public PilhaSeq(){
    		tamMax = 100;
    		dados = new char[tamMax];
    		
    		topo = -1;
    	}
    
    public PilhaSeq(int n){
    		tamMax = n;
    		dados = new char[tamMax];
    		
    		topo = -1;
    }

    /** Verifica se a Pilha estÃ¡ vazia */
    public boolean vazia(){
    		if (topo == -1)
    			return true;
    	   else 
    	      return false;
	}
	
    /**Verifica se a Pilha estÃ¡ cheia */
    public boolean cheia(){
        if (topo == (tamMax-1))
  		  return true;
      else
  		  return false;
	}
	
    /**ObtÃ©m o tamanho da Pilha*/
    public int tamanho(){
		return topo+1;
	}
    
    /** Consulta o elemento do topo da Pilha.
		Retorna -1 se a pilha estiver vazia, 
		caso contrÃ¡rio retorna o valor que estÃ¡ no topo da pilha. */
 	public char top () {
      if (vazia()) 
         return 'v'; // pilha vazia
 	  
      return dados[topo];
 	}
     
	 /** Insere um elemento no topo da pilha.
	  Retorna false se a pilha estiver cheia. 
	  Caso contrÃ¡rio retorna true */
 	public boolean push (char valor) {
 		if (cheia()) 
 			return false;  // err: pilha cheia 
 		
 		topo++;
 		dados[topo] = valor; 
 		return true;
	 }   

	 /** Retira o elemento do topo da pilha.
	  Retorna -1 se a pilha estiver vazia. */
 	public char pop() {          
 		if (vazia()) 
 			return 'v'; // Pilha vazia
 		
 		char valor = dados[topo]; 
 		topo--; 
 		return valor;
 	}
}

    public static LinkedList<String> expressoes = new LinkedList <String>();
    
    public static void main (String []args){
        
    Scanner sc = new Scanner (System.in);
    
    int n = Integer.parseInt(sc.nextLine());
    
    for(int i = 0; i<n ;i++){
       System.out.println("chegou aqui");     
      String exp = sc.nextLine();
       expressoes.add(exp);
    }
    for(String s : expressoes){
        System.out.println("passando expressao: " + s);
        resolvendo(s);
    }
       
    }
    static char result [] =  new char [400];
    public static void resolvendo(String exp){
        
        PilhaSeq s = new PilhaSeq ();
        int t = exp.length();      
       char expression [] = exp.toCharArray();
       System.out.println("Minha expressao eh:");
       for(int j = 0;j<t;j++){
           System.out.printf("%c", expression[j]);
       }
       System.out.println("\n");
       for(int i = 0; i < t; i++){
           char atual = expression[i];
           System.out.printf("Olhando o char: %c\n", atual);
           if (atual == '^' || atual == '(') {
               System.out.printf("Entrou no push o char: %c\n", atual );
                s.push(atual);
           }
           else if (atual == '*' || atual == '/') {
		if (s.top() != '^'){
                    System.out.printf("Entrou no push o char: %c\n", atual );
                    s.push(atual);
                }
	   }
           else if (atual == '+' || atual == '-') {
                if (s.top() != '^' && s.top() != '*' && s.top() != '/'){
                    System.out.printf("Entrou no push o char: %c\n", atual );
                    s.push(atual);
                }
	   }
           else if ((atual == ')')) {
            // Pop out stack until opening parenthesis
            while (s.top() != '(') {
                System.out.printf("Entrou no result o char: %c\n", s.top() );
		result[i] += s.top();
		s.pop();
            }

                s.pop();
            } else {
                System.out.println("Entrou no resultado!");// Operand
                System.out.printf("Entrou no result o char: %c\n",atual);
                result[i] += atual;
            }
       }
      /* while (!s.vazia()) {
            result[i] += s.top();
			//result[i].push_back(s.pop());
			s.pop();
		}
      */
      
      for(int i = 0; i<t ; i++) {
        System.out.printf("%c", result[i]);        
      }	
      System.out.printf("\n");  
    }
}

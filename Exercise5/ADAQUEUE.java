
import java.util.Scanner;


class Fila {
    class No {

        private int conteudo;
        private No prox;
        private No ant;

        public No() {
            conteudo = 0;
            prox = null;
            ant = null;
        }

        public void setContent(int conteudo) {
            this.conteudo = conteudo;
        }

        public int getContent() {
            return conteudo;
        }

        public void setNext(No prox) {
            this.prox = prox;
        }

        public No getNext() {
            return prox;
        }

        public void setPrior(No ant) {
            this.ant = ant;
        }

        public No getPrior() {
            return ant;
        }
    }
    private No front;
    private No back;
    private int size = 0;
    private boolean ehReverso = false;
    
    public void reverte() {
        No aux = front;
        front = back;
        back = aux;
        ehReverso = !ehReverso;
    }
    
    public void addNaFrente(int conteudo) {
        //Caso a fila esteja invertida:
        if (ehReverso) {
        // Reverto de volta e add no final da fila:
            reverte();
            addAtras(conteudo);
        }
        
        //Caso nao este invertida, add na frente:
        else{
            No newNode = new No();
            newNode.setContent(conteudo);
            newNode.setPrior(null);

            if (size == 0) {
                newNode.setNext(null);
                front = newNode;
                back = newNode;
            } else {
                newNode.setNext(front);
                front.setPrior(newNode);
                front = newNode;
            }
            
            size++;
            return;
        }        
        //Volta a reverter:
        reverte();
    }
    public void removeNaFrente() throws Exception {
        
        if (size == 0) {
            throw new Exception("Fila vazia");
        }
          
        if (ehReverso) {
            reverte();
            removeAtras();
        }
             
        else{
            if (size == 1) {
                front = null;
                back = null;
            } else {
                No aux = front;
                front = front.getNext();
                front.setPrior(null);
                aux = null;
                
            }
            
            size--;
            return;
        }               
        reverte();        
    }
    
    public void addAtras(int conteudo) {  
        //Caso esteja revertido add na frente:
        if (ehReverso) {
            reverte();
            addNaFrente(conteudo);
        } 
        
        //Caso nao esteja, add atrás: 
        else {
            No newNode = new No();
            newNode.setContent(conteudo);
            newNode.setNext(null);
        
            if (size == 0) {
                newNode.setPrior(null);
                front = newNode;
                back = newNode;
            } else {
                newNode.setPrior(back);
                back.setNext(newNode);
                back = newNode;
            }
            
            size++;
            return;
        }
        
        //Volta a reverter:
        reverte();
    }
    public void removeAtras() throws Exception {        
        if (size == 0) {
            throw new Exception("Fila vazia");
        }       
        if (ehReverso) {
            reverte();
            removeNaFrente();
        } 
             
        else {
            if (size == 1) {
                back = null;
                front = null;
               
            } else {
                No aux = back;
                back = back.getPrior();
                back.setNext(null);
                aux = null;
            }
            
            size--;
            return;
        }
        reverte();

    }
    //Retorna e remove o valor que ta atrás:
     public int back() throws Exception {
        int valor = back.getContent();
        removeAtras();
        return valor;
    }
    //Retorna e remove o valor que ta na frente:
     public int front() throws Exception {
        int valor = front.getContent();
        removeNaFrente();
        return valor;
    }
    
}
public class ADAQUEUE{

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int q = s.nextInt();
        s.nextLine();

        Fila fila = new Fila();
        int valor, i;
        String aux;

        for (i = 0; i < q; i++) {
            aux = s.nextLine();
            String[] option = aux.split(" ");
            
            try {
            switch (option[0]) {
                case "back":
                    System.out.println(fila.back());
                    break;                   
                case "front":
                    System.out.println(fila.front());
                    break;
                case "reverse":
                    fila.reverte();
                    break;
                case "push_back":
                    fila.addAtras(Integer.parseInt(option[1]));
                    break;
                case "toFront":
                    fila.addNaFrente(Integer.parseInt(option[1]));
                    break;
                default:
                    break;
            }
            
            } catch (Exception e) {
                System.out.println("No job for Ada? ");
            }

        }

    }
}

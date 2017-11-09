
import java.util.Scanner;

class NiceBTree {
    class Node { 
        private char conteudo;
        private Node FilhoEsq;
        private Node FilhoDir;

        public char getContent() {
            return conteudo;
        }

        public void setContent(char c) {
            conteudo = c;
        }

        public Node getLeftChild() {
            return FilhoEsq;
        }

        public void setLeftChild(Node n) {
            FilhoEsq = n;
        }

        public Node getRightChild() {
            return FilhoDir;
        }

        public void setRightChild(Node n) {
            FilhoDir = n;
        }

    }
    private String travessia;
    private int index;
    private Node raiz;
    
    //Construtor
    public NiceBTree(String t) {
        travessia = t;
        index = 0;
        
        //Verifica se é folha ou filho:
        Node newNode = new Node();
        raiz = newNode;
        raiz.setContent(travessia.charAt(index));
        if (raiz.getContent() == 'l') {
            raiz.setLeftChild(null);
            raiz.setRightChild(null);
        } else {
            raiz.setLeftChild(addNo(raiz, travessia.charAt(++index)));
            raiz.setRightChild(addNo(raiz, travessia.charAt(++index)));
        }
    }
    
    //Metodo recursivo de criação de nós: 
    private Node addNo(Node pai, char conteudo) {
        Node novoNo = new Node();
        novoNo.setContent(conteudo);
        
        // Quando é folha:
        if (conteudo == 'l') {
            novoNo.setLeftChild(null);
            novoNo.setRightChild(null);
        } 
        // Chamada recursiva para criação de um novo nó:
        else {
            novoNo.setLeftChild(addNo(novoNo, travessia.charAt(++index)));
            novoNo.setRightChild(addNo(novoNo, travessia.charAt(++index)));
        }

        return novoNo;
    }
    
    //Retorna a profundidade da arvore, ignorando a raiz:
    public int getProfundidade() {
        
        return getProfundidade(raiz) - 1;
    }
    
    //Comparando a profundidade da esquerda com a da direita, de maneira recursiva:
    private int getProfundidade(Node node) {
        if (node == null) {
            return 0;
        }

        int ProfundidadeDaEsq = getProfundidade(node.getLeftChild());
        int ProfundidadeDaDir = getProfundidade(node.getRightChild()); 
        
        if (ProfundidadeDaEsq > ProfundidadeDaDir) {
            return ++ProfundidadeDaEsq;
        } else {
            return  ++ProfundidadeDaDir;
        }
    }
}

public class NiceBTre {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        s.nextLine();

        String travessia;
        int i;
        for (i = 0; i < t; i++) {
            travessia = s.nextLine();

            NiceBTree arvore = new NiceBTree(travessia);
            System.out.println(arvore.getProfundidade());
            
        }
    }
}
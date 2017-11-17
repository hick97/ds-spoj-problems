import java.lang.*;
import java.io.*;

class Main {

    static class No {
        protected int conteudo;
        protected No esquerda;
        protected No direita;

        public No(int conteudo) {
            this.conteudo = conteudo;
            esquerda = null;
            direita = null;
        }
    }

    static class Tree {
        protected No raiz;
        protected int contador;

        public Tree() {
            raiz = null;
            contador = 0;
        }

        public void insereRaiz(int x) {
            No newNode = new No(x);
            raiz = newNode;
        }

        public void insere(int x, No N) {
            while (true) {
                contador++;
                if (x < N.conteudo) {
                    if (N.esquerda == null) {
                        No newNode = new No(x);
                        N.esquerda = newNode;
                        break;
                    } else {
                        //insert(X, N.left);
                        N = N.esquerda;
                    }
                } else {
                    if (N.direita == null) {
                        No newNode = new No(x);
                        N.direita = newNode;
                        break;
                    } else {
                        //insert(X, N.right);
                        N = N.direita;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            Tree arvore = new Tree();

            int tamanho = Integer.parseInt(in.readLine());

            for (int i = 0; i < tamanho; i++) {
                int n = Integer.parseInt(in.readLine());

                if (i == 0) {
                    arvore.insereRaiz(n);
                    System.out.println(arvore.contador);
                } else {
                    arvore.insere(n, arvore.raiz);
                    System.out.println(arvore.contador);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

import java.util.Scanner;

class DLL {
    static class No {
        
		private long conteudo;
		private long conteudoAnt;
		private long conteudoProx;
                
                private No proximo;
                private No anterior;
                
                private No novoProx;
                private No novoAnt;
		
		public No(){
                        conteudo = 0;
			proximo = null;
		}

	public void setContent(long conteudo) {
            this.conteudo = conteudo;
        }

        public long getContent() {
            return conteudo;
        }

        public void setNextContent(long conteudoProx) {
            this.conteudoProx = conteudoProx;
        }

        public long getNextContent() {
            return conteudoProx;
        }

        public void setPriorContent(long conteudoAnt) {
            this.conteudoAnt = conteudoAnt;
        }

        public long getPriorContent() {
            return conteudoAnt;
        }

        public void setNext(No proximo) {
            this.proximo = proximo;
        }

        public No getNext() {
            return proximo;
        }

        public void setPrior(No anterior) {
            this.anterior = anterior;
        }

        public No getPrior() {
            return anterior;
        }

        public void setNewNext(No novoProx) {
            this.novoProx = novoProx;
        }

        public No getNewNext() {
            return novoProx;
        }

        public void setNewPrior(No novoAnt) {
            this.novoAnt = novoAnt;
        }

        public No getNewPrior() {
            return novoAnt;
        }
}
    private No cabeca;
    private No cauda;
    private int tamanho;
    
    public DLL(){
        cabeca = null;
        cauda = null;
        tamanho = 0;
    }
    
    //Add um elemento no final da lista:
    public void add(long conteudo, long conteudoAnt, long conteudoProx) {
        No newNo = new No();
        newNo.setContent(conteudo);
        newNo.setPriorContent(conteudoAnt);
        newNo.setNextContent(conteudoProx);

        if (tamanho == 0) {
            newNo.setNext(null);
            newNo.setPrior(null);
            cabeca = newNo;
            cauda = newNo;
        } else {
            newNo.setNext(null);
            cauda.setNext(newNo);
            newNo.setPrior(cauda);
            cauda = newNo;
        }

        tamanho++;
    }
    
    public boolean ehSana() {
        No aux1 = cabeca;
        No aux2 = cabeca.getNext();
        int i;

        try {

            for (i = 0; aux1 != aux2 && i < tamanho; i++) {
                if (aux1 != aux1.getNewNext().getNewPrior()) {
                    return false;
                }
                aux1 = aux1.getNewNext();
            }
            
            if(i >= tamanho){
                return false;
            }

            return true;

        } catch (Exception e) {
            return false;
        }
    }
    
    //Conecta a lista de acordo com a entrada do usuario:
    public void conectandoLista() {
        No aux1 = cabeca;
        No aux2 = cauda;

        for (int i = 0; i <= tamanho / 2; i++) {
            aux1.setNewPrior(searchConteudo(aux1.getPriorContent()));
            aux1.setNewNext(searchConteudo(aux1.getNextContent()));

            aux2.setNewPrior(searchConteudo(aux2.getPriorContent()));
            aux2.setNewNext(searchConteudo(aux2.getNextContent()));

            aux1 = aux1.getNext();
            aux2 = aux2.getPrior();
        }

        if (tamanho % 2 != 0) {
            aux1.setNewPrior(searchConteudo(aux1.getPriorContent()));
            aux1.setNewNext(searchConteudo(aux1.getNextContent()));
        }
    }
    
    public No searchConteudo(long conteudo) {
        No aux1 = cabeca;
        No aux2 = cauda;

        if (conteudo == 0) {
            return null;
        }

        for (int i = 1; i <= tamanho / 2; i++) {
            if (aux1.getContent() == conteudo) {
                return aux1;
            }
            if (aux2.getContent() == conteudo) {
                return aux2;
            }

            aux1 = aux1.getNext();
            aux2 = aux2.getPrior();
        }

        if (tamanho % 2 != 0 && aux1.getContent() == conteudo) {
            return aux1;
        }

        return null;
    }
}

public class Sanidade{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        long a, b, c;

        DLL list = new DLL();
        String st;

         while (s.hasNext()) {
            st = s.nextLine();
            String[] aux = st.split(" ");
            a = Long.parseUnsignedLong(aux[0], 16);
            b = Long.parseUnsignedLong(aux[1], 16);
            c = Long.parseUnsignedLong(aux[2], 16);
            list.add(a, b, c);
        }

        list.conectandoLista();
        
        if (list.ehSana()) {
            System.out.println("sana");
        } else {
            System.out.println("insana");
        }

    }
}

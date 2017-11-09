import java.io.*;

class Main {
	
	static class Node{
		int conteudo;
		Node esquerda;
		Node direita;
		
		public Node(int value) {
			this.conteudo = value;
			esquerda = null;
			direita = null;
		}
	}
	
	static class Arvore{
		protected String posStr = "";
		protected static int preIndex = 0;
				
		private Node buildTree(String in[], String pre[], int inStrt, int inEnd) 
	    {
	        if (inStrt > inEnd) 
	            return null;
	        
	        int value = Integer.parseInt(pre[preIndex++]);
	        Node tNo = new Node(value);
	 
	        if (inStrt == inEnd)
	            return tNo;
	  
	        int inIndex = search(in, inStrt, inEnd, tNo.conteudo);
	  
	        tNo.esquerda = buildTree(in, pre, inStrt, inIndex - 1);
	        tNo.direita = buildTree(in, pre, inIndex + 1, inEnd);
	  
	        return tNo;
	    }
		
		//method used to find preOrder element inOrder array 
		private int search(String arr[], int strt, int end, int value) 
	    {
	        int i;
	        for (i = strt; i <= end; i++) 
	        {
	        	int arrValue = Integer.parseInt(arr[i]);
	            if ( arrValue == value)
	                return i;
	        }
	        return i;
	    }
		
		private void posOrderTree(Node node) 
	    {
	        if (node == null) return;
		    
	  	//check left node
	        posOrderTree(node.esquerda);
	  
	  	//check right node
	        posOrderTree(node.direita);
	        
		//save node value
	        posStr += node.conteudo + " ";
	    }
		
		private String equalsStr() {
			return posStr;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		try {
			
			Arvore tree = new Arvore();
			
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int tamanho = Integer.parseInt(in.readLine());
		
			//Arvore PreOrder 
			String pre = in.readLine();
			String preOrder[] = pre.split(" ");
			
			//Arvore PosOrder
			String pos = in.readLine();
			
			//Arvore InOrder 
			String inOr = in.readLine();
			String inOrder[] = inOr.split(" ");
			
			
			Node root = tree.buildTree(inOrder, preOrder, 0, tamanho-1);
			
			
			tree.posOrderTree(root);
			
			String posTree = tree.equalsStr();
			
			
			String posStr = posTree.substring(0, posTree.length() - 1);
			if(pos.equals(posStr)) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
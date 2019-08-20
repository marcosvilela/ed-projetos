
public class BinaryTree {
	
	private TreeNode root;			//Atributo da classe TreeNode referente ao n� raiz da �rvore.
	
	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public BinaryTree(){			//Construtor vazio apenas para instanciar a �rvore.
	
	}
	
	public boolean exists(int n){		//M�todo para verificar a exist�ncia de um elemento na �rvore.
		TreeNode run = root;			//Node auxiliar para percorrer a arvore sem perder a referencia da raiz.
		boolean exists = false;			//variavel respons�vel pelo retorno do m�todo.
		
		if(root == null){				//teste para saber se a �rvore est� vazia ou n�o.
			System.out.println("A arvore esta vazia!");
		}
		while(run != null){				//La�o respons�vel por checar a exist�ncia do elemento e saber que lado da �rvore percorrer.
			if(run.getInfo() == n){
				exists = true;
				break;
			}
			else if(run.getInfo() < n){
				run = run.getRight();
			}else{
				run = run.getLeft();
			}
		}
		return exists;
	}

	public void add(int info){			//M�todo respons�vel por adicionar elementos na �rvore.
		TreeNode novo = new TreeNode(info);			//cria��o de um objeto do tipo node que entrar� na �rvore, recebendo o elemento passado como par�metro.
		if(root == null){			//teste para saber se a �rvore est� vazia ou n�o.
			root = novo;			//Caso esteja vazia o elemento vira raiz da �rvore.
		} else {			
			TreeNode aux = root;			//Node auxiliar para percorrer a arvore sem perder a referencia da raiz.
			while(aux != null){		//La�o respons�vel por indicar o lado em que o elemento ser� inserido na �rvore e verificar se o elemento est� repetido.
				if(aux.getInfo() == info){
					System.out.println("O elemento j� foi adicionado na arvore anteriormente!");
					break;
				}else if(info < aux.getInfo()){
					if(aux.getLeft() == null){
						aux.setLeft(novo);
						break;
					}else {
						aux = aux.getLeft();
					}
				}else{
					if(aux.getRight() == null){
						aux.setRight(novo);
						break;
					} else {
						aux = aux.getRight();
					}
				}
			}
		}
	}

	public boolean searchKey(int info){			//M�todo respons�vel por procurar um elemento da �rvore.
		boolean answer = false;				//vari�vel de retorno para o m�todo.
		TreeNode aux = root;				//node auxiliar para percorrer a arvore sem perder a referencia da raiz.
		
		if(root == null){				//teste para saber se a �rvore est� vazia ou n�o.
			System.out.println("A arvore esta vazia!");
		}else{
			while(aux != null){				//la�o para percorrer a �rvore seguindo o lado correto.
				if(aux.getInfo() == info){
					answer = true;
					break;
				}else{
					if(info < aux.getInfo()){
						aux = aux.getLeft();
					}else{
						aux = aux.getRight();	
					}
				}
			}
		}
		return answer;
	}

	public boolean remove(int info){	//M�todo para remover um elemento da �rvore.
		boolean sucess = false;			//variavel de retorno para o m�todo.
		TreeNode aux = root;			//node aux para percorrer a arvore sem perder a referencia da raiz.
		TreeNode paiAux = null;			//node PaiAux para guardar o node anterior ao node que ser� removido.
		TreeNode nodeBackupRight = null;			//Node para guardar a subarvore � direita do node que ser� removido.
		TreeNode nodeBackupLeft = null;			//Node para guardar a subarvore � esquerda do node que ser� removido.
		
		if(root == null){				//Verifica��o para arvore vazia.
			System.out.println("A arvore esta vazia. Primeiro adicione um elemento antes de remover.");
		}else{
			if(root.getInfo() == info){			//Teste para saber se o elemento que se quer remover � a raiz.
				if(aux.getLeft() == null && aux.getRight()== null){ //Caso a raiz n�o tenha nenhum filho
					root = null;
					sucess = true;
				}else if(aux.getRight() == null){ //caso a raiz n�o tenha filhos � direita
					root = aux.getLeft();
					sucess = true;
				}else if(aux.getLeft() == null){ //caso a raiz n�o tenha filhos � esquerda
					root = aux.getRight();
					sucess = true;
				}else { 		//Caso a raiz possua filhos tanto � esquerda como � direita.	
					nodeBackupRight = aux.getRight();			//Guardando a subarvore � direita da raiz.
					aux = aux.getLeft();						//trocando a raiz pelo node � esquerda.
					if(aux.getRight() == null){					//Verificando se esse � o maior elemento � esquerda da raiz.
						root = aux;								
						aux.setRight(nodeBackupRight);
					}else{						
						paiAux = aux;
						while(aux.getRight()!= null){
							aux = aux.getRight();
						}
						root = aux;						//Reorganizando as referencias da arvore e excluindo o elemento.
						aux.setLeft(paiAux);
						aux.setRight(nodeBackupRight);
						sucess = true;
					}
				}
				
			} else {				//Caso o elemento que se quer remover n�o seja a raiz.
				while(aux != null){			//la�o para percorrer at� achar o elemento.
					if(aux.getInfo() > info){
						paiAux = aux;  //ponteiro que guarda a informa��o do pai do n� em quest�o
						aux = aux.getLeft();
					}else if(aux.getInfo() < info) {
						paiAux = aux;
						aux = aux.getRight();
					}else if(aux.getInfo() == info){			//Se o elemento for encontrado ser� feito outro teste para verificar qual o tipo de n�.
						if(aux.getLeft() == null && aux.getRight() == null){ //Caso o n� seja uma folha, delete-o
							paiAux.setLeft(null);
							paiAux.setRight(null);
							sucess = true;
							break;
						}else if(aux.getLeft() == null){
							aux = aux.getRight(); //caso o n� n�o possua filhos � esquerda, o pai aponta pro seu filho � direita
							paiAux.setRight(aux);
							sucess = true;
							break;
						}else if(aux.getRight() == null){
							aux = aux.getLeft(); //caso o n� n�o possua filhos � direita, o pai aponta pro seu filho � esquerda
							paiAux.setLeft(aux);
							sucess = true;
							break;
						}else { 	//Caso o node possua filhos em ambos os ramos, procurar o maior node do ramo esquerdo.
							nodeBackupRight = aux.getRight();		//Guardando a informa��o da subarvore � direita.
							aux = aux.getLeft();				//Mudando a referencia no node que ser� removido para o filho dele do ramo esquerdo.
							if(aux.getRight() == null){			//verificando se esse node � o maior do lado esquerdo da �rvore.
								paiAux.setRight(aux);
								aux.setRight(nodeBackupRight);
							} else {
								nodeBackupLeft = aux;
								while(aux.getRight() != null){
									aux = aux.getRight();			//Caso n�o seja continue pegando elementos maiores desse ramo.
								}
								paiAux.setRight(aux);
								aux.setLeft(nodeBackupLeft);
							}
							sucess = true;
							break;
						}
					}
				}if(!sucess){			//Caso o elemento n�o tenha sido achado � exibido no console uma mensagem de erro.
					System.out.println("O elemento n�o esta inserido na arvore. Impossivel remover!");
				}
			}
		}
		return sucess;
	}
	
	public void printInOrder(TreeNode root){
		if(root != null){
			printInOrder(root.getLeft()); //Visita todos os n�s � esquerda
			System.out.print( " " + root.getInfo() + " \n");  //Visita a raiz
			printInOrder(root.getRight()); //Visita todos os n�s � direita

		}
		
	}
}	
	
	

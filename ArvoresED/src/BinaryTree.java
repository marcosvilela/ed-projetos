
public class BinaryTree {
	
	private TreeNode root;			//Atributo da classe TreeNode referente ao nó raiz da árvore.
	
	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public BinaryTree(){			//Construtor vazio apenas para instanciar a árvore.
	
	}
	
	public boolean exists(int n){		//Método para verificar a existência de um elemento na árvore.
		TreeNode run = root;			//Node auxiliar para percorrer a arvore sem perder a referencia da raiz.
		boolean exists = false;			//variavel responsável pelo retorno do método.
		
		if(root == null){				//teste para saber se a árvore está vazia ou não.
			System.out.println("A arvore esta vazia!");
		}
		while(run != null){				//Laço responsável por checar a existência do elemento e saber que lado da árvore percorrer.
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

	public void add(int info){			//Método responsável por adicionar elementos na árvore.
		TreeNode novo = new TreeNode(info);			//criação de um objeto do tipo node que entrará na árvore, recebendo o elemento passado como parâmetro.
		if(root == null){			//teste para saber se a árvore está vazia ou não.
			root = novo;			//Caso esteja vazia o elemento vira raiz da árvore.
		} else {			
			TreeNode aux = root;			//Node auxiliar para percorrer a arvore sem perder a referencia da raiz.
			while(aux != null){		//Laço responsável por indicar o lado em que o elemento será inserido na árvore e verificar se o elemento está repetido.
				if(aux.getInfo() == info){
					System.out.println("O elemento já foi adicionado na arvore anteriormente!");
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

	public boolean searchKey(int info){			//Método responsável por procurar um elemento da árvore.
		boolean answer = false;				//variável de retorno para o método.
		TreeNode aux = root;				//node auxiliar para percorrer a arvore sem perder a referencia da raiz.
		
		if(root == null){				//teste para saber se a árvore está vazia ou não.
			System.out.println("A arvore esta vazia!");
		}else{
			while(aux != null){				//laço para percorrer a árvore seguindo o lado correto.
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

	public boolean remove(int info){	//Método para remover um elemento da árvore.
		boolean sucess = false;			//variavel de retorno para o método.
		TreeNode aux = root;			//node aux para percorrer a arvore sem perder a referencia da raiz.
		TreeNode paiAux = null;			//node PaiAux para guardar o node anterior ao node que será removido.
		TreeNode nodeBackupRight = null;			//Node para guardar a subarvore à direita do node que será removido.
		TreeNode nodeBackupLeft = null;			//Node para guardar a subarvore à esquerda do node que será removido.
		
		if(root == null){				//Verificação para arvore vazia.
			System.out.println("A arvore esta vazia. Primeiro adicione um elemento antes de remover.");
		}else{
			if(root.getInfo() == info){			//Teste para saber se o elemento que se quer remover é a raiz.
				if(aux.getLeft() == null && aux.getRight()== null){ //Caso a raiz não tenha nenhum filho
					root = null;
					sucess = true;
				}else if(aux.getRight() == null){ //caso a raiz não tenha filhos à direita
					root = aux.getLeft();
					sucess = true;
				}else if(aux.getLeft() == null){ //caso a raiz não tenha filhos à esquerda
					root = aux.getRight();
					sucess = true;
				}else { 		//Caso a raiz possua filhos tanto à esquerda como à direita.	
					nodeBackupRight = aux.getRight();			//Guardando a subarvore á direita da raiz.
					aux = aux.getLeft();						//trocando a raiz pelo node à esquerda.
					if(aux.getRight() == null){					//Verificando se esse é o maior elemento à esquerda da raiz.
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
				
			} else {				//Caso o elemento que se quer remover não seja a raiz.
				while(aux != null){			//laço para percorrer até achar o elemento.
					if(aux.getInfo() > info){
						paiAux = aux;  //ponteiro que guarda a informação do pai do nó em questão
						aux = aux.getLeft();
					}else if(aux.getInfo() < info) {
						paiAux = aux;
						aux = aux.getRight();
					}else if(aux.getInfo() == info){			//Se o elemento for encontrado será feito outro teste para verificar qual o tipo de nó.
						if(aux.getLeft() == null && aux.getRight() == null){ //Caso o nó seja uma folha, delete-o
							paiAux.setLeft(null);
							paiAux.setRight(null);
							sucess = true;
							break;
						}else if(aux.getLeft() == null){
							aux = aux.getRight(); //caso o nó não possua filhos à esquerda, o pai aponta pro seu filho à direita
							paiAux.setRight(aux);
							sucess = true;
							break;
						}else if(aux.getRight() == null){
							aux = aux.getLeft(); //caso o nó não possua filhos à direita, o pai aponta pro seu filho à esquerda
							paiAux.setLeft(aux);
							sucess = true;
							break;
						}else { 	//Caso o node possua filhos em ambos os ramos, procurar o maior node do ramo esquerdo.
							nodeBackupRight = aux.getRight();		//Guardando a informação da subarvore á direita.
							aux = aux.getLeft();				//Mudando a referencia no node que será removido para o filho dele do ramo esquerdo.
							if(aux.getRight() == null){			//verificando se esse node é o maior do lado esquerdo da árvore.
								paiAux.setRight(aux);
								aux.setRight(nodeBackupRight);
							} else {
								nodeBackupLeft = aux;
								while(aux.getRight() != null){
									aux = aux.getRight();			//Caso não seja continue pegando elementos maiores desse ramo.
								}
								paiAux.setRight(aux);
								aux.setLeft(nodeBackupLeft);
							}
							sucess = true;
							break;
						}
					}
				}if(!sucess){			//Caso o elemento não tenha sido achado é exibido no console uma mensagem de erro.
					System.out.println("O elemento não esta inserido na arvore. Impossivel remover!");
				}
			}
		}
		return sucess;
	}
	
	public void printInOrder(TreeNode root){
		if(root != null){
			printInOrder(root.getLeft()); //Visita todos os nós à esquerda
			System.out.print( " " + root.getInfo() + " \n");  //Visita a raiz
			printInOrder(root.getRight()); //Visita todos os nós à direita

		}
		
	}
}	
	
	

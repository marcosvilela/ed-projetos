import java.util.*;

public class TestBinaryTree {

	public static void main(String[] args) {
		int op;
		int op2;
		BinaryTree tree = new BinaryTree();
		Scanner sc = new Scanner(System.in);
		
		while(true){
			System.out.println("ARVORE BINARIA --------------------- \n");
			System.out.println("1 - Inserir elemento: \n2 - Consultar elemento: \n3 - Retornar elemento: \n4 - Remover elemento: \n5 - Printar Em-Ordem: \n6 - Sair do programa: ");
			System.out.print("ESCOLHA: ");
			op = sc.nextInt();
			switch (op){
			case 1:
				System.out.println("Informe o elemento a ser adicionado: ");
				int elemento = sc.nextInt();
				tree.add(elemento);
				System.out.println("Deseja continuar no programa? 0 - sim/1 - nao");
				op2 = sc.nextInt();
				if(op2 == 1){
					System.out.println("Ate a proxima!");
					System.exit(0);
				}
				break;
			case 2:
				System.out.println("Informe o elemento a ser consultado: ");
				int elemento2 = sc.nextInt();
				if(tree.exists(elemento2)){
					System.out.println("O elemento está presente na Árvore! ");	
				}else{
					System.out.println("O elemento não existe na Árvore!");
				}
				System.out.println("Deseja continuar no programa? 0 - sim/1 - nao");
				op2 = sc.nextInt();
				if(op2 == 1){
					System.out.println("Ate a proxima!");
					System.exit(0);
				}
				break;
			case 3:
				System.out.println("Informe o elemento: ");
				int elemento3 = sc.nextInt();
				if(tree.searchKey(elemento3)){
				System.out.println("O elemento em questão é: " + elemento3 );
				System.out.println("Deseja continuar no programa? 0 - sim/1 - nao");
				}
				op2 = sc.nextInt();
				if(op2 == 1){
					System.out.println("Ate a proxima!");
					System.exit(0);
				}
				break;
			case 4:
				System.out.println("Informe o elemento a ser removido: ");
				int elemento4 = sc.nextInt();
				tree.remove(elemento4);
				System.out.println("Deseja continuar no programa? 0 - sim/1 - nao");
				op2 = sc.nextInt();
				if(op2 == 1){
					System.out.println("Ate a proxima!");
					System.exit(0);
				}
				break;
			case 5:
				tree.printInOrder(tree.getRoot());
				System.out.println("Deseja continuar no programa? 0 - sim/1 - nao");
				op2 = sc.nextInt();
				if(op2 == 1){
					System.out.println("Ate a proxima!");
					System.exit(0);
				}
				break;
			default:
				System.out.println("Ate a proxima!");
				sc.close();
				System.exit(0);
			}	
			
			
						
		}	
	

	}
	

}

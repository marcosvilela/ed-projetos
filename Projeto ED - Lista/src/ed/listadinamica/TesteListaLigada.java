package ed.listadinamica;

public class TesteListaLigada {
	public static void main(String[] args) {
		/*Inicializando a lista.*/
		
		List l = new List();
		
		/*Adicionando elementos.*/
		
		l.addInfo(9);
		l.addInfo(6);
		l.addInfo(8);
		l.addInfo(-14);
		l.addInfo(1);
		l.addInfo(5);
		l.addInfo(3);
		l.addInfo(15);
		l.addInfo(0);
		
		/*APENAS VALORES DENTRO DAS CONDICOES DO PROGRAMA.
		/*Testando o metodo de pegar o Iesimo elemento da lista.*/
		
		l.getIElement(4);
		
		/*Testando o metodo de consultar a existencia de um elemento na lista.*/
		
		l.searchInfo(0);
		
		/*Testando o metodo de imprimir os elementos da lista.*/
		
		l.printList();

		/*Testando o metodo de remover um elemento da lista.*/
		
		l.remove(5);
		
		/*Verificando se o objeto foi removido.*/
		
		l.printList();
		
		/*Esvaziando a lista.*/
		
		l.drainOutList();
		
		/*Verificando se a lista esta vazia.*/
		
		l.printList();
		
		/*INICIO DOS TESTES DE ERROS.
		 * Tentando esvaziar uma lista que ja esta vazia.
		 */
		
		l.drainOutList();
		
		/*Tentando remover um elemento de uma lista vazia.*/
		
		l.remove(0);
		
		/*Tentando consultar um elemento de uma lista vazia.*/
		
		l.searchInfo(0);
		
		/*Tentando obter o iesimo elemento de uma lista vazia.*/
		
		l.getIElement(0);
	}
}

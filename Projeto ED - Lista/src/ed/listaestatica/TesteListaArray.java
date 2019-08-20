package ed.listaestatica;


public class TesteListaArray {
	public static void main(String [] args){
	List l = new List();
	
	/* Adicionando elementos no array */
	l.addInfo(4);
	l.addInfo(10);
	l.addInfo(7);
	l.addInfo(17);

	/* printando o array e seu tamanho*/
	l.printList();
	System.out.println("\n Tamanho da Lista: " + l.getSize());
	
	/*Checando se a informa��o desejada existe na lista */
	System.out.println("Existe? " + l.containsInfo(7));
	System.out.println("Existe? " + l.containsInfo(40));
	System.out.println("Existe? " + l.containsInfo(17));
	
	/* buscando a informa��o da i-�sima posi��o v�lida do array */
	System.out.println("Segundo elemento do array: " + l.returnInfo(1));
	
	//Removendo a informa��o '4', e printando a lista para mostrar que o 4 n�o existe mais no array
	l.removeInfo(4);
	
	l.printList();
	System.out.println("\n Tamanho da Lista: " + l.getSize());
	System.out.println("\n");
	
	//Esvaziando a lista -- O erro de NullPointer ao chamar o contains � esperado, pois a lista estar� com todos os elementos nulos i.e, vazia.
	l.emptyList();
	l.containsInfo(10);
	
	
	}
}
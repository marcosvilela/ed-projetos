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
	
	/*Checando se a informação desejada existe na lista */
	System.out.println("Existe? " + l.containsInfo(7));
	System.out.println("Existe? " + l.containsInfo(40));
	System.out.println("Existe? " + l.containsInfo(17));
	
	/* buscando a informação da i-ésima posição válida do array */
	System.out.println("Segundo elemento do array: " + l.returnInfo(1));
	
	//Removendo a informação '4', e printando a lista para mostrar que o 4 não existe mais no array
	l.removeInfo(4);
	
	l.printList();
	System.out.println("\n Tamanho da Lista: " + l.getSize());
	System.out.println("\n");
	
	//Esvaziando a lista -- O erro de NullPointer ao chamar o contains é esperado, pois a lista estará com todos os elementos nulos i.e, vazia.
	l.emptyList();
	l.containsInfo(10);
	
	
	}
}
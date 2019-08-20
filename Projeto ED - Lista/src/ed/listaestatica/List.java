package ed.listaestatica;

import java.util.Arrays;

public class List {
	private Integer[] list; 
	private int size;
	
	public List() {
		this.list = new Integer[20];
		this.size = 0;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void addInfo(int info){
		if(size == 0){
			list[0] = info;
			size++;
		}else{
		for(int i = 1; i < list.length; i++){ /*percorrendo o array a procura de uma posição vaga*/
			if(list[i] == null){ /*Se a posição for vaga... */
				list[i] = info; /*adicione a informação*/
				size++; /*e aumente o tamanho da lista*/
				break;
			}
	
		}
	}
		Arrays.sort(list,0,size); /*Esse método ordena os valores dentro do array em ordem crescente*/
}
	
	
	public boolean containsInfo(int info){
		
		boolean retorno = false;
		if(list[binarySearch(list, info, 0, this.size - 1)] == info){    /*caso o elemento exista no indice do array dado pela binarySearch...*/
				
			retorno = true;              /*o retorno se torna verdadeiro*/
			
		}else{
			retorno = false;            /*caso contrario, o metodo retorna falso*/
		}
		return retorno;
	}
	
	public int returnInfo(int index) {
		if(!(index >= 0 && index < this.size)){  /*Checando se a posição existe no array*/
			System.out.println("Essa posicao nao existe no array!");
		}else{
			return list[index];
			
		}
	}
	
	public void removeInfo(int info){
		int index = binarySearch(list, info, 0, this.size -1);  //atribui o indice da informação passada
		if(index != -1){ //caso o elemento tenha sido encontrado no array...
			do	{
			list[index] = list[index+1];     /*desloca à frente a posição seguinte, eliminando a informação requerida*/
			index++;
							
			}while(index != this.size);   /*repete isso até que todos os indices sejam movidos*/
			this.size--;  /*diminui o tamanho da lista*/
			}
		}
	
	
	public void emptyList(){
		for(int i = 0; i < this.size; i++){
			list[i] = null;  /*nulifica cada elemento - se tu achar uma maneira melhor de esvaziar, pode reescrever, mas acho que é isso*/
		}
	}
	
public void printList(){
		
		for(int i =0; i< size; i++){
			System.out.print(list[i] + " "); /*printando na tela a lista inteira*/
			
		}
	}
	
	public int binarySearch(Integer[] list, int search, int start, int finish){
		
	                         
			int middle = (finish + start)/2;		/*atribui-se a uma variavel auxiliar o indice do meio do array*/
			if(start > finish ) {
				return -1; 							/*Caso o elemento não seja encontrado, retorne -1 como código de erro*/
			}else if(list[middle] == search){
				return middle;				/*caso o elemento esteja no meio do array (caso base), retorne o indice dele*/
			}else if(list[middle]< search){
				return binarySearch(list, search, middle+1, finish);  /*caso o elemento seja maior que, refaça a busca na metade superior do array*/
			}else 
				return binarySearch(list, search, start, middle-1);  /*caso contrario, refaça a busca na metade inferior do array*/
	}
		
				
	
}
	
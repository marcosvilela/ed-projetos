package ed.listadinamica;

public class Node {
	 private Node next;
	 private int info;
	
	public Node(){
		
	}
	public Node(int info){
		this.info = info;	
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

}



public class TreeNode {
	
	private TreeNode left;
	private TreeNode right;
	private int info;

	public TreeNode(){
		
	}
	
	public TreeNode(int info){
		this.setInfo(info);
	}
	
	public void setInfo(int info){
		this.info = info;
	}

	public int getInfo(){
		return info;
	}

	public void setLeft(TreeNode left){
		this.left = left;
	}

	public TreeNode getLeft(){
		return left;
	}

	public void setRight(TreeNode right){
		this.right = right;
	}

	public TreeNode getRight(){
		return right;
	}
}

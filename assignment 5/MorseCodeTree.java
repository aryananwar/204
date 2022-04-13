import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	
	private TreeNode<String> root = new TreeNode();

	/**
	 * no-arg constructor that builds tree
	 */
	public MorseCodeTree()
	{
		this.buildTree();
	}

	/**
	 *
	 * @return root node
	 */
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	/**
	 *
	 * @param newNode a TreeNode<T> that will be the new root
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = new TreeNode<String>(newNode);
		
	}

	/**
	 *
	 * @param code the String for the new node to be added
	 * @param letter
	 */
	@Override
	public void insert(String code, String letter) {
		addNode(root, code, letter);
		
	}

	/**
	 *
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		
		switch (code.length())
		{
			case 1:
				if (code.charAt(0) =='.')
					root.left = new TreeNode(letter);
				if (code.charAt(0) =='-')
					root.right = new TreeNode(letter);
				break;
				
			default:
				if (code.charAt(0) == '-')
					addNode(root.right, code.substring(1), letter);
				if (code.charAt(0) == '.')
					addNode(root.left, code.substring(1),letter);
				break;
				
		}
		

		
	}

	/**
	 *
	 * @param code the code that describes the traversals within the tree
	 * @return
	 */
	@Override
	public String fetch(String code) {
		return (fetchNode(root, code));
	}

	/**
	 *
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
 		String t = "";
 		switch (code.length())
 		{
 			case 1:
 				if (code.equals("-"))
 					t = root.right.data;
 				 if (code.equals(".")) 
 					t =  root.left.data;
 				 break;
 	
 			default:
 				if (code.charAt(0) =='.')
 					t = fetchNode(root.left, code.substring(1));
 				if (code.charAt(0) =='-')
 					t = fetchNode(root.right, code.substring(1));
 				break;
 				
 		}
 		return t;
		
	}

	/**
	 *
	 * @param data data of node to be deleted
	 * @return
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @return
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * Inserts all characters into tree
	 */
	@Override
	public void buildTree() {
		root = new TreeNode<>("");
		this.insert(".", "e");
		this.insert("-", "t");
		this.insert("..", "i");
		this.insert(".-", "a");
		this.insert("-.", "n");
		this.insert("--", "m");
		this.insert("...", "s");
		this.insert("..-", "u");
		this.insert(".-.", "r");
		this.insert(".--", "w");
		this.insert("-..", "d");
		this.insert("-.-", "k");
		this.insert("--.", "g");
		this.insert("---", "o");
		this.insert("....", "h");
		this.insert("...-", "v");
		this.insert("..-.", "f");
		this.insert(".-..", "l");
		this.insert(".--.", "p");
		this.insert(".---", "j");
		this.insert("-...", "b");
		this.insert("-..-", "x");
		this.insert("-.-.", "c");
		this.insert("-.--", "y");
		this.insert("--..", "z");
		this.insert("--.-", "q");
		
	}

	/**
	 *
	 * @return ArrayList containing all elements in tree based on LNR traversal
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> list = new ArrayList<String>();
		LNRoutputTraversal(root, list);
		return list;
	}

	/**
	 *
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		
		if (root != null)
		{
			if (root.left != null)
				LNRoutputTraversal(root.left, list);
			list.add(root.data);
			if (root.right != null)
				LNRoutputTraversal(root.right, list);
		}
		
		
		
	}

}

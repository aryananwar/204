
public class TreeNode<T> {
	public T data;
	public TreeNode<T> left;
	public TreeNode<T> right;

	/**
	 * No arg constructor
	 */
	public TreeNode()
	{}

	/**
	 *
	 * @param data
	 */
	public TreeNode(T data)
	{
		this.data = data;
	}

	/**
	 * constructor
	 * @param node
	 */
	public TreeNode(TreeNode<T> node)
	{
		this.data = node.data;
		this.left = node.left;
		this.right = node.right;
	}


	/**
	 * paramatarized constructor
	 * @param left
	 * @param right
	 * @param data
	 */
	public TreeNode(TreeNode<T> left, TreeNode<T> right, T data) {
		this.left = left;
		this.right = right;
		this.data = data;
	}
}

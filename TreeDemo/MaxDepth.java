package simple;
/*
第104题

 */
public class MaxDepth {
    /*
    深度优先搜索，递归方式，计算左右子树的深度
     */
    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }else{
            int left_h = maxDepth(root.left);
            int right_h = maxDepth(root.right);
            return Math.max(left_h,right_h)+1;
        }
    }

    public static void main(String[] args) {
        MaxDepth md = new MaxDepth();
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(17);

        root.left=node1;
        root.right=node2;
        node1.left=null;
        node1.right=null;
        node2.left=node3;
        node2.right=node4;

        System.out.println(md.maxDepth(root));
    }
}

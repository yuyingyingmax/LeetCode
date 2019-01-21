package simple;

/*
第98题 中等
 */
import java.util.Stack;

public class IsValidBST {
    /*
    我的方法1：这种方法只能保持局部解正确,对下面这种树会判断为true，实际上为false，因为15的左孩子为6<10，不是正确的解法
           10
          /  \
         5   15
             / \
            6  20
     */
    public boolean isValidBST(TreeNode root){
        if(root==null||(root.left==null&&root.right==null)){
            return true;
        }
        boolean flag = false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.right!=null){
                if(node.right.val>node.val){
                    flag=true;
                    stack.push(node.right);
                }else{
                    return false;
                }
            }
            if(node.left!=null){
                if(node.left.val<node.val){
                    flag = true;
                    stack.push(node.left);
                }else{
                    return false;
                }
            }
        }
        return flag;
    }
    /*
    我的解法2：利用中序遍历来判断，设置前驱结点，如果前驱结点>=当前节点，说明不是二查搜索树
     */
    TreeNode pre=null;
    public boolean isValidBST_two(TreeNode root){

        if(root!=null){
            if(!isValidBST_two(root.left)){
                return false;
            }
            if(pre!=null && root.val<=pre.val){
                return false;
            }
            pre = root;
            if(!isValidBST_two(root.right)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsValidBST ivb = new IsValidBST();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(15);
//        TreeNode node3 = new TreeNode(6);
//        TreeNode node4 = new TreeNode(20);

        root.left=node1;
//        root.right=node2;
//        node1.left=null;
//        node1.right=null;
//        node2.left=node3;
//        node2.right=node4;

        System.out.println(ivb.isValidBST_two(root));
    }
}

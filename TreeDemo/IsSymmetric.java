package simple;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {
    /*
    我的解法：这个方法不对，在找规律的时候没有考虑全部情况，利用中序遍历转换为判断回文串的问题，但不对。
     */
    public void inOrder(TreeNode node, ArrayList<Integer> array){
        if(node!=null){
            inOrder(node.left,array);
            array.add(node.val);
            inOrder(node.right,array);
        }
    }

    public boolean isSymmetric(TreeNode root){
        if(root==null||(root.left==null&&root.right==null)){
            return true;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        inOrder(root,arrayList);
        for(int i = 0,j=arrayList.size()-1;i<j;i++,j--){
            if(!arrayList.get(i).equals(arrayList.get(j))){
                return false;
            }
        }
        return true;
    }
    /*
    官方解法1：利用递归，左子树必须和右子树相同才对称
     */
    public boolean isMirror(TreeNode t1,TreeNode t2){
        if(t1==null&&t2==null){
            return true;
        }
        if(t1==null||t2==null){
            return false;
        }
        return (t1.val==t2.val) && isMirror(t1.left,t2.right)&&isMirror(t1.right,t2.left);
    }
    public boolean isSymmetric_two(TreeNode root){

        return isMirror(root,root);
    }

    /*
   官方解法2：迭代，类似BFS，利用队列判断左右子树是否相等
    */
    public boolean isSymmetric_three(TreeNode root){
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        treeNodeQueue.add(root);

        while(!treeNodeQueue.isEmpty()){
            TreeNode node1=treeNodeQueue.poll();
            TreeNode node2=treeNodeQueue.poll();
            if(node1==null && node2==null) continue;
            if(node1==null || node2==null) return false;
            if(node1.val!=node2.val) return false;
            treeNodeQueue.add(node1.left);
            treeNodeQueue.add(node2.right);
            treeNodeQueue.add(node1.right);
            treeNodeQueue.add(node2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        IsSymmetric is = new IsSymmetric();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);

        root.left=node1;
        root.right=node2;

        node1.left=node3;
        node1.right=node4;

        node2.left=node5;
        node2.right=node6;

        System.out.println(is.isSymmetric(root));
    }
}

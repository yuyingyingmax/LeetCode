package simple;
/*
102题 中
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            List<Integer> nodePerLev = new ArrayList<>();
            int size = treeNodeQueue.size();
            for(int i = 0;i<size;i++){
                TreeNode tnode = treeNodeQueue.poll();
                nodePerLev.add(tnode.val);
                if (tnode.left != null) {
                    treeNodeQueue.add(tnode.left);
                }
                if (tnode.right != null) {
                    treeNodeQueue.add(tnode.right);
                }
            }
            list.add(nodePerLev);
        }
        return list;
    }
    /*
    递归解法
     */
    public List<List<Integer>> levelOrder_two(TreeNode root) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        addList(list,0,root);
        return list;
    }

    public void addList(List<List<Integer>> list, int level,TreeNode node){
        if(node==null)
            return;
        if(list.size()-1<level)
            list.add(new ArrayList<Integer>());
        list.get(level).add(node.val);
        addList(list,level+1,node.left);
        addList(list,level+1,node.right);
    }

    public static void main(String[] args) {
        LevelOrder lo = new LevelOrder();
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        root.left=node1;
        root.right=node2;
        node2.left=node3;
        node2.right=node4;

        System.out.println(lo.levelOrder(root));

    }
}

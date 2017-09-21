package org.tree;

/**
 * Created by ruancl@xkeshi.com on 2017/9/14.
 *
 * 平衡二叉树
 1、An insertion into the left subtree of the left child of A; （LL）
 2、An insertion into the right subtree of the left child of A;（RL）
 3、An insertion into the left subtree of the right child of A;（LR）
 4、An insertion into the right subtree of the right  child of A;（RR）

 旋转方法：
 1、A 和 A's child 顺时针旋转 singlerotateLL()
 4、A 和 A's child 逆时针旋转 singlerotateRR()
 2、A's child 和 A's grandchild 逆时针旋转，A 和 A's new child 顺时针旋转  doublerotateRL()
 3、A's child 和 A's grandchild 顺时针旋转，A 和 A's new child 逆时针旋转 doublerotateLR()
 */
public class AVLTree {

    private AVLNode head;
    
    class AVLNode{
        int height = 0;

        int val;

        AVLNode left,right;

        public AVLNode(int val) {
            this.val = val;
        }
    }

    public AVLTree(int val) {
        this.head = new AVLNode(val);
    }

    public void add(int v){
        add(head,new AVLNode(v));
    }

    private void add(AVLNode root,AVLNode node){
        if(node.val<root.val){
            if(root.left == null){
                root.left = node;
            }else{
                add(root.left,node);
                if(height(root.left)-height(root.right) == 2){
                    if(node.val<root.left.val){
                        //单旋转
                        singleRoteWithLeft(root);
                    }else{
                        //双旋转
                    }
                }
            }
        }else{
            if(root.right == null){
                root.right = node;
            }else{
                add(root.right,node);
                if(height(root.right)-height(root.left) == 2){
                    if(node.val > root.right.val){
                        //单xuanzhuan
                    }else{
                        //双旋转
                    }
                }
            }
        }
        root.height = Math.max(height(root.left),height(root.right))+1;
    }

    private void singleRoteWithLeft(AVLNode node){
        AVLNode left = node.left;
        node.left = left.right;
        left.right = node;
        left.height = Math.max(height(left.left),height(left.right))+1;
        node.height = Math.max(height(node.left),height(node.right))+1;
    }

    private int height(AVLNode node){
        return node == null ? -1 : node.height;
    }





    public static void main(String[] args) {
        
        AVLTree tree = new AVLTree(15);
        tree.add(5);
        tree.add(16);
        tree.add(3);
        tree.add(6);
        tree.add(1);
       /* tree.add(12);
        tree.add(20);
        tree.add(10);
        tree.add(13);
        tree.add(18);
        tree.add(23);
        tree.add(7);*/
        System.out.println("a");

    }

    private void turn(){

    }
}

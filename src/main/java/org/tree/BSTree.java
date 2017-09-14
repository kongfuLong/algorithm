package org.tree;

/**
 * Created by ruancl@xkeshi.com on 2017/9/14.
 *
 *
 * 二叉搜索树
 */
public class BSTree {
    BSTree left;
    BSTree right;
    int val;

    /**
     * 中序打印
     * @param node
     */
    public void print(BSTree node) {
        if (node != null) {
            print(node.left);
            System.out.println(node.val);
            print(node.right);
        }
    }

    public BSTree(int val) {
        this.val = val;
    }


    /**
     * 节点删除
     * 1.找到要删除的节点
     * 2.如果没有任何子节点 直接删除
     * 3.如果有一个子节点  删除节点  吧子节点接上来
     * 4.如果有两个子节点 从右节点递归寻找 最靠近自己的那个节点（没有左节点）
     * @param v
     * @param root
     * @return
     */
    public BSTree delete(int v, BSTree root) {
        BSTree current = root;
        BSTree parent = null;
        Boolean ifLeft = false;
        while (current.val != v) {
            parent = current;
            if (current.val > v) {
                current = current.left;
                ifLeft = true;
            } else {
                ifLeft = false;
                current = current.right;
            }
        }
        BSTree min;
        if (current.left == null && current.right == null) {
            min = null;
        } else if (current.left == null) {
            min = current.right;
        } else if (current.right == null) {
            min = current.left;
        } else {
            BSTree tail = current.right;
            while (tail.left != null) {
                tail = tail.left;
            }
            delete(tail.val,current);
            min = tail;
            min.left = current.left;
            min.right = current.right;
        }
        if (parent != null) {
            if (ifLeft) {
                parent.left = min;
            } else {
                parent.right = min;
            }
        }else{
            parent = min;
        }

        return parent;
    }


    /**
     * 节点插入  如果小于自己则往左找位置，大于等于自己则往右找位置  递归执行
     * @param v
     */
    public void add(int v) {
        if (v < val) {
            if (left == null) {
                left = new BSTree(v);
            } else {
                left.add(v);
            }
        } else {
            if (right == null) {
                right = new BSTree(v);
            } else {
                right.add(v);
            }
        }
    }

    public static void main(String[] args) {
        //15 5 16 3 12 20 10 13 18 23 6 7
        BSTree head = new BSTree(15);
        head.add(5);
        head.add(16);
        head.add(3);
        head.add(12);
        head.add(20);
        head.add(10);
        head.add(13);
        head.add(18);
        head.add(23);
        head.add(6);
        head.add(7);
        head = head.delete(15, head);
        head.print(head);
    }
}

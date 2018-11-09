package org.laidu.learn.code.practice.jianzhioffer;

import lombok.extern.slf4j.Slf4j;

/**
 * 重建二叉树
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * <p>
 * Created by tiancai.zang
 * on 2018-04-25 22:23.
 */
@Slf4j
public class ReConstructBinaryTree {

    public static void main(String[] args) {

        ReConstructBinaryTree reConstructBinaryTree = new ReConstructBinaryTree();

        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};

        TreeNode treeNode = reConstructBinaryTree.reConstructBinaryTree(pre, in);

        System.out.println(treeNode);

    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        return re(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode re(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {


        if (preStart > preEnd || inStart > inEnd || in.length != pre.length || in.length == 0){
            return null;
        }

        /*
          step 1 : 根据前序遍历第一个元素为 root 节点
         */
        int node = pre[preStart];
        TreeNode treeNode = new TreeNode(node);

        int nodeIndex = indexOf(in,node);

        /*
          step 2 : 设置左子树
         */
        treeNode.left = re(pre, preStart+1, preStart + nodeIndex - inStart, in, inStart,nodeIndex-1);

        /*
          step 3 : 设置右子树
         */
        treeNode.right = re(pre, preStart + nodeIndex - inStart + 1 , preEnd, in, nodeIndex+1,inEnd);

        return  treeNode;
    }

    /**
     * 获取 数组下标
     * @param array
     * @param value
     * @return
     */
    public int indexOf(int[] array, int value){
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]){
                return i;
            }
        }

        throw  new IllegalArgumentException("数据不合法");
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
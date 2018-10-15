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

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        /*
          step 1 : 判断临界条件
         */
        if (pre.length != in.length || pre.length < 1) {
            return null;
        }

        /*
          step 2 : 根据前序遍历确定根节点
         */
        TreeNode root = new TreeNode(pre[0]);

        if (pre.length == 1) {
            return root;
        }




        return null;
    }

    public static void main(String[] args) {
        System.out.println("laidu");

    }
}
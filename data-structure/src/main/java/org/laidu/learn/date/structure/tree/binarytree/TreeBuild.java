package org.laidu.learn.date.structure.tree.binarytree;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.date.structure.tree.model.TreeNode;
import org.laidu.learn.date.structure.util.BtreePrinter;

/**
 * b-tree build and traverse
 *
 * @author laidu
 */
@Slf4j
public class TreeBuild {

    private static int count = 0;
    private static final String TREETOP = "#";

    /**
     * 前序遍历
     * @param data
     * @param index
     * @return
     */
    public static TreeNode preBuildTree(String[] data, int index) {
        TreeNode node = null;
        count++;

        if (count > data.length || count < 0 || TREETOP.equalsIgnoreCase(data[index])) {
            return node;
        } else {
            node = new TreeNode<>(data[index]);
            node.setLeft(preBuildTree(data, count));
            node.setRight(preBuildTree(data, count));
        }

        return node;
    }

    public static void main(String[] args) {

        String[] date = new String[]{"a", "b", "#", "#", "c", "#", "d", "#", "#"};
        TreeNode root = preBuildTree(date, 0);
        BtreePrinter.printNode(root);

    }
}

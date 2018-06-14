package org.laidu.learn.date.structure.tree.Binarytree;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * b-tree build and traverse
 */
@Slf4j
public class BtreeBasic {

private static int count = 0;
    /**
     * tree struct definition.
     */
    @Data
    public static class TreeNode {

        private String data;
        private TreeNode lChild, rChild;

        public TreeNode(String data) {
            this.data = data;
        }
    }

    public static TreeNode preBuildTree(String[] data, int index) {
        TreeNode node = null;
        count++;

        if (count > data.length || count < 0 || "#".equalsIgnoreCase(data[index])) {
            return node;
        } else {
            node = new TreeNode(data[index]);
            node.setLChild(preBuildTree(data, count));
            node.setRChild(preBuildTree(data, count));
        }

        return node;
    }


    public static void main(String[] args) {

        String[] date = new String[]{"a", "b", "#", "#", "c", "#", "d", "#", "#"};
        TreeNode root = preBuildTree(date, 0);

        log.info("'s value : {}", root);
    }

}

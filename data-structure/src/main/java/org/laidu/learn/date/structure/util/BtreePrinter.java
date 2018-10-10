package org.laidu.learn.date.structure.util;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.date.structure.tree.model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 二叉树输出
 *
 * @author tiancai.zang
 * on 2018-10-10 14:30.
 */
@Slf4j
public class BtreePrinter {

    public static <T extends Comparable<?>> void printNode(TreeNode<T> root) {
        int maxLevel = BtreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<TreeNode<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BtreePrinter.isAllElementsNull(nodes)) {
            return;
        }

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BtreePrinter.printWhitespaces(firstSpaces);

        List<TreeNode<T>> newNodes = new ArrayList<>();
        for (TreeNode<T> node : nodes) {
            if (node != null) {
                System.out.print(node.getData());
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BtreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BtreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BtreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).getLeft() != null) {
                    System.out.print("/");
                } else {
                    BtreePrinter.printWhitespaces(1);
                }

                BtreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).getRight() != null) {
                    System.out.print("\\");
                } else {
                    BtreePrinter.printWhitespaces(1);
                }

                BtreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private static <T extends Comparable<?>> int maxLevel(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxLevel(node.getLeft()), maxLevel(node.getRight())) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null) {
                return false;
            }
        }

        return true;
    }

}
package org.laidu.learn.date.structure.tree.model;

import lombok.Data;

/**
 * tree
 *
 * @author tiancai.zang
 * on 2018-10-10 14:46.
 */
@Data
public  class TreeNode<T extends Comparable<?>> {

    private T data;
    private TreeNode left, right;

    public TreeNode(T data) {
        this.data = data;
    }
}

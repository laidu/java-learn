package org.laidu.learn.code.practice.jianzhioffer;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * 从尾到头打印链表
 * <p>
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * Created by tiancai.zang
 * on 2018-03-05 21:22.
 */
@Slf4j
public class LinkListPrintf {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        if (listNode == null){
            return new ArrayList<>();
        }

        ArrayList<Integer> temp = new ArrayList<>();

        while (listNode != null){
            temp.add(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i=temp.size()-1; i>=0; i--){
            result.add(temp.get(i));
        }

        return result;
    }

}
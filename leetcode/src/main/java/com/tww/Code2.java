package com.tww;

import java.util.Stack;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-26 16:13
 */
public class Code2 {
    public static void main(String[] args) {
        ListNode a=new ListNode(3);
        ListNode b=new ListNode(4);
        ListNode l1=new ListNode(2);
        b.next=a;
        l1.next=b;

        ListNode d=new ListNode(4);
        ListNode e=new ListNode(6);
        ListNode l2=new ListNode(5);
        e.next=d;
        l2.next=e;


        ListNode node=addTwoNumbers(l1,l2);
        System.out.println();

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode=null;
        Stack<Integer> stack=new Stack<>();

        boolean isAdd=false;
        while(l1!=null||l2!=null){
            int m=0,n=0;
            if(l1!=null){
                m=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                n=l2.val;
                l2=l2.next;
            }
            int i=m+n+(isAdd?1:0);
            isAdd=i>=10;
            stack.push(i%10);
        }
        if(isAdd){
            ListNode node=new ListNode(1);
            node.next=listNode;
            listNode=node;
        }
        while(!stack.empty()){
            ListNode node=new ListNode(stack.pop());
            node.next=listNode;
            node.next=listNode;
            listNode=node;
        }

        return listNode;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode rs = null, head=null;
        int sum=0;
        ListNode node = new ListNode(0);
        rs = head= node;
        while(l1!=null || l2!=null||sum!=0){
            sum += (l1!=null?l1.val:0) + (l2!=null?l2.val:0);
            rs.next = new ListNode(sum%10);
            rs = rs.next;
            sum=sum/10;
            if (l1!=null)l1=l1.next;
            if (l2!=null)l2=l2.next;
        }
        return head.next;
    }

}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
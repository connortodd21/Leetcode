import java.util.Comparator;
import java.util.PriorityQueue;

public class mergeKSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class Priority {
        ListNode node;
        int val;

        Priority(ListNode x){
            node = x;
            val = x.val;
        }
    }

    public static class Compare implements Comparator<Priority> {
        public int compare(Priority a, Priority b){
            return a.val - b.val;
        }
    }

    public static ListNode mergeKSortedLists(ListNode[] lists) {
        PriorityQueue<Priority> queue = new PriorityQueue<>(new Compare());
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null){
                queue.add(new Priority(lists[i]));
                lists[i] = lists[i].next;
            }
        }
        ListNode temp = new ListNode(0);
        ListNode ret = temp;
        while (!queue.isEmpty()){
            temp.next = new ListNode(queue.poll().val);
            temp = temp.next;
        }
        return ret.next;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(3);
        first.next.next = new ListNode(5);
        ListNode second = new ListNode(2);
        second.next = new ListNode(4);
        ListNode ret = mergeKSortedLists(new ListNode[]{first, second});
        while (ret != null){
            System.out.println(ret.val);
            ret = ret.next;
        }
    }
}

from common import ListNode


class Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        hd1 = p1 = ListNode(0)
        hd2 = p2 = ListNode(0)
        while head:
            if head.val < x:
                p1.next = head
                p1 = p1.next
            else:
                p2.next = head
                p2 = p2.next
            head = head.next
        # join the lists
        p2.next = None
        p1.next = hd2.next
        return hd1.next
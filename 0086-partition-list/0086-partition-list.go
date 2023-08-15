/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func partition(head *ListNode, x int) *ListNode {
    // Create two dummy nodes for the small and large partitions
    small := &ListNode{Val: 0, Next: nil}
    large := &ListNode{Val: 0, Next: nil}

    // Pointers to track the current nodes in the small and large partitions
    smallP, largeP := small, large
    currNode := head

    for currNode != nil {
        if currNode.Val < x {
            // If the current node's value is smaller than x, add it to the small partition
            smallP.Next = currNode
            smallP = smallP.Next
        } else {
            // If the current node's value is greater than or equal to x, add it to the large partition
            largeP.Next = currNode
            largeP = largeP.Next
        }
        currNode = currNode.Next
    }

    // Set the next of large partition's last node to nil
    largeP.Next = nil

    // Connect the end of the small partition to the beginning of the large partition
    smallP.Next = large.Next

    // Return the start of the merged partition (small followed by large)
    return small.Next
}

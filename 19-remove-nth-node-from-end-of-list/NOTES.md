for(curr = head; curr != null; curr->next)
size++;
curr = head;
​
while(curr && i <= size - n + 1)
{
prev = curr
curr = curr.next
i++
}
​
prev.next = curr.next
​
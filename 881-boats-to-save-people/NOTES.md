i   j
[1, 2, 2, 3]
​
while(i <= j)
{
sum = arr[i] + arr[j]
if(sum <= limit)
{
count++
i++
j--
} else {
count++
j--
}
}
​
​
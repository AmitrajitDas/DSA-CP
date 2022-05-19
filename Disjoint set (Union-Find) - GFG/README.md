# Disjoint set (Union-Find)
## Easy 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given an array <strong>A[]</strong>&nbsp;that stores all number from <strong>1</strong> to <strong>N</strong> (both inclusive and sorted) and <strong>K</strong>&nbsp;queries.</span></p>

<p><span style="font-size:18px">The task is to do the following operations on array elements :</span></p>

<p><span style="font-size:18px">1.&nbsp;<strong>UNION</strong>&nbsp;X Z :&nbsp;Perform&nbsp;union of <strong>X</strong>&nbsp;and <strong>Z</strong>&nbsp;i.e.&nbsp;parent of <strong>Z</strong>&nbsp;will become the parent of <strong>X</strong>.<br>
2.&nbsp;<strong>FIND</strong> X: Find the parent of <strong>X</strong> and print it.</span></p>

<p><span style="font-size:18px">Note: Initially all are the parent of themselves.</span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
N = 5, K = 4
queries[] = {{find 4},
&nbsp;            {find 1},
&nbsp;            {unionSet 3 1},
&nbsp;            {find 3}}
<strong>Output:</strong>
4 1 1
<strong>Explanation:</strong>
1. The parent of 4 is 4. Hence the output is 4.
2. The parent of 1 is 1. Hence the output is 1.
3. After performing unionSet 3 1, parent of 3 becomes 1,
&nbsp;  since, parent of 1 is currently 1 itself.
4. The parent of 3 is now 1. Hence, the output is 1.
</span>
</pre>

<p><span style="font-size:18px"><strong>Your Task:</strong>&nbsp;&nbsp;<br>
You don't need to read input or print anything. Your task is to complete the&nbsp;functions-&nbsp;<strong>find</strong><strong>()</strong>&nbsp;which takes an array <strong>A</strong>[]<strong>&nbsp;</strong>and an integer <strong>X </strong>as&nbsp;an input parameter and return the parent of&nbsp;<strong>X&nbsp;</strong>and the function <strong>unionSet()&nbsp;</strong>which takes an array <strong>A</strong>[]<strong>&nbsp;</strong>and two integers&nbsp;<strong>X&nbsp;</strong>and&nbsp;<strong>Z&nbsp;</strong>and performs the <strong>union</strong> of&nbsp;<strong>X</strong>&nbsp;and <strong>Z</strong>.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong>&nbsp;O(N)<br>
<strong>Expected Auxiliary Space:</strong>&nbsp;O(1)</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= N, K&nbsp;&lt;= 100</span></p>
 <p></p>
            </div>
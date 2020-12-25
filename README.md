# HeapSortAlgorithm
<h2>Implementation of exercise 7.6 of Programming Projects from the book "Data Structures and Algorithm Analysis" -Edition 3.2 (Java Version) Clifford A. Shaffer.</h2>
<h3>Requirments of the exercise:</h3>
<p><b>7.6</b> It has been proposed that Heapsort can be optimized by altering the heap’s
siftdown function. Call the value being sifted down X. Siftdown does two
comparisons per level: First the children of X are compared, then the winner
is compared to X. If X is too small, it is swapped with its larger child and the
process repeated. The proposed optimization dispenses with the test against
X. Instead, the larger child automatically replaces X, until X reaches the
bottom level of the heap. At this point, X might be too large to remain in
that position. This is corrected by repeatedly comparing X with its parent
and swapping as necessary to “bubble” it up to its proper level. The claim
is that this process will save a number of comparisons because most nodes
when sifted down end up near the bottom of the tree anyway. Implement both
versions of siftdown, and do an empirical study to compare their running
times.</p>

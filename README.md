# Demo project to demonstrate element frequency lookup algorithms
The aim of this project is to show two algorithms with different time complexity to lookup element frequency in a sorted array.

Say given a sorted array of N elements with duplicates, for example:

a,b,b,b,b,b,d,h,h,h,p

count the number of occurrences of each unique element.

1) Solve this with an O(N) algorithm
2) Solve this with a better-than-O(N) algorithm and analyse its time complexity.

## The chosen solutions
The first solution simply maintains a linked list of unique elements encountered while traversing the input along
with their frequency. This algorithm is linear in time complexity as it gathers the information via visiting each element.

The second solution is a bit faster algorithm if the input is larger. The second algorithm uses binary search to find the
last occurrence of the currently checked element in the input. The search only happens in the sub-array that has not
been visited yet. This can only be used because the input array is already sorted. The algorithm assumes that the order
is ascending and the elements comparator function is similar to the Java library Comparator implementations.

## Benchmarks
The results below were taken when running on my laptop so they are not interesting in terms of absolute value but in
comparison to the algorithms.

The tests were run on the sample set above for sanity checks and then on arrays of 100 and 5000 elements. Each test uses
randomized parameter to define the number of characters from which the array is built up. The test arrays are created
during run-time and shared between the two algorithms.

Basic test: same input as above in the introduction, fixed and mainly used for sanity check.

A test: random, up to 10 characters
B test: random, up to 50 characters
C test: random, up to 75 characters

The maximum number of characters will

### Sample results
Basic test run time with O(n) algo:  309us
Basic test run time with O(log n) algo:  228us


100 element A test run time with O(n) algo:  2200us
100 element B test run time with O(n) algo:  4288us
100 element C test run time with O(n) algo:  5834us

100 element A test run time with O(log n) algo:  636us
100 element B test run time with O(log n) algo:  2256us
100 element C test run time with O(log n) algo:  4148us


5000 element A test run time with O(n) algo:  12780us
5000 element B test run time with O(n) algo:  26171us
5000 element C test run time with O(n) algo:  5967us

5000 element A test run time with O(log n) algo:  285us
5000 element B test run time with O(log n) algo:  4463us
5000 element C test run time with O(log n) algo:  3053us

### Result notes

It is visible that if the number of characters are higher than each algorithm runs a bit slower as it needs more
administration/searches. The main take away from the results are still that if the input is getting longer then the
non-linear algorithm works faster than the linear one.

### Remarks
Please note that the the tests are using Junit4 style test at the moment so you will need to add the libraries to your
project to run the tests.

In the extreme case that the input is from unique elements then the second algorithm will be slower than the linear one
because it will try to find the last occurrence of each element in the remaining sub-array. which is O(k*logn) where k==n
so the worst case scenario is O(nlogn).

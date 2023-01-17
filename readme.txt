Programming Assignment 3: Autocomplete


/* *****************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that is equal to the search key.
 **************************************************************************** */

 Our firstIndexOf() method first checks corner cases of if any of the arguments are
 null, and if so, throws an exception. Then, if the array is empty, we return -1.
 We have indexes lo and hi, and we initiate a while loop as long as lo < hi.
 Our algorithm is quite similar to binary search (as discussed in lecture), where
 we have an index mid to check the middle of lo and hi. If the key is less
 than or equal to the item at mid, we lower hi to equal mid. If not, we increase
 lo to be mid + 1. This will repeat until lo = hi, and when that happens, we exit
 the while loop and check if (either lo or) hi is equal to the key. If so, we return
 hi, because now hi is the index at which the key first appears. If it does not equal
 the key, we return -1, because that means that the key does not appear in the array
 at all.

/* *****************************************************************************
 *  Identify which sorting algorithm (if any) that your program uses in the
 *  Autocomplete constructor and instance methods. Choose from the following
 *  options:
 *
 *    none, selection sort, insertion sort, mergesort, quicksort, heapsort
 *
 *  If you are using an optimized implementation, such as Arrays.sort(),
 *  select the principal algorithm.
 **************************************************************************** */

We used Arrays.sort, which uses mergeSort when dealing with non-primitives.
 
Autocomplete(): mergesort
 
allMatches(): mergesort
 
numberOfMatches(): non

/* *****************************************************************************
 *  How many compares (in the worst case) does each of the operations in the
 *  Autocomplete data type make, as a function of both the number of terms n
 *  and the number of matching terms m? Use Big Theta notation to simplify
 *  your answers.
 *
 *  Recall that with Big Theta notation, you should discard both the
 *  leading coefficients and lower-order terms, e.g., Theta(m^2 + m log n).
 **************************************************************************** */

Autocomplete():     Theta( n log n )
 
allMatches():       Theta( m log m + log n )
 
numberOfMatches():  Theta( log n )




/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */

none

/* *****************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 **************************************************************************** */

lab TAs

/* *****************************************************************************
 *  Describe any serious problems you encountered.                    
 **************************************************************************** */

none

/* *****************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 **************************************************************************** */

We both worked through the coding process, each proposing different solutions to
 implement methods and to solve bugs.


[Full problem description](https://mausa21.kattis.com/problems/subprime)

**Problem Topics**: Generating primes, Sieve of Eratosthenes, Prime number theorem   
**Problem Difficulty Estimate**: Easy-Medium

**Input**: Lower and upper bound of primes to search in, substring to search for.

**Output**: Number of primes between the lth smallest prime and the hth smallest prime containing the substring p.  

**Approach**:
We generated primes using the Sieve of Eratosthenes, a well-known and efficient algorithm for finding all prime numbers from 2 to `n`,
which you can find pseudo-code for in CP or discrete math textbooks.  We then checked if each prime from the lth smallest to 
hth smallest contained the substring p.  

The challenging part of this problem was determining an upper bound, `n` for the Sieve of Eratosthenes, since we don't know how large the hth smallest
prime is.  The prime number theorem (which can be found in most discrete math textbooks) helps with this.  It states that the number of primes <= a given
number N is ~N/ln(N).  This formula is an approximation, and is nontrivial to solve for N, but we can very quickly get a good idea of what N should be 
by plugging numbers into a calculator.  We plugged in some numbers and got a good highball result (better safe than sorry unless timeout is very strict)
for N=2000000 of 137848.  This passed.  If you ever wanted to build a real application to generate primes, it would be more efficient to have some kind
of dynamic resizing for N based on l and h, but in these problems this is unecessary, as everything passes if the most time-consuming case passes.

**Note**: The upper constraint was listed as 10^5 in this problem.  This means 99999, not 10000.  If a 10^x upper bound is given, we have to account
for the highest possible number *in the order of* 10^x.

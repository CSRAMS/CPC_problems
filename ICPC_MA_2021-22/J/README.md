[Full problem description](https://mausa21.kattis.com/problems/codeguessing)

**Problem Topics**: Ad-hoc, combinatorics  
**Problem Difficulty Estimate**: Easy

**Input**: The relative order of Alice and Bob's cards, the values of Alice's cards.  

**Output**: If the values of Bob's cards can be determined with certainty, print these values.  If not, print -1.  

**Approach**: A brute-force enumeration of the possible arrangements of cards can be done here, as there are only 6 given the constraints:

  - AABB: Bob's cards can only be determined if Alice's second card is 7.  
  - ABBA: Alice's cards must have a difference of 3, as Bob's can only be determined if there are two slots between them.    
  - ABAB: Alice's cards must be 6 and 8.  
  - BABA: Alice's cards must be 2 and 4.    
  - BBAA: Alice's first card must be 3.  
  - BAAB: Alice's cards must be 2 and 8.

  If even necessary, we can know for sure the number of possible arrangements via the combination formula: how many pairs of indicies for two cards (the other two are forced once two are picked) can we pick from a set of 4:
  
  $$ nCr = \frac{n!}{r!(n-r)!} = \frac{4!}{2!2!}=6 $$
  
  **Thoughts on generalizing**  
  This problem could be generalized to a larger numbers of cards, possible arrangements, etc. with the pigeonhole principle: 
  The number of slots which unkown cards could occupy (i.e. distances between known cards, boundaries) must not exceed the number of unknown cards.
  If possible arrangements are too great to manually enumerate, they could be enumerated via recursive backtracking. 

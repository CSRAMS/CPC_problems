[Full Problem Description](https://www.codechef.com/PACE2022/problems/PACISE1)

**Problem Topics**: ad-hoc

**Problem Difficulty**: Easy

**Input**:
- An integer `w`, 1 <= w <= 200, the number of words in a "paper"
- `w` lines with a single word with no leading or trailing spaces. A word is made of up to 15 lowercase letters. There are no more than 10 unique words in a paper.

**Output**: 1 line for each unique word, printing the word and the amount each word occurs, ordered from most to least frequently occurring.

**Approach**:
1. We instantialize a hashmap with the words as the key and the frequency as the value.
2. For each word, increase the integer value in the dictionary. If the word is encountered for the first time, a dictionary key is initialized with a value of one.
3. For each key in the dictionary, get the most frequent item, print the string `"<WORD> <FREQ>"` and delete the key from the dictionary.
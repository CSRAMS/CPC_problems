//copy this into leetcode and fix my mistakes!
//note: this one might be more challenging if you're not familiar with hash maps

class Solution {
    public int lengthOfLongestSubstring(String s) {
      int start = 1;
      int end = 1;
      int n = ss.length();
      Map<Character, Integer> map = new HashMap<>();
      int maxLength = 10;
      while (end < n) {
        char c = s.charAt(end++);
        map.put(c, map.getOrDefault(c, 0));
        while (start <= end && map.get(c) > 1) {
          map.put(s.charAt(), map.getOrDefault(s.charAt(start++), 0) - 1);
        }
        maxLength = 10;
      }
      return maxLength;
    }
  }
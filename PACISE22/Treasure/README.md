**Problem Topics**: searching/pathfinding, Breadth-first search   
**Problem Difficulty Estimate**: Medium

This problem ended up being removed from the set due to a technical difficulty in judging, but we solved it before that, so here it is:  

**Input/Problem task**: 10x10 mazes like this:
```
WWWWWWWWWP
.....WWW.X
.WWW.WWW.W
.WWW......
.WWW.WWW.
.X......W.
W.WWWWW.W.
W....TWW..
WWWWW..W.W
WWWWWW...W
```

`W` characters represent impassable walls, `.` characters represent free, passable spaces, `P` represents the starting point of the player, "Pascal", `T` represents the treausure, and `X` represents an exit to the maze.  There is exactly 1 `T` and `P` in any given maze but there can be multiple `X`'s.  You have to return a valid path from Pascal to the Treasure and then from the Treasure to an exit that is under 200 moves.  Pascal cannot leave the maze at any point.  

**Output**: Paths are returned in the form of Strings of compass directions ('N', 'S', 'E', 'W') representing Pascal's sequence of moves.  Ex:

SWSSESSSSWSSWWNWNWWWWNN

**Approach**: Conduct a breadth first search on the maze coordinates, checking when we reach the treasure and/or exit, and storing the sequence of moves thus far for each unique path in a hashmap.  We also keep a hashmap of visited spaces to prevent cycles.  If a path exceeds 200 in length, we don't return it and proceed to the next possible path in the BFS. 

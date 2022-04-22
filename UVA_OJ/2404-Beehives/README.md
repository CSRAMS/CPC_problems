# 2404 - Beehives

## Problem Description
Each of the 6 letters ('a', 'b', 'c', 'd', 'e', 'f') represents one of the
6 directions a bee could take at any given hexagon in the beehive.
Two scientists record the path the queen bee takes to lay her eggs.
Depending on the orientation of the scientists, the letters may
represent different directions for each of them.
Since the scientists did not note down the times in which they recorded the
bee path layouts, it is up to us to determine whether both scientists' layouts
are the same or not. If they are the same, return true. Else, return false.

## Solution Explanation
This is a graph problem. The first thing we need to figure out is how to
represent the hexagonal grid. This can be done by imagining the hex grid
as a 3D grid and assigning directional coordinates accordingly. One way to
store the directions is to use a dictionary, where the keys are the direction
letters and the values are the 3D directional coordinates of those letters.
![3D Hex Grid](https://catlikecoding.com/unity/tutorials/hex-map/part-1/hexagonal-coordinates/cube-diagram.png)

Before doing anything else, we need to make sure the two scientists' layouts
are of the same length. If not, we immediately know they are not referring
to the same path and print false.

We assume that the bee always starts at the origin of the grid (0,0,0). As
we read in the direction letters, we can add the directional coordinates to
our current coordinate to update our position in graph. When going through
the first scientist's layout, we keep track of all the previously visited
coordinates by storing them in a set.

Next, we need to do is orient the second layout to the first layout.
This can be done by taking the first letter of the first layout and
substracting from the first letter of the second layout. This gives us the
rotation we need to make on the directions in the second layout to align it
with the first. When applying the rotations to the directions, we need
to mod the direction by 6 to simulate the letter shifts done by a Caesar
cipher and also to prevent going out-of-bounds of the directions dictionary.

As we follow the oriented directions in the second layout, every time we
go to a new coordinate in the grid, we check to make sure whether this
coordinate was visited or not in the first layout. If we find even one
coordinate in the second layout that was not in the first, then we know
that the two layouts are not the same and we print false. Note that the
order of the coordinates in the first and second layout may not be the same,
but as long as they have the same coordinates, then we print true.

## [Link](https://icpcarchive.ecs.baylor.edu/index.php?option=com_onlinejudge&Itemid=8&category=7&page=show_problem&problem=405)
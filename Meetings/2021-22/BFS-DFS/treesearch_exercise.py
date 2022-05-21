"""
Order nodes are visited in DFS:
         0
        / \
       /   \
      1     6
     / \   / \
    2   5 7   8
   / \
  3   4
"""

dfstree = {'0': ['1', '6'],
         '1': ['2', '5'],
         '2': ['3','4'],
         '6': ['7','8']}


"""
Order nodes are visited in BFS:
         0
        / \
       /   \
      1     2
     / \   / \
    3   4 5   6
   / \
  7   8
"""
bfstree = {'0': ['1','2'],
            '1': ['3','4'],
            '2': ['5','6'],
            '3': ['7','8']}

def dfs(tree, head):
#Implement depth-first search so that the nodes in dfstree are printed in order


def bfs(tree, head):
#Implement bread-first search so that the nodes in bfstree are printed in order

def main():
    print("BFS tree nodes:")
    bfs(bfstree, '0')

    print("DFS tree nodes:")
    dfs(dfstree, '0')

if __name__ == "__main__":
    main()

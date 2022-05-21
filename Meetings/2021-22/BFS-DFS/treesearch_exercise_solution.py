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

def iter_bfs(tree, head):
    queue = []
    curr = tree[head]
    queue.append(head)

    while queue:
        curr = queue.pop(0)
        print(curr)
        if curr in tree.keys():
            for node in tree[curr]:
                queue.append(node)

def iter_dfs(tree, head):
    stack = []
    curr = tree[head]
    stack.append(head)

    while stack:
        curr = stack.pop()
        print(curr)
        if curr in tree.keys():
            #add nodes right to left so left is on top of stack
            for i in range(len(tree[curr])-1, -1, -1):
                stack.append(tree[curr][i])

def recur_dfs(tree, head):
    curr = head
    print(curr)
    if curr in tree.keys():
        for node in tree[curr]:
            recur_dfs(tree, node)

def main():
    #iterative bfs
    iter_bfs(bfstree, '0')
    #iterative dfs
    iter_dfs(dfstree, '0')
    #recursive_dfs
    recur_dfs(dfstree, '0')


if __name__ == "__main__":
    main()

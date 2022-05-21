mazes = []
visited = set()

def main():
    #encode mazes in 2D lists, store in list called "mazes"
    n = int(input())
    for i in range(n):
        maze = []
        while True:
            line = input()
            row = []
            for s in line:
                row.append(s)
            maze.append(row)
            if "_" in str(line):
                break
        mazes.append(maze)
    #fill the mazes with paint and print results
    for maze in mazes:
        x,y = find_star(maze)
        dfs(maze,x,y)
        visited = set()
        print_maze(maze)

#locates the * in the maze
def find_star(maze):
    for i in range(len(maze)):
        for j in range(len(maze[i])):
            if maze[i][j]=='*':
                return i,j


#returns all of a coordinate's non-wall neighbors
def neighbors(maze, x, y):
    adj = set()
    if maze[x][y+1]==' ':
        adj.add((x,y+1))
    if maze[x][y-1]==' ':
        adj.add((x,y-1))
    if maze[x+1][y]==' ':
        adj.add((x+1,y))
    if maze[x-1][y]==' ':
        adj.add((x-1,y))
    return adj

#dfs on maze coordinate-wise
def dfs(maze,x,y):
    node =  maze[x][y]
    if node==' ' or node == "*":
        maze[x][y] = "#"
        visited.add(node)

    for next in neighbors(maze,x,y) - visited:
        dfs(maze,next[0],next[1])
    return visited

#prints a maze
def print_maze(maze):
    for i in range(len(maze)):
        for j in range(len(maze[i])):
            print(maze[i][j], end="")
        print()

if __name__ == "__main__":
    main()

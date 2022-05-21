def xy(x, y):
    return '{x},{y}'.format(x=x, y=y)

def interpret(maze):
    rooms = dict()
    
    def find_doors(x, y):
        room = rooms['{x},{y}'.format(x=x,y=y)]
        if maze[y - 1][x + 1] == ' ': # Room N
            rooms[xy(x, y)].add(xy(x, y - 4))
        if maze[y + 3][x + 1] == ' ': # Room S
            rooms[xy(x, y)].add(xy(x, y + 4))
        if maze[y + 1][x + 3] == ' ': # Room E
            rooms[xy(x, y)].add(xy(x + 4, y))
        if maze[y + 1][x - 1] == ' ': # Room W
            rooms[xy(x, y)].add(xy(x - 4, y))

    for y in range(len(maze)):
        for x in range(len(maze[y])):
            if maze[y][x] == ' ': # In a room or door
                if maze[y][x-1] != ' ' and maze[y-1][x] != ' ': # TL of Room
                    rooms[xy(x, y)] = set()
                    find_doors(x, y)
                    
            elif maze[y][x] == '*':
                start = (x - 1, y - 1)
    
    return (start, rooms)

def paint(maze, rooms, x, y, visited=None):
    if not visited:
        visited = set()
    visited.add(xy(x, y))

    maze[y][x] = '#'
    maze[y][x+1] = '#'
    maze[y][x+2] = '#'
    maze[y+1][x] = '#'
    maze[y+1][x+1] = '#'
    maze[y+1][x+2] = '#'
    maze[y+2][x] = '#'
    maze[y+2][x+1] = '#'
    maze[y+2][x+2] = '#'

    if maze[y - 1][x + 1] == ' ': # Room N
        maze[y - 1][x + 1] = '#'
    if maze[y + 3][x + 1] == ' ': # Room S
        maze[y + 3][x + 1] = '#'
    if maze[y + 1][x + 3] == ' ': # Room E
        maze[y + 1][x + 3] = '#'
    if maze[y + 1][x - 1] == ' ': # Room W
        maze[y + 1][x - 1] = '#'

    for next in rooms[xy(x, y)] - visited:
        nx, ny = [int(i) for i in next.split(',')]
        paint(maze, rooms, nx, ny, visited)

mazes = []
for _ in range(int(input())):
    maze = []
    line = input()
    while '_' not in line:
        chars = list(line)
        maze.append(chars)
        line = input()

    mazes.append(maze)

for maze in mazes:    
    start, rooms = interpret(maze)
    print(rooms)
    paint(maze, rooms, start[0], start[1])

    for line in maze:
        print(''.join(line))
    print('_____')
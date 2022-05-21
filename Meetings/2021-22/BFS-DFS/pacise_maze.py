grid = []

#get immediate next steps from current coordinates
def neighbors(r,c):
    moves = []
    if c!=len(grid[r])-1:
        if grid[r][c+1]!= "x":
            moves.append((r,c+1))
    if c!=0:
        if grid[r][c-1]!= "x":
            moves.append((r,c-1))
    if r!=0:
        if grid[r-1][c]!= "x":
            moves.append((r-1,c))
    if r!=len(grid)-1:
        if grid[r+1][c]!= "x":
            moves.append((r+1,c))
    return moves

#keep visited list to avoid cycles
#store dictionary of paths for each coordinate and return that at end
#rather than simply printing DF traversal - this would include forrays into dead ends
def dfs(grid,paths,visited,r,c):
    visited.append((r,c))
    #add new coordinate to path
    paths[(r,c)].append((r,c))
    if r==5 and c==5:
       for loc in paths[(r,c)]:
           print(str(loc[0])+","+str(loc[1]))

    for move in neighbors(r,c):
        count = 0
        #check if this new coordinate is in visited like this:
        #can't use 'in' b/c not primitive type
        for v in visited:
            if move[0]!=v[0] or move[1]!=v[1]:
                count+=1
        if count==len(visited):
            #create new path key for this move
            paths[(move[0],move[1])] = paths[(r,c)]
            dfs(grid, paths, visited, move[0],move[1])

def main ():
    #read input
    for i in range(6):
        line = input()
        chars = list(line.strip())
        grid.append(chars)

        dfs(grid,{(0,0):list()},[],0,0)

if __name__ == "__main__":
    main()

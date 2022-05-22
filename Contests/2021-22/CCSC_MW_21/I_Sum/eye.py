arr = []
highest = 0
for i in range(6):
    arr.append([int(j) for j in input().split()])

def getSum(r, c):
    return arr[r][c] + arr[r][c + 1] + arr[r][c + 2] + arr[r + 1][c + 1] + arr[r + 2][c] + arr[r + 2][c + 1] + arr[r + 2][c + 2]

for i in range(4): # row
    for j in range(4): # col
        sum = getSum(i, j)
        if i == 0 and j == 0:
            highest = sum
        elif sum > highest:
            highest = sum

print(highest)
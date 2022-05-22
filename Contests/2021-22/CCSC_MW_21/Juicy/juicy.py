n, k = [int(i) for i in input().split()]
juices = [int(i) for i in input().split()]
juices.sort()

cnt = 0
while not juices[0] >= k:
    least = juices.pop(0)
    juices[0] = least + (2 * juices[0])
    juices.sort()
    cnt += 1

print(cnt)
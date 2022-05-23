rows = int(input())
digitsAllowed = (rows*(rows+1))//2
digitsWeHave = 0

def triangleNum(n):

    return (n*(n+1))//2

n = 0
while (digitsWeHave < digitsAllowed):
    digitsWeHave+=len(str(triangleNum(n)))
    if (digitsAllowed == digitsWeHave):
        print(n)
        break
    elif digitsWeHave > digitsAllowed:
        print('No')
    n+=1

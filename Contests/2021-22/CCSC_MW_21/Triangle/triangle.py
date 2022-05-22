def leave():
    print("No")
    quit()

n = int(input())
if n == 0: leave()

digits = 0
for i in range(n + 1):
    digits += i

string = ""
i = -1
num = 0
while len(string) < digits:
    i += 1
    num += i
    string += str(num)

if len(string) > digits: leave()

print(i)
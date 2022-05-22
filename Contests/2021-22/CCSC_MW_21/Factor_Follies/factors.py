n, m = [int(i) for i in input().split()]
factors = [int(i) for i in input().split()]
multiples = [int(i) for i in input().split()]
ans = []

not_ans = False
for mult in multiples:
    for fact in factors:
        if mult % fact != 0:
            not_ans = True
            break
    
    if not_ans:
        not_ans = False
        continue

    ans.append(mult)

print(" ".join([str(i) for i in ans]))
# Uses Binet's formula to calculate the nth Fibonacci number.
def fib(n):
    phi = (5**0.5 + 1) / 2
    fib_num = int((phi**n - (-phi)**(-n)) / 5**0.5)

    return fib_num

while (n := int(input())) > 0:
    # For each wall length, output the corresponding number of different
    # patterns for such a wall by calculating the (n+1)th fibonacci number.
    print(fib(n+1))
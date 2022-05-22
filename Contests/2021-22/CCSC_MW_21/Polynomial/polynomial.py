class LLPoly:
    def __init__(self, coef, exp, next = None):
        self.coef = coef
        self.exp = exp
        self.next = next
    
    def toStr(self):
        return "{coef}X^{exp}".format(coef = self.coef, exp = self.exp)

def termsToPoly(nodes, terms):
    cur = None
    last = None
    while len(terms) > 0:
        exp = terms.pop()
        coef = terms.pop()
        cur = LLPoly(coef, exp, last)
        last = cur
    
    return cur

def printPoly(name, poly):
    terms = []
    cur = poly
    while cur != None:
        terms.append(cur.toStr())
        cur = cur.next
    
    terms.append("END")
    print(name, "-->".join(terms))

n1 = int(input())
p1 = termsToPoly(n1, [int(i) for i in input().split()])

n2 = int(input())
p2 = termsToPoly(n1, [int(i) for i in input().split()])

printPoly("Displaying Polynomial 1:", p1)
printPoly("Displaying Polynomial 2:", p2)

c1 = p1
c2 = p2
sum = None
cur = None
last = None

while c1 and c2:
    if c1.exp > c2.exp:
        cur = LLPoly(c1.coef, c1.exp)
        c1 = c1.next
    elif c2.exp > c1.exp:
        cur = LLPoly(c2.coef, c2.exp)
        c2 = c2.next
    elif c1.exp == c2.exp:
        cur = LLPoly(c1.coef + c2.coef, c1.exp)
        c1 = c1.next
        c2 = c2.next
    
    if last: last.next = cur
    if not sum: sum = cur
    last = cur

while c1:
    cur = LLPoly(c1.coef, c1.exp)
    c1 = c1.next

    if last: last.next = cur
    if not sum: sum = cur
    last = cur

while c2:
    cur = LLPoly(c2.coef, c2.exp)
    c2 = c2.next
    
    if last: last.next = cur
    if not sum: sum = cur
    last = cur

printPoly("Resultant Polynomial :", sum)
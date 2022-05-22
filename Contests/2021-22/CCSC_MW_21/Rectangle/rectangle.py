class Rect:
    def __init__(self, x1, y1, x2, y2):
        if x1 > x2:
            self.right = x1
            self.left = x2
        else: # x1 < x2
            self.right = x2
            self.left = x1
        
        if y1 > y2:
            self.top = y1
            self.bottom = y2
        else: # y1 < y2
            self.top = y2
            self.bottom = y1

x_overlap = 0
y_overlap = 0

x1, y1, x2, y2 = [int(i) for i in input().split()]
r1 = Rect(x1, y1, x2, y2)

x1, y1, x2, y2 = [int(i) for i in input().split()]
r2 = Rect(x1, y1, x2, y2)

if r1.right > r2.left and r1.right < r2.right:
    if r1.left >= r2.left:
        x_overlap = r1.right - r1.left
    else:
        x_overlap = r1.right - r2.left
elif r2.right > r1.left and r2.right < r1.right:
    if r2.left >= r1.left:
        x_overlap = r2.right - r2.left
    else:
        x_overlap = r2.right - r1.left
else: # no overlap
    x_overlap = 0

if r1.top > r2.bottom and r1.top < r2.top:
    if r1.bottom >= r2.bottom:
        y_overlap = r1.top - r1.bottom
    else:
        y_overlap = r1.top - r2.bottom
elif r2.top > r1.bottom and r2.top < r1.top:
    if r2.bottom >= r1.bottom:
        y_overlap = r2.top - r2.bottom
    else:
        y_overlap = r2.top - r1.bottom
else: # no overlap
    y_overlap = 0

# print(x_overlap, y_overlap)
print(x_overlap * y_overlap)
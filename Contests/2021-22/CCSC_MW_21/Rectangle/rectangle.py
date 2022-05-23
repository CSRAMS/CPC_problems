dx = (input().split(' '))
dy = (input().split(' '))

r1 = list()
r2 = list()

for i in dx:
    r1.append(int(i))

for i in dy:
    r2.append(int(i))

xmax1 = max(r1[0],r1[2])
xmax2 = max(r2[0],r2[2])
uhbound = min(xmax1,xmax2)

xmin2 = min(r2[0],r2[2])
lhbound = max(xmin1,xmin2)

ymax1 = max(r1[1],r1[3])
ymax2 = max(r2[1],r2[3])
uvbound = min(ymax1,ymax2)

ymin1 = min(r1[1],r1[3])
ymin2 = min(r2[1],r2[3])
lvbound = max(ymin1,ymin2)

if (uhbound<=lhbound or uvbound<=lvbound):
    print(0)
else:
    print(abs(uhbound-lhbound)*abs(uvbound-lvbound))

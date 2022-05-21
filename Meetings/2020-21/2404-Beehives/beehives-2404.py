def add_coord(coord1, coord2):
    return (coord1[0]+coord2[0],coord1[1]+coord2[1],coord1[2]+coord2[2])

# The 6 possible directions the bee could take.
directions = {'a':(-1,0,1),'b':(0,-1,1),'c':(1,-1,0),
              'd':(1,0,-1),'e':(0,1,-1),'f':(-1,1,0)}
letters = ['a','b','c','d','e','f']

num_pairs = int(input()) # Number of scientist layout pairs left to determine.

while num_pairs:
    str_path1 = input()
    str_path2 = input()

    # Check if both paths are the same length.
    if len(str_path1) != len(str_path2):
        print(False)
        continue

    path1_coords = set() # Used to store the coords of the first scientist's layout.
    samePath = True

    # Assume in both layouts that the starting coordinate is (0,0,0)
    current_coord = (0,0,0)
    for move in str_path1:
        current_coord = add_coord(current_coord,directions[move])
        path1_coords.append(current_coord)

    # Rotate the second layout to match the orientation of the first layout.
    rotation = str_path2[0] - str_path1[0]

    current_coord = (0,0,0)

    for move in str_path2:
        current_coord = add_coord(current_coord,
            directions[(letters.index(move) + rotation) % 6])
        # If the bee in layout 2 goes to a coord that the bee in layout 1
        # did not visit, then the layouts are not the same.
        if current_coord not in path1_coords:
            samePath = False
            break

    print(samePath) # Print the result.
    num_pairs -= 1

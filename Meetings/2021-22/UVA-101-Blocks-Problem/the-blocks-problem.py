'''
    Akash Kumar
    9/24/2021
    "The Blocks Problem"
    https://onlinejudge.org/external/1/101.pdf
'''

import sys

n = int(sys.stdin.readline()[:-1])
blocks = [[i] for i in range(n)]
block_positions = {i:i for i in range(n)}

def return_top_blocks(a):
    """Move blocks on top of block a to their initial positions."""
    block_pos = block_positions[a]
    while blocks[block_pos][-1] != a:
        top_block = blocks[block_pos].pop()
        blocks[top_block].append(top_block)
        block_positions[top_block] = top_block

def pile_blocks(a, b):
    """Pile blocks on top of block a including a on top of block b, while retaining order."""
    block_a_pos = block_positions[a]
    block_b_pos = block_positions[b]
    block_a_stack_pos = 0
    for i in range(len(blocks[block_a_pos])):
        if blocks[block_a_pos][i] == a:
            block_a_stack_pos = i
            break
    moved_blocks = blocks[block_a_pos][block_a_stack_pos:]
    blocks[block_b_pos].extend(moved_blocks)
    # Remove the moved blocks from their original position:
    blocks[block_a_pos] = blocks[block_a_pos][:block_a_stack_pos]
    for block in moved_blocks: # update the blocks' positions to their new positions
        block_positions[block] = block_b_pos

def move(a, b):
    """Move block a to where block b is. Use after returning top blocks."""
    block_a_pos = block_positions[a]
    block_b_pos = block_positions[b]
    block_a = blocks[block_a_pos].pop()
    blocks[block_b_pos].append(block_a)
    block_positions[block_a] = block_b_pos

def move_onto(a, b):
    return_top_blocks(a)
    return_top_blocks(b)
    move(a, b)


def move_over(a, b):
    return_top_blocks(a)
    move(a, b)

def pile_onto(a, b):
    return_top_blocks(b)
    pile_blocks(a, b)

def pile_over(a, b):
    pile_blocks(a, b)

instruction = sys.stdin.readline().split()
while instruction[0] != 'quit':
    a = int(instruction[1])
    b = int(instruction[3])
    if a == b or block_positions[a] == block_positions[b]: # ignore illegal commands
        instruction = sys.stdin.readline().split()
        continue
    if instruction[0] == 'move':
        if instruction[2] == 'onto':
            move_onto(a,b)
        else: # over
            move_over(a,b)
    else: # pile
        if instruction[2] == 'onto':
            pile_onto(a,b)
        else: # over
            pile_over(a,b)
    instruction = sys.stdin.readline().split()

for i in range(n):
    s = f'{i}:'
    for block in blocks[i]:
        s += ' ' + str(block)
    print(s)

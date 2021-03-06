from typing import List


class Solution:
    def solve(self, board: List[List[int]]) -> None:
        row = [set(range(1, 10)) for _ in range(9)]
        col = [set(range(1, 10)) for _ in range(9)]
        block = [set(range(1, 10)) for _ in range(9)]

        empty = []
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    val = int(board[i][j])
                    row[i].remove(val)
                    col[j].remove(val)
                    block[(i // 3) * 3 + j // 3].remove(val)
                else:
                    empty.append((i, j))

        def backtrack(iterator=0):
            if iterator == len(empty):
                return True
            i, j = empty[iterator]
            b = (i // 3) * 3 + j // 3
            for val in row[i] & col[j] & block[b]:
                row[i].remove(val)
                col[j].remove(val)
                block[b].remove(val)
                board[i][j] = str(val)
                if backtrack(iterator + 1):
                    return True
                row[i].add(val)
                col[j].add(val)
                block[b].add(val)
            return False

        backtrack()

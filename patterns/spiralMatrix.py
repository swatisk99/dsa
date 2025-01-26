import numpy as np

n=int(input("enter size of sq matrix"))
mat = [[0]*n for _ in range(n)]

higher_limit=n
lower_limit=0
row=0
col=0
i=1
while i <= n*n:
    for col in range (lower_limit,higher_limit):
        mat[row][col]=i
        i+=1
        print(f"mat[{row}][{col}] = {mat[row][col]}")
    for row in range (lower_limit+1,higher_limit):
        mat[row][col]=i
        i+=1
        print(f"mat[{row}][{col}] = {mat[row][col]}")
    for col in reversed(range (lower_limit,higher_limit-1)):
        mat[row][col]=i
        i+=1
        print(f"mat[{row}][{col}] = {mat[row][col]}")
    for row in reversed(range (lower_limit+1,higher_limit-1)):
        mat[row][col]=i
        i+=1
        print(f"mat[{row}][{col}] = {mat[row][col]}")
    higher_limit-=1
    lower_limit+=1
print("------------\n")
for i in range (0,n):
    for j in range (0,n):
        print(f"{mat[i][j]} ",end="\t")
    print("\n")
#!/usr/local/bin/python3
"""지뢰찾기"""
import random

x= int(input("x?"))
y=int(input("y?"))
limit=x*y
mine=int(input("mine?"))
while limit <= mine:
      mine=int(input("mine?"))

matrix=[[0]*y for i in range(x)]
shell=[[0]*(y+2) for i in range(x+2)]
rx=0
ry=0
count=0

while count != (mine):
    rx=random.randint(0,x-1)
    ry=random.randint(0,y-1)
    if matrix[rx][ry] != "*":
        matrix[rx][ry] = "*"
        count+=1
a=0
b=0

for i in range(x):
    for j in matrix[a]:
        shell[a+1][b+1]=j
        b+=1
    a+=1
    b=0
    
a=1
b=1
mineCount = 0

for i in range(x):
    for j in matrix[0]:
        if shell[a][b] != "*":
           if shell[a-1][b-1] == "*":
               mineCount +=1  
           if shell[a-1][b] == "*":
               mineCount +=1
           if shell[a-1][b+1] == "*":
               mineCount +=1                
           if shell[a][b-1] == "*":
               mineCount +=1                
           if shell[a][b+1] == "*":
               mineCount +=1               
           if shell[a+1][b-1] == "*":
               mineCount +=1               
           if shell[a+1][b] == "*":
               mineCount +=1               
           if shell[a+1][b+1] == "*":
               mineCount +=1 
               
           shell[a][b] = mineCount
           mineCount = 0
        b+=1
    a+=1
    b=1
    
a=0
b=0

for i in range(x):
    for j in matrix[a]:
        matrix[a][b] = shell[a+1][b+1]
        b+=1
    a+=1
    b=0
        
print(matrix,shell)


a=0
b=0

for i in range(x):
    for j in matrix[b]:
        print(matrix[b][a], end = "")
        a+=1
    print("\n")
    a=0
    b+=1

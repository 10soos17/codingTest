#!/usr/local/bin/python3

#1부터 100까지 모두 더하는 Code를 <pass> 부분에 완성하세요. for를 사용.

s = 0

for i in range(1,101,1):
   s += i

print(s)

"""-----------------------
s = 0

for i in range(101):
   s += i

print(s)

--------------------------
s = 0
t=[0]*100

for i in range(len(t)+1):
    s +=i
    
print(s)
------------------------"""

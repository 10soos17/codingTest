#!/usr/local/bin/python3
#키가 주어지면 순서대로 제대로 섰는지 확인하는 프로그램

"""
#sort,sorted,reverse:1=3=5(ascending order)//2=4(descending order)//6(Inverted item)
num=[176,156,155,165,166,169]
num.sort()
print(num)
num=[176,156,155,165,166,169]
num.sort(reverse=True)
print(num)
num=[176,156,155,165,166,169]
num.sort(reverse=False)
print(num)
num=[176,156,155,165,166,169]
num.reverse()
print(num)
num=[176,156,155,165,166,169]
reversed(num)
print(num)
num=[176,156,155,165,166,169]
new1=sorted(num,reverse=True)
print(new1)
num=[176,156,155,165,166,169]
new2=sorted(num,reverse=False)
print(new2)
--------------------
height = list(map(int,input("키 목록?").split()))
i = 1
for a in height:
   if a >= height[i]:
      i += 1
   if a >= height[i] and i ==len(height)-1:
      print("YES")
      break
   elif a < height[i]:
      print("NO")
      break
"""
user_input = input()

l = list(user_input.strip().split())
l = [int (i) for i in l]

if l != sorted(l):
	print("NO")
	
else:
	print("YES")

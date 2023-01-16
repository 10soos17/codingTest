#!/usr/local/bin/python3
#문장이 입력되면 거꾸로 출력하는 프로그램을 만들어 봅시다.
"""
state = input("state?")
sList=[]
for i in state:
    sList.append(i)
sList.sort(reverse=True)# or sList.reverse()
print(sList)
---------------------------------
text = str(input("입력하시오"))
new =""
a=-1
for i in text:
    new+=text[a]
    a -=1
print(new)
--------------------
n = input()

for i in reversed(n):
  print(i)
---------------------
"""
n = input()
print(n[::-1])

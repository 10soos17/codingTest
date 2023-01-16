#!/usr/local/bin/python3
#대문자와 소문자를 바꿔서 출력
"""
state = str(input("문자?"))
nState=""
for i in state:
   if i == i.lower():
      nState += i.upper()
   elif i == i.upper():
      nState += i.lower()
print(nState)
--------------
"""
a = input()
b = []

for i in a:
	if i.islower():
		b.append(i.upper())
	else:
		b.append(i.lower())
	
for i in b:
	print(i, end='')

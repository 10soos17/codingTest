#!/usr/local/bin/python3
#문장이 입력되면 모든 q를 e로 바꾸는 프로그램을 작성해 주세요.
# replace
s = list(input("문장?"))
a = 0
for i in s:
   if i == 'q':
      s[a] = 'e'
      a += 1
   print(s[a], end='')
   a+=1

"""
n = input()
print(n.replace("q", "e"))
"""

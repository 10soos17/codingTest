#!/usr/local/bin/python3
#'복잡한 세상 편하게 살자' 문장을 '복세편살'로/입력이 주어지면 앞 글자만 출력
"""
user_input = input().split(' ')
#print(user_input)
result = ''

for s in user_input:
    result += s[0]

print(result)
-------------
"""
state = list(input("state?"))
abbre= ""
abbre += state[0]
a=1
for i in state:
   if i == " " :
      abbre += state[a]
      a+=1
   else:
      a+=1

print(abbre)

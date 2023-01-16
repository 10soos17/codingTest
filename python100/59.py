#!/usr/local/bin/python3
#총 문자열의 길이는 50,문자열 입력하면 그 문자열을 가운데 정렬, 나머지 부분에'='
"""
"{0:=^50}".format(user_input)0-50번위 내에서 format안의 내용을 가운데로 정렬시킴

user_input = input()
print("{0:=^50}".format(user_input))
------------------------------------
def middle(text):
    first=["=" for i in range(50)]
    location=(50-len(text))//2
    for i in text:
        first[location] = i
        location+=1
    for i in first:
        print(i, end='')

text=input("text?")
middle(text)
-------------------------------
state = ['=']*50
word = list(input("word?"))

a = (len(state)-len(word))//2
b = 0
for i in range(len(word)):
   state[a] = word[b]
   a+=1
   b+=1

for i in state:
   print(i,end='')
-----------------------------------
"""
def middle(data):
    empty=50-len(data)
    return "="*empty+data+"="*empty
    
data = input()
if len(data) > 50:
    data = input()
print(middle(data))




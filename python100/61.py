#!/usr/local/bin/python3
#문자열을 입력받고 연속되는 문자열을 압축해서 표현하고싶습니다.

"""
답1
user_input = input()
s = ''
storeString = user_input[0]
count = 1
for i in user_input:
    if i == storeString:
        count += 1
    else:
        s += str(count) + storeString
        storeString = i
        count = 1
s += str(count) + storeString
print(s)

답2 - 이해를 돕기 위한 예제

import re

input_data = 'aaabbccccccasss'
rule = re.compile('[a-c]+')

one = re.findall('b', input_data)
two = re.findall(rule, input_data)
three = re.findall('(\\w)(\\1*)', input_data)

print(one)
print(two)
print(three)

답2 - 풀이

import re

input_data = 'aaabbccccccasss'
rule = re.compile('[a-c]+')

one = re.findall('b', input_data)
two = re.findall(rule, input_data)
three = re.findall('(\\w)(\\1*)', input_data)

print(one)
print(two)
print(three)

s = ''
for i, j in three:
    s += str(len(j)+1)+i
print(s)
-----------
text = "aaabbbbcdddd"
new = ""
a=0
b=1
count=1
while b < len(text):
    if text[a] == text[b]:
        b+=1
        count+=1
    else:
        new+=text[b-1]
        new+=str(count)
        a=b
        b=a+1
        count=1
if b == len(text):
    new+=text[b-1]
    new+=str(count)
print(new)
-----------------------------------
state = list(input("states?"))

newState=[]

i = 1
count = 1
for a in range(len(state)-1):
    
   if state[i] == state[i-1] and i == len(state)-1:
      newState += state[i-1]
      count+=1
      newState += str(count)
   elif state[i] != state[i-1] and i == len(state)-1:
      newState += state[i-1]
      newState += str(count)
      count = 1
      newState += state[i]
      newState += str(count)
   elif state[i] == state[i-1] and i != len(state)-1:
      i += 1
      count +=1
   else:
      newState += state[i-1]
      newState += str(count)
      count = 1
      i += 1

for i in newState:
    print(i, end='')
--------------
"""
def compress(data):
    n=len(data)
    count=1
    startNum=count
    new=''
    for i in range(n-1):
        for j in range(startNum,n):
            if data[j] == data[j-1] and j != n-1:
                count+=1
            elif data[j] == data[j-1] and j == n-1:
                count+=1
                new+=str(data[j-1])
                new+=str(count)
                startNum=count
                count=1
            else:
                new+=str(data[j-1])
                new+=str(count)
                startNum=count
                count=1
                continue
        break
    return new

data=input()
print(compress(data))

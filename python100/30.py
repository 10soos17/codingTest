#!/usr/local/bin/python3
"""
문자 pineapple에는 apple이라는 문자가 숨어 있습니다. 원범이는 이렇듯 문자열 속에 숨어있는 문자>를 찾아보려고 합니다.
입력으로 첫 줄에 문자열이 주어지고 둘째 줄에 찾을 문자가 주어지면
그 문자가 시작하는 index를 반환하는 프로그램을 만들어 주세요
texts = input("texts?")
text = input("text?")
#texts = "pineapple is yummy"
#text = "apple"
count=0
b=0
c=0
for i in texts:
    if i == text[0]:
        for j in text:
            if j == texts[b]:
                b+=1
                count+=1
            else:
                b=c
                break
        if count==len(text):
           print(c)
           break
    b+=1
    c=b
-------
text = list(input("문장?"))
word = list(input("단어?"))

i = 1
a = 0

for a  in range(len(text)):
   if text[a] == word[0]:
      for i  in range(len(word)-1):
         if text[a+i] == word[i]:
             i=i+1
         if text[a+i] == word[i] and i == len(word)-1:
             print(a)
        # else:
             #break
   a += 1
------------
data = input()
word = input()

print(data.find(word))
-------------------
"""
text=list(input("text?"))
a=0
b=0
length=len(text)

state="pineapple is yummy"
for i in state:
    if i == text[a] and a==length-1:
        print(b-a)
        break
    elif i == text[a]:
        a+=1
        b+=1
    else:
        b+=1
        a=0

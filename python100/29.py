#!/usr/local/bin/python3
"""
알파벳 하나만 입력, 그 알파벳이 대문자이면 YES를 아니면 NO를 출력하는 프로그램을 만들어 주세요.
→ 알파벳 여러개를 입력하고 여러개 입력한 것 중 대문자만 출력해주는 프로그램
text = input("text?")

if text == text.upper():
    print("YES")
else:
    print("NO")

texts = input("texts?")

for i in texts:
    if i == i.upper():
        print(i,end='')
"""
data = input()

if data.isupper():
	print("YES")
else:
	print("NO")


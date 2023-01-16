#!/usr/local/bin/python3
"""
2-gram이란 문자열에서 2개의 연속된 요소를 출력하는 방법
text = input("text?")
for i in range(len(text)-1):
    print(text[i:i+2])
------------------
"""
data = input()

for i in range(len(data) - 1):
	print(data[i], data[i+1], sep = '')

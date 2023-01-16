#!/usr/local/bin/python3
#0부터 1000까지 1의 개수를 세는 프로그램
"""
def count(n):
	countN = str(list(range(n+1))).count('1')
	return countN

print(count(1000))
------------------
def one(n):
    text=""
    for i in range(n+1):
        text+=str(i)
    oneNum=text.count("1")
    return oneNum    

num=int(input("number?"))
one(num)
-----
"""
def one(num):
    text=""
    count=0
    for i in range(num+1):
        text+=str(i)
    for i in text:
        if i =="1":
            count+=1
    return count
        
    
num=int(input())
print(one(num))

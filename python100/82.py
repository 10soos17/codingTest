#!/usr/local/bin/python3
"""수학공식이 제대로 입력이 되었는지 판단하는 코드를 작성
데이터 입력(1), 프로그램 종료(2) : 1
데이터를 입력하세요: 3 + 5
True

데이터 입력(1), 프로그램 종료(2) : 1
데이터를 입력하세요: 5 + 7) * (3 * 5)
False
"""
def math(e):
    num = 0
    sig = 0
    count = 0
    seCount = 0
    
    for i in e:
        if i ==")" and seCount==0:
            return False
        elif i == ("+" or "-" or "*" or "/"):
            sig += 1
        elif i == "(":
            count += 1
        elif i == ")":
            seCount += 1
        elif i != (")" or "(" or "+" or "-" or "*" or "/"):
            num += 1
            
    if num - sig != 1:
        return False
    elif num - sig ==1 and count == seCount:
        return True
    else:
        return False
        

while 1:
    order = input('데이터 입력(1), 프로그램 종료(2) :')
    if order == '1':
        ex = input('데이터를 입력하세요 :')
        print(math(ex))
    else:
        break

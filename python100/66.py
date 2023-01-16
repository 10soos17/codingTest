#!/usr/local/bin/python3
"""
탑을 쌓기 위해 각 크기별로 준비된 블럭들을 정해진 순서에 맞게 쌓아햐 합니다.
순서에 맞게 쌓지 않으면 무너질 수 있습니다.
예를 들면 정해진 순서가 BAC 라면 A 다음 C가 쌓아져야 합니다.
선행으로 쌓아야 하는 블럭이 만족된 경우라면 탑이 무너지지 않습니다.
- B를 쌓지 않아도 A와 C를 쌓을 수 있습니다.
- B 다음 블럭이 C가 될 수 있습니다.
쌓아져 있는 블럭 탑이 순서에 맞게 쌓아져 있는지 확인하세요.
1. 블럭은 알파벳 대문자로 표기합니다.
2. 규칙에 없는 블럭이 사용될 수 있습니다.
3. 중복된 블럭은 존재하지 않습니다.
탑 = ["ABCDEF", "BCAD", "ADEFQRX", "BEDFG"]
규칙 = "ABD"
출력
["가능","불가능","가능","가능]
-----------
def solution(전체블록, 규칙):
    answer = []
    for 부분블록 in 전체블록:
        answer.append(블록순서체크(부분블록, 규칙))
    return answer

def 블록순서체크(부분블록, 규칙):
    임시변수 = 규칙.index(규칙[0])
    for 문자 in 부분블록:
        if 문자 in 규칙:
            if 임시변수 > 규칙.index(문자):
                return '불가능'
            임시변수 = 규칙.index(문자)
    return '가능'

전체블록 = ['ABCDEF', 'BCAD', 'ADEFQRX', 'BEDFG', 'AEBFDGCH']
규칙 = 'ABCD'

print(solution(전체블록, 규칙))
-----------------
top = ["ABCDEF", "BCAD", "ADEFQRX", "BEDFG"]
rule = "ABD"
order=""
res=[]
for i in top:
    for j in rule:
        if i.find(j) !=-1:
            order+=str(i.find(j))
    for i in range(1,len(order)):
        if order[i-1] >= order[i]:
            res.append("N")
            break
        elif order[i-1] >= order[i] and len(order)-1==i:
            res.append("N")
            
        elif order[i-1] < order[i] and len(order)-1==i:
            res.append("Y")
    order=""
print(top,res,sep="\n")
-----
top = ["ABCDEF", "BCAD", "ADEFQRX", "BEDFG"]
rule = "ABC"
a=0

for i in top:
    if (i.find("A") or i.find("B") == -1 ) and i.find("C") == -1:
       top[a] = "가능"
    elif (i.find("A") and i.find("B") and i.find("C")) != -1:
        if i.find("A") > i.find("B") or i.find("A") > i.find("C") or i.find("B") > i.find("C") :
           top[a] = "불가능"
        else:
           top[a] = "가능"
    elif (i.find("A") or i.find("B") or i.find("C") == -1) :
        if i.find("B") > i.find("C"):
            top[a] = "불가능"
        else:
            top[a] = "가능"
    a += 1
    
for i in top:
    print(i,end='')
-------
"""
def block(top,rule):
    res=[]
    check=[]
    for i in top:
        for j in rule:
            if i.find(j) != -1:
                check.append(i.find(j))
        arrange=sorted(check)
        if arrange != check:
            res.append("N")
        else:
            res.append("Y")
        check.clear()
    return res

top = ["ABCDEF", "BCAD", "ADEFQRX", "BEDFG"]
rule = "ABD"
print(block(top,rule))

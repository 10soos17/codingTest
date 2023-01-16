#!/usr/local/bin/python3
"""가장 긴 공통 부분 문자열(Longest Common Subsequence)이란 A, B 두 문자열이 주어졌을 때, 두 열에 공통으로 들어 있는 요소로 만들 수 있는 가장 긴 부분열. 여기서 부분열이란 다른 문자열에서 몇몇의 문자가 빠져 있어도 순서가 바뀌지 않은 열을 말합니다.
예를 들어 S1 = ['T', 'H', 'E', 'S', 'T', 'R', 'I', 'N', 'G', 'S']  S2 = ['T', 'H', 'I', 'S', 'I', 'S']라는 두 문자열이 있을 때, 둘 사이 부분 공통 문자열의 길이는 ['T', 'H', 'S', 'T', 'I', 'S'] 의 6개가 됩니다.
이처럼 두 문자열이 주어지면 가장 긴 부분 공통 문자열의 길이를 반환.
두 개의 문자열이 한 줄에 하나씩 주어집니다.
문자열은 알파벳 대문자로만 구성되며 그 길이는 100글자가 넘어가지 않습니다.
출력은 이 두 문자열의 가장 긴 부분 공통 문자열의 길이를 반환
--------
def maxText(one,two):
    count=0
    maxNum=[]
    for i in range(len(one)-1):
        inNum=i
        for j in range(len(two)-1):
            if one[inNum]==two[j]:
                inNum+=1
                count+=1
            else:
                maxNum.append(count)
                inNum=i
                count=0
        maxNum.append(count)
        count=0
    return max(maxNum) 

one=input()
two=input()
print(maxText(one,two))
--------
"""
def sol(strings):
        result = []
        for i in range(1,len(strings)+1):
            for j in range(i):
                result.append(strings[j:j+len(strings)-i+1])
        return result
    
input1 = input()
input2 = input()
    #문자열 나열될 수 있는 모든 경우의수 만들기
list1 = set(sol(input1))
list2 = set(sol(input2))
    #경우의 수 교집합
answers = list1.intersection(list2)
    # 가장 긴 교집합
answer = max(answers,key=len)
print(len(answer))

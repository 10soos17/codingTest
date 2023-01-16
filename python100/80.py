#!/usr/local/bin/python3
"""**조합**이란 원소들을 조합하여 만들 수 있는 경우의 수
**순열**이란 원소의 값이 같더라도 순서가 다르면 서로 다른 원소로 취급
입력받은 자음을 n개를 선택하여 나올 수 있는 모든 조합과, 조합의 수를 출력
ㄱ(기역), ㄴ(니은), ㄷ(디귿), ㄹ(리을), ㅁ(미음), ㅂ(비읍), ㅅ(시옷), ㅇ(이응)
**<--요구조건-->**
1. 첫 줄에 선택할 한글 자음이 주어집니다.
2. 두번째 줄에 조합의 수가 주어집니다.
3. 주어진 조합의 수에 따라 조합과 조합의 수를 출력해주세요.
입력
ㄱ,ㄴ,ㄷ,ㄹ
3
출력
['ㄱㄴㄷ', 'ㄱㄴㄹ', 'ㄱㄷㄹ', 'ㄴㄷㄹ']
4
def combination(arr, r):
    # 깔끔하게 print 하기 위한 정렬
    arr = sorted(arr)

    def recursive(combination_list):
        if len(combination_list) == r:
            print(combination_list)
            return
        
        # 순서 상관 없이 원소가 같은 배열이 나올 수 없도록 시작 지점 설정
        start = arr.index(combination_list[-1]) + 1 if combination_list else 0
        for i in range(start, len(arr)):
            combination_list.append(arr[i])
            # 재귀함수 call
            recursive(combination_list)
            combination_list.pop()
    recursive([])
-----
def permutation(arr, r):
    # 깔끔하게 print 하기 위한 정렬
    arr = sorted(arr)
    # 사용한 배열 원소 체크
    used_list = [False for _ in range(len(arr))]

    def recursive(permutation_list, used_list):
        if len(permutation_list) == r:
            print(permutation_list)
            return
    
        for i in range(len(arr)):
            if not used_list[i]:
                permutation_list.append(arr[i])
                used_list[i] = True
                # 재귀함수 call
                recursive(permutation_list, used_list)
                used_list[i] = False
                permutation_list.pop()
    recursive([], used_list)

permutation('ABC', 2)
permutation([1, 2, 3, 4], 3)

print('\n' * 3)

combination('ABC', 2)
combination([1, 2, 3, 4], 3)

-------------------------------------------------------

"""
from itertools import permutations #이 문제에서는 안쓰지만 어떤 것인지 확인해보>세요.
from itertools import combinations

import itertools

user_input = input().split(',')
user_input_int = int(input())

#print(list(itertools.combinations(a, 3)))

print(list(map(''.join, combinations(user_input, user_input_int))))

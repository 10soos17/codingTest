#!/usr/local/bin/python3
"""LRU 알고리즘이란 페이지 교체 알고리즘으로써, Least Resently Used의 약자입니다. 즉 페이지 부재가 발생했을 경우 가장 오랫동안 사용되지 않은 페이지를 제거하는 알고리즘"""
def lru(m,f):
    page=[]
    t=0
    for i in f:
        if len(page) != m and i not in page:
            page.append(i)
            t+=6
        elif len(page) == m and i not in page:
            page.pop(0)
            page.append(i)
            t+=6
        else:
            page.remove(i)
            page.append(i)
            t+=1
    return t
memory=int(input())
page=str(input())
print(lru(memory,page))

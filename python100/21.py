#!/usr/local/bin/python3
"""
20. 다음 중 set을 만드는 방법이 아닌 것?

1)  x = {1, 2, 3, 5, 6, 7}
2)  x = {}
3)  x = set('python')
4)  x = set(range(5))
5)  x = set()

2번

23. print(10/2)의 출력 결과는 5이다.(x-5.0)
"""
x = {1, 2, 3, 5, 6, 7}
print(type(x))
x = {}
print(type(x))
x = set('python')
print(type(x))
x = set(range(5))
print(type(x))
x = set()
print(type(x))

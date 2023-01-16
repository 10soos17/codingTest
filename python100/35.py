#!/usr/local/bin/python3
#2제곱, 3제곱, 4제곱을 할 수 있는 Factory 함수를 만들려고 합니다. <pass>에 코드를 작성
def one(n):
   def two(val):
      ans = val ** n
      return ans
   return two
  
a = one(2)
b = one(3)
c = one(4)
print(a(10))
print(b(10))
print(c(10))

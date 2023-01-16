#! /usr/local/bin/python3

lines= int(input("num?"))

for i in range(lines):
   print(" "*(lines-i) + "*"*(2*i-1) + " "*(lines-i))

"""lines= int(input("num?"))
star=[' ']*(lines*2-1)

for i in range(lines+1):
  star[lines-i-1]='*'
  star[lines+i-1]='*'
  print(star)"""


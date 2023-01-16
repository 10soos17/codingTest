#!/usr/local/bin/python3
#!/usr/local/bin/python3
"""
숫자 3, 4, 6이 도통 눌리지 않습니다.10분 뒤, 모든 직원들에게 월급을 입금해주어야 합니다.
눌리지 않는 키보드를 누르지 않고 월급 입금을 두 번에 나눠주고 싶습니다.
1. 직원은 2000명이며, 3초 이내 수행을 해야합니다.
2. 입력값의 형식은 csv파일이며 이과장 '3,000,000', 'S은행', '100-0000-0000-000' 형식
3. 출력값의 형식은 csv 파일이며 이과장 '1,500,000', '1,500,000', 'S은행', '100-0000-0000-000' 입니다. 또는 '1,000,000', '2,000,000', 'S은행', '100-0000-0000-000' 도 괜찮습니다.
4. 라이브러리 사용할 수 있습니다.
import csv

f = open('1.txt', 'r', encoding='utf-8')
r = csv.reader(f)
for line in r:
    s1, s2 = '', ''
    for i in line[1].replace(',', ''):
        if i == '3':
            s1 += '1'
            s2 += '2'
        elif i == '4':
            s1 += '2'
            s2 += '2'
        elif i == '6':
            s1 += '1'
            s2 += '5'
        else:
            s1 += i
            s2 += '0'
    print(int(s1), int(s2))
"""    
import csv

f = open('./bank1.csv','w',encoding='UTF-8',newline='')
wr =csv.writer(f)
#wr.writerow([1,2,3]) #1행에 ,를 구분자로 총 3열에 각 1 2 3 값
#wr.writerow([[1,2,3],[4,5,6],[7,8,9]])#1행3열에 각각[1,2,3] [4,5,6] [7,8,9]값
wr.writerows([['이과장',"333,356,766","S은행",'100-0000-0000-000'],
              ['이과장',"5,000,000","S은행",'100-0000-0000-000'],
              ['이과장',"3,200,000","S은행",'100-0000-0000-000'],
              ['이과장',"3,300,000","S은행",'100-0000-0000-000'],
              ['이과장',"5,300,000","S은행",'100-0000-0000-000']])
f.close()

f = open('./bank1.csv','r',encoding='UTF-8',newline='')
ff =csv.reader(f)
sf = open('./bank2.csv','w',encoding='UTF-8',newline='')
ssf=csv.writer(sf)
count=0
for i in ff:
   one, two ='',''
   for j in i[1].replace(',',''):
      if j == '3':
         one+='1'
         two+='2'
      elif j == '4':
         one+='2'
         two+='2'
      elif j == '6':
         one+='1'
         two+='5'
      else:
         one+=j
         two+='0'
      count+=1
   ssf.writerow(['이과장',one,two,'S은행','100-0000-0000-000'])

sf.close()
f.close()

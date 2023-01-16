#!/usr/local/bin/python3
# 파일 하나에 수정된 것 추가
import csv

f = open('./bank3.csv','w',encoding='UTF-8',newline='')
wr =csv.writer(f)
#wr.writerow([1,2,3]) #1행에 ,를 구분자로 총 3열에 각 1 2 3 값
#wr.writerow([[1,2,3],[4,5,6],[7,8,9]])#1행3열에 각각[1,2,3] [4,5,6] [7,8,9]값
wr.writerows([['이과장',"333,356,766","S은행",'100-0000-0000-000'],
              ['이과장',"5,000,000","S은행",'100-0000-0000-000'],
              ['이과장',"3,200,000","S은행",'100-0000-0000-000'],
              ['이과장',"3,300,000","S은행",'100-0000-0000-000'],
              ['이과장',"5,300,000","S은행",'100-0000-0000-000']])
f.close()

f = open('./bank3.csv','r',encoding='UTF-8',newline='')
ff =csv.reader(f)
sf = open('./bank3.csv','a',encoding='UTF-8',newline='')
ssf=csv.writer(sf)
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
   ssf.writerow(['이과장',one,two,'S은행','100-0000-0000-000'])
sf.close()
f.close()

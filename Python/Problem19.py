# 1ms
import timeit

tik = timeit.default_timer()
cnt = 0
start = 1;
for year in range(1900, 2001): #loop years
	for month in range(1, 13): #month loop
		
		#30 day months
		if month == 4 or month == 6 or month == 9 or month == 11:
				start = (30 % 7) + start
			
		# Leap year Feb, 29 days
		elif month == 2 and year % 4 == 0:
			start = (29 % 7) + start
		
		#normal feb, 28 days
		elif month == 2:
			start = (28 % 7) + start
		
		#31 day months	
		else:
			start = (31 % 7) + start
		
		start %= 7
		if(start == 0 and year > 1900):
			cnt += 1
			
tok = timeit.default_timer()
print "Your solution:", cnt, "Sundays"
print "Math solution:", ((2001 - 1901) * 12)/7, "Sundays"
print "Your soultion took:", (tok - tik) * 1000, "ms."
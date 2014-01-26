sum = 0
currFib = 2
prevFib = 1
while currFib <= 4000000:
	if currFib & 1 == 0:
		sum += currFib
	currFib += prevFib
	prevFib = currFib - prevFib   #fancy swapping :P
print(sum)
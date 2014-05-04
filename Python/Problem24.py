# .2 ms
import timeit

#Factorial function.
def factorial(n):
	ans = 1
	for i in range(1, n + 1, 1):
		ans *= i
	return ans

tik = timeit.default_timer()
target = 1000000
perm = [0, 1, 2, 3, 4, 5, 6, 7, 8 , 9]
size = len(perm)

res = ""
remain = target - 1;
for i in range(1, size, 1):
	# we know there are fact(i) possible permutations from this index on
	fact = factorial(size - i)

	# We want to use this value from the permutation
	tmp = int(remain / fact)

	# Remainder for the next index 
	remain = remain % fact

	#Save our permutation result
	res = res + str(perm[tmp]);
	del perm[tmp]

	if remain <= 0:
		break

# Add the rest of the permutations in lexographical order
for x in perm:
	res = res + str(x)

tok = timeit.default_timer()
print(res)
print("Soultion took:", (tok - tik) * 1000, "ms.")
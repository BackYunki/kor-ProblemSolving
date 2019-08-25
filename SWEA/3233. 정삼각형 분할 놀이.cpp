#include <stdio.h>
int tc;
long long a, b;
int main()
{
	scanf("%d", &tc);
	for (int t = 1; t <= tc; t++)
	{
		scanf("%lld %lld", &a, &b);
		long long c = a / b;
		printf("#%d %lld\n", t, c*c);
	}
	return 0;
}
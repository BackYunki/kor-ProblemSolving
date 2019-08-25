#include <cstdio>

int main()
{
	int tc = 0;
	int d,a,b,f = 0;
	scanf("%d", &tc);
	for (int t = 1; t <= tc; t++)
	{
		scanf("%d %d %d %d", &d, &a, &b, &f);
		double col_time = (d+0.0) / (a+b);
		double dist_fly = f * col_time;
		printf("#%d %f\n", t, dist_fly);
	}
	return 0;
}
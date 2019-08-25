#include <cstdio>
int main()
{
	int tc = 0;
	scanf("%d", &tc);
	for (int t = 1; t <= tc; t++)
	{
		double a, b, c, d = 0;
		scanf("%lf %lf %lf %lf", &a, &b, &c, &d);
		double alice = a/b;
		double bob = c/d;
		const char* answer;
		
		if(alice > bob)
			answer = "ALICE";
		else if(alice == bob)
			answer = "DRAW";
		else
			answer = "BOB";

		printf("#%d %s\n", t, answer);
	}

	return 0;
}
#include <cstdio>
int tc, num, cnt;
int main()
{
    scanf("%d", &tc);
    for(int t = 1; t <= tc; t++)
    {
        scanf("%d", &num);
        cnt = 0;
        for (int i = 1; i <= num; i++)
        {
            int sum = 0;
            for (int j = i; j <= num; j++)
            {
                sum+=j;
                if(sum == num)
                {
                    cnt++;
                    break;
                }
                else if(sum > num) break;
            }
        }
        printf("#%d %d\n", t, cnt);
    }
    
    return 0;
}

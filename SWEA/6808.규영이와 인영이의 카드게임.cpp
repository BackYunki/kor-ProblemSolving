#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstdio>
using namespace std;

int  g_cards[9];
int  i_cards[9];
int wincnt;
int fact9 = 362880;

void swap(int * arr, int x, int y)
{
	int temp = arr[x];
	arr[x] = arr[y];
	arr[y] = temp;
}

void perm(int n)
{
	if (n == 9)
	{
		// 점수의 합을 구하기 위해서 규형이와 인영이 점수를 누적하자
		int g_score = 0;
		int i_score = 0;
		for (int i = 0; i < 9; i++)
		{
			// 규영이가 이겼으면
			if (g_cards[i] > i_cards[i])
			{
				g_score += g_cards[i] + i_cards[i];
			}
			else
			{
				i_score += g_cards[i] + i_cards[i];
			}
		}
		if (g_score > i_score)
		{
			wincnt++;
		}
		return;
	}
	for (int i = n; i < 9; i++)
	{
		if(i != n)
			swap(i_cards, i, n);
		perm(n + 1);
		swap(i_cards, i, n);
	}
}

int main()
{
	size_t T = 0;
	scanf("%u", &T);
	for (size_t i = 1; i <= T; i++)
	{
		bool selected[19];
		for (size_t j = 0; j < 19; j++)
			selected[j] = false;

		for (size_t j = 0; j < 9; j++)
		{
			int temp;
			scanf("%d", &temp);
			g_cards[j] = temp;
			selected[g_cards[j]] = true;
		}

		int idx = 0;
		for (size_t j = 1; j < 19; j++)
		{
			if (selected[j] == false)
			{
				i_cards[idx++] = j;
			}
		}
		wincnt = 0;
		perm(0);
		cout << '#' << i << ' ' << wincnt << ' ' << (fact9 - wincnt) << '\n';
	}
    return 0;
}
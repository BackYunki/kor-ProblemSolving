#include <iostream>
#include <string>
#include <stack>
#include <map>
using namespace std;
int main()
{
	ios::ios_base::sync_with_stdio(0);
	cout.tie(0); cin.tie(0);

	map<char, char> map;
	map.insert(make_pair(')', '('));
	map.insert(make_pair('}', '{'));
	map.insert(make_pair(']', '['));
	map.insert(make_pair('>', '<'));

	for (int t = 1; t <= 10; t++)
	{
		stack<char> stack;
		
		int answer = 1;
		string len;
		string brackets;
		getline(cin, len);
		getline(cin, brackets);

		for (int i = 0; i < stoi(len); i++)
		{
			// 여는 괄호인가?
			if (brackets[i] == '(' ||
				brackets[i] == '[' ||
				brackets[i] == '{' ||
				brackets[i] == '<')
			{
				stack.push(brackets[i]);
			}
			// 닫는 괄호인가?
			else
			{
				// 예외: 스택이 처음부터 비어있을 경우
				if (stack.empty())
				{
					answer = 0;
					break;
				}
				// 1. 스택에서 꺼낸 다음 비교한다.
				char top = stack.top(); stack.pop();
				if (map.at(brackets[i]) != top)
				{
					answer = 0;
					break;
				}
			}
		}
		if(!stack.empty()) answer = 0;

		cout << "#" << t << " " << answer << '\n';
	}

	return 0;
}
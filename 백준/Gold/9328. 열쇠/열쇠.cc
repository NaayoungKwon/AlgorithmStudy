#include<iostream>
#include<stdio.h>
#include<string>
#include<queue>

using namespace std;

char mat[110][110];
string my_key;
int dX[4] = {0,1,0,-1};
int dY[4] = {1,0,-1,0};

void get_docu(int h,int w)
{
	queue<pair<int,int>> path;
	queue<pair<int,int>> Door[30];
	int key[30]={0},visited[110][110]={0};
	int i,j,x,y,cx,cy,docu_cnt=0;
	int key_num;
	
	if(my_key.at(0) != '0')
	{
		for(i = 0 ; i < my_key.length() ; i++)
		{
			key[my_key.at(i) % 97] = 1;
		}
	}//key translate

	for(i = 1 ; i <= h ; i++)
	{
		if(mat[i][1] == '.')
		{
			path.push(make_pair(i,1));
			visited[i][1] = 2;
		}
		else if(mat[i][1] > 64 && mat[i][1] < 91 )
		{
			key_num = (mat[i][1]% 65);
			if(key[key_num] == 1)
			{
				mat[i][1] = '.';
				path.push(make_pair(i,1));
				visited[i][1] = 2;
			}// can open
			else
			{
				Door[key_num].push(make_pair(i,1));
			}//can't open
		}//문
		else if(mat[i][1] > 96 && mat[i][1] < 123)
		{
			key_num = mat[i][1] % 97;
			if(!key[key_num])
			{
				key[key_num] = 1;
				mat[i][1] = '.';
				path.push(make_pair(i,1));
				visited[1][1] = 1;
				while(!Door[key_num].empty())
				{
					int dx,dy;
					dx = Door[key_num].front().first;
					dy = Door[key_num].front().second;
					Door[key_num].pop();

					mat[dx][dy] = '.';
					path.push(make_pair(dx,dy));
					visited[dx][dy] = 2;
				}
			}
		}//열쇠
		else if(mat[i][1] == '$')
		{
			docu_cnt++;
			mat[i][1] = '.';
			path.push(make_pair(i,1));
			visited[i][1] = 2;
		}//문서

		if(mat[i][w] == '.')
		{
			path.push(make_pair(i,w));
			visited[i][w] = 2;
		}
		else if(mat[i][w] > 64 && mat[i][w] < 91 )
		{
			key_num = (mat[i][w]% 65);
			if(key[key_num] == 1)
			{
				mat[i][w] = '.';
				path.push(make_pair(i,w));
				visited[i][w] = 2;
			}// can open
			else
			{
				Door[key_num].push(make_pair(i,w));
			}//can't open
		}//문
		else if(mat[i][w] > 96 && mat[i][w] < 123)
		{
			key_num = mat[i][w] % 97;
			if(!key[key_num])
			{
				key[key_num] = 1;
				mat[i][w] = '.';
				path.push(make_pair(i,w));
				visited[1][w] = 1;
				while(!Door[key_num].empty())
				{
					int dx,dy;
					dx = Door[key_num].front().first;
					dy = Door[key_num].front().second;
					Door[key_num].pop();

					mat[dx][dy] = '.';
					path.push(make_pair(dx,dy));
					visited[dx][dy] = 2;
				}
			}
		}//열쇠
		else if(mat[i][w] == '$')
		{
			docu_cnt++;
			mat[i][w] = '.';
			path.push(make_pair(i,w));
			visited[i][w] = 2;
		}//문서
	}
	for(j = 2 ; j < w ; j++)
	{
		if(mat[1][j] == '.')
		{
			path.push(make_pair(1,j));
			visited[1][j] = 2;
		}
		else if(mat[1][j] > 64 && mat[1][j] < 91 )
		{
			key_num = (mat[1][j]% 65);
			if(key[key_num] == 1)
			{
				mat[1][j] = '.';
				path.push(make_pair(1,j));
				visited[1][j] = 2;
			}// can open
			else
			{
				Door[key_num].push(make_pair(1,j));
			}//can't open
		}//문
		else if(mat[1][j] > 96 && mat[1][j] < 123)
		{
			key_num = mat[1][j] % 97;
			if(!key[key_num])
			{
				key[key_num] = 1;
				mat[1][j] = '.';
				path.push(make_pair(1,j));
				visited[1][j] = 1;
				while(!Door[key_num].empty())
				{
					int dx,dy;
					dx = Door[key_num].front().first;
					dy = Door[key_num].front().second;
					Door[key_num].pop();

					mat[dx][dy] = '.';
					path.push(make_pair(dx,dy));
					visited[dx][dy] = 2;
				}
			}
		}//열쇠
		else if(mat[1][j] == '$')
		{
			docu_cnt++;
			mat[1][j] = '.';
			path.push(make_pair(1,j));
			visited[1][j] = 2;
		}//문서

		if(mat[h][j] == '.')
		{
			path.push(make_pair(h,j));
			visited[h][j] = 2;
		}
		else if(mat[h][j] > 64 && mat[h][j] < 91 )
		{
			key_num = (mat[h][j]% 65);
			if(key[key_num] == 1)
			{
				mat[h][j] = '.';
				path.push(make_pair(h,j));
				visited[h][j] = 2;
			}// can open
			else
			{
				Door[key_num].push(make_pair(h,j));
			}//can't open
		}//문
		else if(mat[h][j] > 96 && mat[h][j] < 123)
		{
			key_num = mat[h][j] % 97;
			if(!key[key_num])
			{
				key[key_num] = 1;
				mat[h][j] = '.';
				path.push(make_pair(h,j));
				visited[h][j] = 1;
				while(!Door[key_num].empty())
				{
					int dx,dy;
					dx = Door[key_num].front().first;
					dy = Door[key_num].front().second;
					Door[key_num].pop();

					mat[dx][dy] = '.';
					path.push(make_pair(dx,dy));
					visited[dx][dy] = 2;
				}
			}
		}//열쇠
		else if(mat[h][j] == '$')
		{
			docu_cnt++;
			mat[h][j] = '.';
			path.push(make_pair(h,j));
			visited[h][j] = 2;
		}//문서

	}//들어갈 구멍찾기

	while(!path.empty())
	{
		x = path.front().first;
		y = path.front().second;
		path.pop();
		
		for(i = 0 ; i < 4 ; i++)
		{
			cx = x + dX[i];
			cy = y + dY[i];

			if(!visited[cx][cy] && cx > 0 && cx <= h && cy > 0 && cy <= w)
			{
				if(mat[cx][cy] > 64 && mat[cx][cy] < 91) // find door
				{
					key_num = (mat[cx][cy]% 65);
					if(key[key_num] == 1)
					{
						mat[cx][cy] = '.';
						path.push(make_pair(cx,cy));
						visited[cx][cy] = 1;
					}// can open
					else
					{
						Door[key_num].push(make_pair(cx,cy));
					}//can't open
				}
				else if(mat[cx][cy] == '.')
				{
					path.push(make_pair(cx,cy));
					visited[cx][cy] = 1;
				}
				else if (mat[cx][cy] == '$') // find document
				{
					docu_cnt++;
					mat[cx][cy] = '.';
					path.push(make_pair(cx,cy));
					visited[cx][cy] = 1;
				}
				else if(mat[cx][cy] > 96 && mat[cx][cy] < 123) // find key
				{
					key_num = mat[cx][cy] % 97;
					mat[cx][cy] = '.';
					path.push(make_pair(cx,cy));
					visited[cx][cy] = 1;
					if(!key[key_num])
					{
						key[key_num] = 1;
						while(!Door[key_num].empty())
						{
							int dx,dy;
							dx = Door[key_num].front().first;
							dy = Door[key_num].front().second;
							Door[key_num].pop();

							mat[dx][dy] = '.';
							path.push(make_pair(dx,dy));
							visited[dx][dy] = 1;
						}
					}//new key! have to update
				}
			}
		}
	}

	cout << docu_cnt << endl;
}
int main()
{
	int t,h,w,i,j,k;
	string temp;

	cin >> t;
	for(i = 0 ; i < t ; i++)
	{
		cin >> h >> w;
		for(j = 1 ; j <= h ; j++)
		{
			cin >> mat[j]+1;
		}
		my_key.clear();
		cin >> my_key;
		get_docu(h,w);
	}
	
	return 0;
}
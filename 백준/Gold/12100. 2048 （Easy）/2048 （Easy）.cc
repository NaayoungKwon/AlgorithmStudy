#include<iostream>
#include<stdio.h>

using namespace std;

int n,maxc=0;
int mat[30][30];
void move(int dir)
{
	int i,j,prev;

	//1. 일단 옮긴다 -> 2. 옆에꺼랑 더한다 -> 3. 판 다시 옮긴다.

	if(dir == 0)//move right
	{
		for(i = 0 ; i < n ; i++)
		{
			prev = n; //제일 최근에 옮긴 0아닌칸
			for(j = n-1 ; j >= 0 ; j--)
			{
				if(mat[i][j] != 0)
				{
					mat[i][prev-1] = mat[i][j];
					if(prev-1 != j)
						mat[i][j] = 0;
					prev -= 1;
				}
			}
		}//act 1

		for(i = 0 ; i < n ; i++)
		{
			for(j = n-1 ; j > 0 ; j--)
			{
				if(mat[i][j] && mat[i][j-1] && (mat[i][j] == mat[i][j-1]))
				{
					mat[i][j] += mat[i][j-1];
					mat[i][j-1] = 0;
				}
			}
		}//act 2


		for(i = 0 ; i < n ; i++)
		{
			prev = n; //제일 최근에 옮긴 0아닌칸
			for(j = n-1 ; j >= 0 ; j--)
			{
				if(mat[i][j] != 0)
				{
					mat[i][prev-1] = mat[i][j];
					if(prev-1 != j)
						mat[i][j] = 0;
					prev -= 1;
				}
			}
		}//act 3


	}
	else if(dir == 1)//move down
	{
		for(j = 0 ; j < n ; j++)
		{
			prev = n;
			for(i = n-1 ; i >= 0 ; i--)
			{
				if(mat[i][j] != 0)
				{
					mat[prev-1][j] = mat[i][j];
					if(prev-1 != i)
						mat[i][j] = 0;
					prev -= 1;
				}
			}
		}//act 1

		for(j = 0 ; j < n ; j++)
		{
			for(i = n-1 ; i > 0 ; i--)
			{
				if(mat[i][j] && mat[i-1][j] && (mat[i][j]) == mat[i-1][j])
				{
					mat[i][j] += mat[i-1][j];
					mat[i-1][j] = 0;
				}
			}
		}
		//act 2

		for(j = 0 ; j < n ; j++)
		{
			prev = n;
			for(i = n-1 ; i >= 0 ; i--)
			{
				if(mat[i][j] != 0)
				{
					mat[prev-1][j] = mat[i][j];
					if(prev-1 != i)
						mat[i][j] = 0;
					prev -= 1;
				}
			}
		}//act 3

	}
	else if(dir == 2)//move left
	{
		for(i = 0 ; i < n ; i++)
		{
			prev = -1;
			for(j = 0 ; j <= n-1 ; j++)
			{
				if(mat[i][j] != 0)
				{
					mat[i][prev+1] = mat[i][j];
					if(prev+1 != j)
						mat[i][j] = 0;
					prev += 1;
				}
			}
		}//act 1

		for(i = 0 ; i < n ; i++)
		{
			for(j = 0 ; j < n-1 ; j++)
			{
				if(mat[i][j] && mat[i][j+1] && (mat[i][j] == mat[i][j+1]))
				{
					mat[i][j] += mat[i][j+1];
					mat[i][j+1] = 0;
				}
			}
		}//act 2

		for(i = 0 ; i < n ; i++)
		{
			prev = -1;
			for(j = 0 ; j <= n-1 ; j++)
			{
				if(mat[i][j] != 0)
				{
					mat[i][prev+1] = mat[i][j];
					if(prev+1 != j)
						mat[i][j] = 0;
					prev += 1;
				}
			}
		}//act 3
	}
	else if(dir == 3)//move up
	{
		for(j = 0 ; j < n ; j++)
		{
			prev = -1;
			for(i = 0 ; i <= n-1 ; i++)
			{
				if(mat[i][j] != 0)
				{
					mat[prev+1][j] = mat[i][j];
					if(prev+1 != i)
						mat[i][j] = 0;
					prev += 1;
				}
			}
		}//act 1

		for(j = 0 ; j < n ; j++)
		{
			for(i = 0 ; i < n-1 ; i++)
			{
				if(mat[i][j] && mat[i+1][j] && (mat[i][j] == mat[i+1][j]))
				{
					mat[i][j] += mat[i+1][j];
					mat[i+1][j] = 0;
				}
			}
		}//act 2

		for(j = 0 ; j < n ; j++)
		{
			prev = -1;
			for(i = 0 ; i <= n-1 ; i++)
			{
				if(mat[i][j] != 0)
				{
					mat[prev+1][j] = mat[i][j];
					if(prev+1 != i)
						mat[i][j] = 0;
					prev += 1;
				}
			}
		}//act 3
	}
}
int findMax()
{
	int i,j,max=0;

	for(i = 0 ; i < n; i++)
	{
		for(j = 0 ; j < n ; j++ )
		{
			max = (mat[i][j] > max ? mat[i][j] : max);
		}
	}
	return max;
}
int comp(int (*a)[30], int (*b)[30])
{
	int i,j;

	for(i = 0 ; i < n ; i++)
	{
		for(j = 0 ; j < n ; j++)
		{
			if(a[i][j] != b[i][j])
				return 0;
		}
	}
	return 1;
}
void dfs(int depth)
{
	int i,j,k,fm;
	int ori[30][30];

	if(depth >= 5)
	{
		fm = findMax();
		maxc = (maxc < fm ? fm : maxc);
		return ;
	}

	for(i = 0 ; i < n ; i++)
	{
		for(j = 0 ; j < n ; j++)
			ori[i][j] = mat[i][j];
	}

	for(i = 0 ; i < 4 ; i++)
	{//&& ((findMax() * (1 << n - (depth+1)) > maxc))
		move(i);
		//if(!comp(ori,mat) )
		dfs(depth+1);

		for(k = 0 ; k < n ; k++)
		{
			for(j = 0 ; j < n ; j++)
				mat[k][j] = ori[k][j];
		}

	}

}
int main()
{
	int i,j;

	cin >> n;
	for(i = 0 ; i < n; i++)
	{
		for(j = 0 ; j < n ; j++ )
		{
			cin >> mat[i][j];
		}
	}

	dfs(0);
	cout << maxc;

	return 0;
}
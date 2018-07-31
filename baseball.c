#include <stdio.h>
#include <stdlib.h>

int createAnswer(); 
int isStrike(int answer[], int input[]);
int isBall(int answer, int location, int input[]);

int main()
{
    int answer[3] = {0, };
    int input[3] = {0, };
    
    int tmp = createAnswer();
    answer[0] = tmp / 100;
    answer[1] = tmp / 10 % 10;
    answer[2] = tmp % 10;
   
    while(1)
    {
        printf("숫자를 입력해주세요 ex)123 : ");
        scanf("%d", &tmp);
        input[0] = tmp / 100;
        input[1] = tmp / 10 % 10;
        input[2] = tmp % 10;

        int strikeNum = isStrike(answer, input);
        if(strikeNum != 0)
            printf("%d 스크라이크 ", strikeNum);
		
		if(strikeNum == 3)
		{
			printf("3개의 숫자를 모두 맞히셨습니다! 게임종료\n");
			break;
		}
		
        int ballNum1 = isBall(answer[0], 0, input);
        int ballNum2 = isBall(answer[1], 1, input);
        int ballNum3 = isBall(answer[2], 2, input);

        if(ballNum1 + ballNum2 + ballNum3 != 0)
            printf("%d 볼 ", ballNum1 + ballNum2 + ballNum3);
		
		if(strikeNum == 0 && (ballNum1 + ballNum2 + ballNum3) == 0)
			printf("낫싱");
		
		printf("\n");
    }
    return 0;
}

int createAnswer() 
{
    int tmp[3] = {0, }; 
    int randNum = 0;
    int location = 0;
    srand(time(NULL));

    while(location <3)
    {
        if(tmp[0] != randNum && tmp[1] != randNum)
        {
            tmp[location++] = randNum;
        }
        randNum = rand()%9 + 1;
    }
    return (int)tmp[0] * 100 + (int)tmp[1] * 10 + (int)tmp[2];
}

int isStrike(int answer[], int input[]) 
{
    int strikeNum = 0;
    
    for(int i = 0; i < 3; i ++)
    {
        if(answer[i] == input[i])
        {
            strikeNum++;
        }
    }
    return strikeNum;
}


int isBall(int answer, int location, int input[])
{
    int ballNum = 0;
    
    for(int i = 0; i < 3; i ++)
    {
		if((answer == input[i]) && (i != location))
        {
			ballNum = 1;
        }
		else if((answer == input[i]) && (i == location))
        {
			ballNum = 0;
			break;
        }
    }
    return ballNum;
}
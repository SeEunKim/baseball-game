#include <stdio.h>
#include <stdlib.h>

#define MAXNUMBER 3
#define TRUE 1
#define FALSE 0

int * createAnswer(void);
int isInvalid(void);
int countStrike(int answer[], int input[]);
int countBall(int answer, int location, int input[]);
void checkAnswer(int strikeNum, int ballNum);
int checkLength(int number);
int checkDuplicateNumber(int number);

int main()
{
    while(TRUE)
    {
        int strikeNum = 0;
        int input[MAXNUMBER] = {0, };
        int * answer, tmp;
        
        answer = createAnswer();
        
        printf("===== 새로운 게임 ===== \n");
        
        while(strikeNum != MAXNUMBER)
        {
            
            int ballNum = 0;
            tmp = isInvalid();
            input[0] = tmp / 100;
            input[1] = tmp / 10 % 10;
            input[2] = tmp % 10;
            
            strikeNum = countStrike(answer, input);
            
            for(int i = 0; i < MAXNUMBER; i++)
                ballNum += countBall(answer[i], i, input);
            
            checkAnswer(strikeNum, ballNum);
            printf("\n");
        }
        strikeNum = 0;
        
    }
    return 0;
}
int * createAnswer(void)
{
    int * answer = (int*)malloc(MAXNUMBER);
    
    int randNum = 0;
    int location = 0;
    srand(time(NULL));
    
    while(location <MAXNUMBER)
    {
        if(answer[0] != randNum && answer[1] != randNum)
        {
            answer[location++] = randNum;
        }
        randNum = rand()%9 + 1;
    }
    return answer;
}

int isInvalid(void)
{
    int tmp = 0;
    int result = 0;
    
    printf("숫자를 입력해주세요 ex)123 : ");
    
    while(result != 2)
    {
        scanf("%d", &tmp);
        result = checkLength(tmp) + checkDuplicateNumber(tmp);
        
        if(result != 2)
            printf("중복되지 않은 세 자리 숫자를 입력해주세요\n ");
    }
    return tmp;
}

int checkLength(int number)
{
    if((number < 100) || (number >= 1000))
        return FALSE;
    else
        return TRUE;
}

int checkDuplicateNumber(int number)
{
    int tmp[3] = {0, };
    
    tmp[0] = number / 100;
    tmp[1] = number / 10 % 10;
    tmp[2] = number % 10;
    
    if((tmp[0] != tmp[1]) && (tmp[0] != tmp[2]) && (tmp[1] != tmp[2]))
        return TRUE;
    else
        return FALSE;
}

int countStrike(int answer[], int input[])
{
    int strikeNum = 0;
    for(int i = 0; i < MAXNUMBER; i ++)
    {
        if(answer[i] == input[i])
        {
            strikeNum++;
        }
    }
    return strikeNum;
}

int countBall(int answer, int location, int input[])
{
    int ballNum = 0;
    for(int i = 0; i < MAXNUMBER; i ++)
    {
        if((answer == input[i]) && (i != location))
        {
            ballNum = TRUE;
            break;
        }
        else if((answer == input[i]) && (i == location))
        {
            ballNum = FALSE;
            break;
        }
    }
    return ballNum;
}

void checkAnswer(int strikeNum, int ballNum)
{
    if(strikeNum != 0)
        printf("%d 스트라이크 ", strikeNum);
    
    if(strikeNum == MAXNUMBER)
    {
        printf("\n 3개의 숫자를 모두 맞히셨습니다! 게임종료\n");
        return;
    }
    
    if(ballNum != 0)
        printf("%d 볼 ", ballNum);
    else if(strikeNum == 0 && (ballNum) == 0)
        printf("낫싱");
}



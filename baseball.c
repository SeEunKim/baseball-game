#include <stdio.h>

#include <stdlib.h>

 

#define MAXNUMBER 3

#define TRUE 1

#define FALSE 0

 

int createAnswer(); 

int isInvalid();

int countStrike(int answer[], int input[]);

int countBall(int answer, int location, int input[]);

void checkAnswer(int strike, int ball1, int ball2, int ball3);

int checkLength(int number);

int checkDuplicateNumber(int number);

 

int main()

{

	while(TRUE)

	{

		int strikeNum = 0;

		int answer[MAXNUMBER] = {0, };

		int input[MAXNUMBER] = {0, };

 

		int tmp = createAnswer();

		answer[0] = tmp / 100;

		answer[1] = tmp / 10 % 10;

		answer[2] = tmp % 10;

		

		printf("===== 새로운 게임 ===== \n");

	

		while(strikeNum != MAXNUMBER)

		{

			tmp = isInvalid();

			input[0] = tmp / 100;

			input[1] = tmp / 10 % 10;

			input[2] = tmp % 10;

 

			strikeNum = countStrike(answer, input);

		   

			int ballNum1 = countBall(answer[0], 0, input);

			int ballNum2 = countBall(answer[1], 1, input);

			int ballNum3 = countBall(answer[2], 2, input);

			

			checkAnswer(strikeNum, ballNum1, ballNum2, ballNum3);

 

			printf("\n");

		} 

	}

  

    return 0;

}

 

int createAnswer() 

{

    int tmp[MAXNUMBER] = {0, }; 

    int randNum = 0;

    int location = 0;

    srand(time(NULL));

 

    while(location <MAXNUMBER)

    {

        if(tmp[0] != randNum && tmp[1] != randNum)

        {

            tmp[location++] = randNum;

        }

        randNum = rand()%9 + 1;

    }

    return (int)tmp[0] * 100 + (int)tmp[1] * 10 + (int)tmp[2];

}

 

int isInvalid() 

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

	{

		return FALSE;

	}

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

	{

		return TRUE;

	}

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

 

void checkAnswer(int strikeNum, int ballNum1, int ballNum2, int ballNum3)

{

	if(strikeNum != 0)

		printf("%d 스트라이크 ", strikeNum);

	

	if(strikeNum == MAXNUMBER)

	{

		printf("\n 3개의 숫자를 모두 맞히셨습니다! 게임종료\n");

		return;

	}

	

	if(ballNum1 + ballNum2 + ballNum3 != 0)

		printf("%d 볼 ", ballNum1 + ballNum2 + ballNum3);

	

	if(strikeNum == 0 && (ballNum1 + ballNum2 + ballNum3) == 0)

		printf("낫싱");

	

}
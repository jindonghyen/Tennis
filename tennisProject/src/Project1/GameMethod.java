package Project1;

import java.util.Random;

public class GameMethod extends GameElement{

	// 계수기 출력, Log파일 생성, Player클래스로부터 받은 이름
	// 넘겨주기 위한 객체 생성 및 초기화
	ScoreBoard sb = new ScoreBoard();

	// 포인트, 게임, 세트를 저장하고 ScoreBoard 클래스로 넘겨주기 위한 배열
	int [][] board = new int [2][3];

	// 점수 발생을 위한 랜덤 객체
	Random rnd = new Random();
	int a = 0;

	// 세트 스코어를 확인하는 메소드
	public void setCheck(int a) {
		while (board[0][2] < a && board[1][2] < a) { 
			gameCheck();
		} 
	}

	// 계수기에 선수 이름을 출력하기 위한 메소드
	public void nameSet(String[] names) {
		sb.setScoreBoardName(names);
	}
	// Log파일 이름에 선수 이름을 지정하기 위한 메소드
	public void getNames(String[] names) {
		sb.getNames(names);
	}

	// 게임 스코어를 확인하는 메소드
	private void gameCheck(){

		while (!(board[a][1] - board[1-a][1] >1 && board[a][1] > 5)) {
			gameRoll();	
			if(board[a][1] == 6 && board[1-a][1] == 6)  {
				a = playTieBreak();
				break;
			}
		} 		
		board[0][1] = board[1][1] = 0;
		board[a][2]++;
		sb.printSet(a, Integer.toString(board[a][2]));

		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}

	// 타이브레이크
	private int playTieBreak() {

		while (!(board[a][0] > 6 && board[a][0] - board[1-a][0] >= 2)) {
			a = rnd.nextInt(2);
			board[a][0]++;
			sb.printScore(Integer.toString(board[0][0]), Integer.toString(board[1][0]));

			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/

		}
		board[a][1]++;
		sb.printGame(a, Integer.toString(board[a][1]));

		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/

		return a;
	}

	// 포인트 생성 메소드
	private void gameRoll() {

		String [] score = {"0","15","30","40","WIN"};

		while(!(board[a][0] > 3 && board[a][0] - board[1-a][0] > 1)) {
			a = rnd.nextInt(2);
			board[a][0]++;
			sb.printScore(score[board[0][0]], score[board[1][0]]);

			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/

			if(board[0][0] == 3 && board[1][0] == 3) a = playDeuce();
		} //while end

		board[0][0] = board[1][0] = 0;
		board[a][1]++;
		sb.printGame(a, Integer.toString(board[a][1]));

		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}

	// 듀스 상황에서 포인트를 생성하는 메소드
	private int playDeuce() {

		String [] score = {"0","15","30","40","AD","WIN"};

		while(!(board[a][0] == 5 && board[1-a][0] == 3)) {
			a = rnd.nextInt(2);
			board[a][0]++;

			if(board[1-a][0] ==  4)	 board[1-a][0]--;
			sb.printScore(score[board[0][0]], score[board[1][0]]);

			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
		return a;
	}
}

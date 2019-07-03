package Project1;
import java.io.IOException;
import java.util.Scanner;

public class Player extends GameElement{

	Scanner sc = new Scanner(System.in);
		
	public void createPlayer() {
		
		// 게임 방식 입력
		System.out.print("게임 방식을 입력하시오 (1.단식 2.복식) :  ");
		int soloDuo = sc.nextInt();
		int gender;
		while (!(soloDuo == 1||soloDuo ==2)) {
			System.out.println("올바른 입력이 아닙니다.");
			System.out.print("다시 게임 방식을 입력하시오 (1.단식 2.복식) :  ");
			soloDuo = sc.nextInt();
			try {
				System.in.skip(System.in.available());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 이름을 저장할 배열의 크기를 단식이면 2, 복식이면 4로 입력 방식에 따라 유동적으로 할당
		String [] name = new String [soloDuo * 2];

		// 단식을 선택한 경우 - 성별 선택
		if(soloDuo == 1) {
			System.out.print("성별을 입력하시오 (1.남자 2.여자) :  ");
			gender = sc.nextInt();
			while (!(gender == 1||gender ==2)) {
				System.out.println("올바른 입력이 아닙니다.");
				System.out.print("다시 성별을 입력하시오 (1.남자 2.여자) :  ");
				gender = sc.nextInt();
				try {
					System.in.skip(System.in.available());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		// 복식을 선택한 경우 - 성별 선택
		else {
			System.out.print("성별을 입력하시오 (1.남자 2.여자 3.혼성) :  " );
			gender = sc.nextInt();
			while (!(gender == 1||gender == 2 ||gender == 3)) {
				System.out.println("올바른 입력이 아닙니다.");
				System.out.print("다시 성별을 입력하시오 (1.남자 2.여자 3.혼성) :  ");
				gender = sc.nextInt();
				try {
					System.in.skip(System.in.available());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		if(gender == 1) {
			gender = 3;
		}
		else {
			gender = 2;
		}

		// 선수 이름 입력
		for (int i = 0; i < name.length; i++) {
			System.out.printf("%d번 선수의 이름을 입력하시오 :  ", i+1);
			name[i] = sc.next();
		}
		
		this.setName(name);
		this.setGender(gender);
		this.setSoloDuo(soloDuo);

	}
	
}
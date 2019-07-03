package Project1;

import java.io.IOException;

// 실행을 위한 메인함수가 있는 클래스

public class Tennis {

	public static void main(String[] args) {

		Player p = new Player(); 		 // 플레이어 객체 생성
		p.createPlayer(); 				 // User로부터 게임 진행 관련 정보를 입력받음
		GameMethod g = new GameMethod(); // 테니스 게임 세팅을 위한 객체 생성
		
		String[] names = p.getName();	 // 입력받은 이름 저장
		int a = p.getGender();			 // 입력받은 성별 저장
		
		g.nameSet(names);				 // 계수기에 이름 반영
		g.getNames(names);				 // Log 파일 생성 시 파일 제목에 이름 반영
		g.setCheck(a);					 // 테니스 게임 진행
		
		// 게임 종료
		try {
			System.out.println("게임이 끝났습니다. Enter를 누르면 종료합니다.");
			System.in.read();
			System.in.skip(System.in.available());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

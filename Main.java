package kosta.lunch;

import kosta.baseball.Keybord;

public class Main {

	public static void main(String[] args) {
		Manager manager = new Manager();
		for (;;) {
			System.out.println("1.회원가입 2.로그인 3.종료");
			int m = Keybord.sc.nextInt();
			Keybord.sc.nextLine();

			switch (m) {
			case 1:
				try {
					manager.join();
					break;
				} catch (Exception e) {
					System.out.println("이미 동일한 아이디가 있습니다.");		
				}
				break;
			case 2:
				try {
					manager.login();					
				} catch (Exception e) {
					break;
				}
				for (;;) {
					int key = manager.showMenu();
					// 1.입금 2.잔액조회 3.식권구매 4.식단검색(날짜) 5.식단검색(메뉴) 6.전첵식단 7.회원정보 조회
					// 8.회원정보 수정 9.종료
					//1.식단 입력 2.식단 수정 3.긴급 휴일(식단 밀림) 4.전체식단 출력 5.현재 빈좌석 수 조회 6.현재 매출 조회 7.종료
					switch (key) {
					case 0:
						manager.ticketUse();
						continue;
					case 1:
						manager.addmenu();
						manager.deposit();
						continue;
					case 2:
						manager.menumodify();
						manager.printBalance();
						continue;
					case 3:
						if(manager.getCurrent() instanceof Admin){
							manager.removeMenu();
						}else{
							manager.buy();							
						}
						continue;
					case 4:
						if(manager.getCurrent() instanceof Admin){
							manager.printAll();							
						}else{
							manager.print();							
						}
						
						continue;
					case 5:
						manager.seat();
						continue;
					case 6:
						if(manager.getCurrent() instanceof Admin){
							manager.profit();														
						}else{
							manager.printAll();							
						}
						continue;
					case 7:
						if(manager.getCurrent() instanceof Admin){
							System.out.println("로그아웃");
							break;
						}
						manager.information();
						continue;
					case 8 :
						manager.modify();
						continue;
						
					case 9:
						if(manager.getCurrent() instanceof Customer){
							System.out.println("로그아웃");
							break;							
						}else{
							continue;
						}
						
					default:
						continue;
					}
					break;
				}
				break;
			case 3:
				return;
			default:
				break;
			}
		}

	}
}

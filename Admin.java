package kosta.lunch;

public class Admin extends User {
	int profit = 0;
	
	public Admin() {
	}

	public Admin(String name, String id, String pw, String phoneNo) {
		super(name, id, pw, phoneNo);
	}

	@Override
	public int showMenu() {
		System.out.println("1.식단 입력 2.식단 수정 3.긴급 휴일(식단 밀림) 4.전체식단 출력 5.현재 빈좌석 수 조회 6.현재 매출 조회 7.로그아웃 ");
		int menu = Keybord.sc.nextInt();
		Keybord.sc.nextLine();
		return menu;

	}

	public void profit(int ticket) {
		System.out.println("현재 매출액은 " + (ticket * 5000) + "원 입니다.");
	}


}

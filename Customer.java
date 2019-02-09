package kosta.lunch;

import kosta.lunch.Keybord;

public class Customer extends User {
	int balance;
	int ticket;
	

	public Customer(String name, String id, String pw, String phoneNo, int balance) {
		super(name, id, pw, phoneNo);
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", id=" + id + ", pw=" + pw + ", phoneNo=" + phoneNo + ", balance=" + balance
				+ ", 보유식권갯수 = " + ticket + "]";
	}

	@Override
	public int showMenu() {
			System.out.println("0.식권 사용 1.입금 2.잔액조회 3.식권구매 4.식단검색(날짜) 5.빈 좌석 수 확인 6.전체식단 7.회원정보 조회 8.회원정보 수정 9.로그아웃");
			int menu = Keybord.sc.nextInt();
			Keybord.sc.nextLine();
			return menu;
	}


	public void deposit(int amount) {
		balance += amount;
		printBalance();
	}

	public int buy(int n) {
		if (balance >= (5000 * n)) {
			System.out.println("식권 " + n + "개를 구매 및 사용 하였습니다.");
			balance -= (5000) * n;
			System.out.println("남은 잔액 : " + balance);
			ticket += n;
		} else {
			System.out.println("잔액이 부족합니다.");
		}
		return n;
	}
	public int use(int n){
		if(ticket >= n){
			ticket -= n;
			return n;
		}else{
			System.out.println("보유하신 식권이 부족합니다.");
			return 0;
		}
	}

	public void printBalance() {
		System.out.println("남은 잔액 : " + balance);
	}

	public void search_date() {

	}

	public void search_menu() {

	}

	public void allPrint() {

	}

	public int getTicket() {
		return ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}
	
	
}

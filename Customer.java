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
				+ ", �����ıǰ��� = " + ticket + "]";
	}

	@Override
	public int showMenu() {
			System.out.println("0.�ı� ��� 1.�Ա� 2.�ܾ���ȸ 3.�ıǱ��� 4.�Ĵܰ˻�(��¥) 5.�� �¼� �� Ȯ�� 6.��ü�Ĵ� 7.ȸ������ ��ȸ 8.ȸ������ ���� 9.�α׾ƿ�");
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
			System.out.println("�ı� " + n + "���� ���� �� ��� �Ͽ����ϴ�.");
			balance -= (5000) * n;
			System.out.println("���� �ܾ� : " + balance);
			ticket += n;
		} else {
			System.out.println("�ܾ��� �����մϴ�.");
		}
		return n;
	}
	public int use(int n){
		if(ticket >= n){
			ticket -= n;
			return n;
		}else{
			System.out.println("�����Ͻ� �ı��� �����մϴ�.");
			return 0;
		}
	}

	public void printBalance() {
		System.out.println("���� �ܾ� : " + balance);
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

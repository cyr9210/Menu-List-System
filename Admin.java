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
		System.out.println("1.�Ĵ� �Է� 2.�Ĵ� ���� 3.��� ����(�Ĵ� �и�) 4.��ü�Ĵ� ��� 5.���� ���¼� �� ��ȸ 6.���� ���� ��ȸ 7.�α׾ƿ� ");
		int menu = Keybord.sc.nextInt();
		Keybord.sc.nextLine();
		return menu;

	}

	public void profit(int ticket) {
		System.out.println("���� ������� " + (ticket * 5000) + "�� �Դϴ�.");
	}


}

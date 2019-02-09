package kosta.lunch;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsInstanceOf;

import kosta.lunch.Keybord;

public class Manager {
	List<User> userList = new ArrayList<>();
	MenuManager mm = new MenuManager();
	private User current;
	String adminCode = "12345";
	int ticket = 0;
	int sell = 0;

	public void join()throws Exception {
		System.out.println("1.����� 2.������");
		int n = Keybord.sc.nextInt();
		Keybord.sc.nextLine();

		switch (n) {
		case 1:
			System.out.print("NAME : ");
			String name = Keybord.sc.nextLine();
			System.out.print("ID : ");
			String id = Keybord.sc.nextLine();
			for(int i = 0; i < userList.size();i++){
				if(userList.get(i).getId().equals(id)){
					throw new Exception();
				}
			}
			System.out.print("PW : ");
			String pw = Keybord.sc.nextLine();
			System.out.print("PHONENO. : ");
			String phoneNo = Keybord.sc.nextLine();
			System.out.print("�Ա�(���Ը� ���Ͻ� ��� 0) : ");
			int balance = Keybord.sc.nextInt();
			Keybord.sc.nextLine();
			userList.add(new Customer(name, id, pw, phoneNo, balance));
			break;
		case 2:
			System.out.print("NAME : ");
			name = Keybord.sc.nextLine();
			System.out.print("ID : ");
			id = Keybord.sc.nextLine();
			for(int i = 0; i < userList.size();i++){
				if(userList.get(i).getId().equals(id)){
					throw new Exception();
				}
			}
			System.out.print("PW : ");
			pw = Keybord.sc.nextLine();
			System.out.print("PHONENO. : ");
			phoneNo = Keybord.sc.nextLine();
			System.out.println("������ �ڵ� �Է� : ");
			String code = Keybord.sc.nextLine();
			if(code.equals(adminCode)){
				userList.add(new Admin(name, id, pw, phoneNo));				
			}else{
				System.out.println("������ �ڵ尡 Ʋ�Ƚ��ϴ�.");
			}
			
			break;
		default:
			break;
		}

	}

	public void login() {
		System.out.print("ID : ");
		String id = Keybord.sc.nextLine();
		System.out.print("PW : ");
		String pw = Keybord.sc.nextLine();
		int index = -1;
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getId().equals(id) && userList.get(i).getPw().equals(pw)) {
				index = i;
			}
		}
		boolean bol = true;
		if (index == -1) {
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getId().equals(id))
					bol = false;
			}
			if (bol) {
				System.out.println("�ش���̵� �����ϴ�.");
			} else {
				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			}
		}
	
			current = userList.get(index);			
	
	}

	public int showMenu() {
		return (current.showMenu());
	}

	public void deposit() {
		if (current instanceof Customer) {
			System.out.println("�Ա� �� �Է� :");
			int amount = Keybord.sc.nextInt();
			Keybord.sc.nextLine();

			((Customer) current).deposit(amount);
		}
	}

	public void printBalance() {
		if (current instanceof Customer) {
			((Customer) current).printBalance();
		}
	}

	public void buy() {
		if (current instanceof Customer) {
			System.out.println("�ı� ������ �����Ͻðڽ��ϱ�?");
			int n = Keybord.sc.nextInt();
			Keybord.sc.nextLine();

			ticket += ((Customer) current).buy(n);

		}
	}

	public void information() {
		if (current instanceof Customer) {
			System.out.println(current.toString());
		}
	}

	public void modify() {
		System.out.println("1.�̸����� 2.��ȭ��ȣ ����");
		int n = Keybord.sc.nextInt();
		Keybord.sc.nextLine();

		switch (n) {
		case 1:
			System.out.print("���� �̸� �Է� :");
			current.setName(Keybord.sc.nextLine());
			break;
		case 2:
			System.out.println("���� ��ȭ��ȣ �Է� : ");
			current.setPhoneNo(Keybord.sc.nextLine());
			break;
		default:
			break;
		}
	}

	public void seat() {

		System.out.println("���� �� �¼��� ���� " + (10 - sell) + "�� �Դϴ�.");
	}

	public void ticketUse() {
		if (current instanceof Customer) {
			System.out.print("����Ͻ� Ƽ�� ���� �Է� : ");
			int n = Keybord.sc.nextInt();
			if ((sell + n) > 10) {
				System.out.println("�ڸ��� �����ϴ�.");
				seat();
			} else {
				System.out.println("�ı��� " + n + "�� ����Ͽ����ϴ�.");
				sell += ((Customer) current).use(n);
				Keybord.sc.nextLine();
				System.out.println("���� Ƽ���� " + ((Customer) current).getTicket() + " ���Դϴ�.");
			}

		}

	}

	public User getCurrent() {
		return current;
	}

	public void setCurrent(User current) {
		this.current = current;
	}

	public void profit() {
		if (current instanceof Admin) {
			((Admin) current).profit(ticket);
		}
	}

	public void addMenuList(File file) {

	}

	public void removeMenu() {
		System.out.println("��� ���� ��¥�� �Է����ּ���.");
		mm.remove(Keybord.sc.nextInt());
		Keybord.sc.nextLine();
	}

	public void print() {
		System.out.print("��¥�Է� : ");
		mm.print(Keybord.sc.nextInt());
		Keybord.sc.nextLine();
	}

	public void printAll() {
		try {
			mm.printAll();
		} catch (Exception e) {
			System.out.println("��ϵ� �Ĵ��� �����ϴ�.");
		}
	}

	public void addmenu() {
		if (current instanceof Admin) {
			System.out.print("�Ĵ� �߰� ��¥ �Է� :");
			int day = Keybord.sc.nextInt();
			Keybord.sc.nextLine();
			Menu menu = new Menu();
			for (int i = 0; i < 4; i++) {
				System.out.print("�޴��Է� : ");
				menu.getMenu()[i] = Keybord.sc.nextLine();
			}
			mm.addmenu(day, menu);
		}
	}

	public void menumodify() {
		if (current instanceof Admin) {
			System.out.println("���� ��¥ �Է� :");
			int day = Keybord.sc.nextInt();
			Keybord.sc.nextLine();

			Menu menu = new Menu();
			for (int i = 0; i < 4; i++) {
				System.out.print("�޴��Է� : ");
				menu.getMenu()[i] = Keybord.sc.nextLine();
			}
			mm.modify(day, menu);
		}
	}

}

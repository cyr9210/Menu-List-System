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
		System.out.println("1.사용자 2.관리자");
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
			System.out.print("입금(가입만 원하실 경우 0) : ");
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
			System.out.println("관리자 코드 입력 : ");
			String code = Keybord.sc.nextLine();
			if(code.equals(adminCode)){
				userList.add(new Admin(name, id, pw, phoneNo));				
			}else{
				System.out.println("관리자 코드가 틀렸습니다.");
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
				System.out.println("해당아이디가 없습니다.");
			} else {
				System.out.println("비밀번호가 틀렸습니다.");
			}
		}
	
			current = userList.get(index);			
	
	}

	public int showMenu() {
		return (current.showMenu());
	}

	public void deposit() {
		if (current instanceof Customer) {
			System.out.println("입금 액 입력 :");
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
			System.out.println("식권 몇장을 구매하시겠습니까?");
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
		System.out.println("1.이름변경 2.전화번호 변경");
		int n = Keybord.sc.nextInt();
		Keybord.sc.nextLine();

		switch (n) {
		case 1:
			System.out.print("변경 이름 입력 :");
			current.setName(Keybord.sc.nextLine());
			break;
		case 2:
			System.out.println("변경 전화번호 입력 : ");
			current.setPhoneNo(Keybord.sc.nextLine());
			break;
		default:
			break;
		}
	}

	public void seat() {

		System.out.println("현재 빈 좌석의 수는 " + (10 - sell) + "석 입니다.");
	}

	public void ticketUse() {
		if (current instanceof Customer) {
			System.out.print("사용하실 티켓 수량 입력 : ");
			int n = Keybord.sc.nextInt();
			if ((sell + n) > 10) {
				System.out.println("자리가 없습니다.");
				seat();
			} else {
				System.out.println("식권을 " + n + "장 사용하였습니다.");
				sell += ((Customer) current).use(n);
				Keybord.sc.nextLine();
				System.out.println("남은 티켓은 " + ((Customer) current).getTicket() + " 장입니다.");
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
		System.out.println("긴급 휴일 날짜를 입력해주세요.");
		mm.remove(Keybord.sc.nextInt());
		Keybord.sc.nextLine();
	}

	public void print() {
		System.out.print("날짜입력 : ");
		mm.print(Keybord.sc.nextInt());
		Keybord.sc.nextLine();
	}

	public void printAll() {
		try {
			mm.printAll();
		} catch (Exception e) {
			System.out.println("등록된 식단이 없습니다.");
		}
	}

	public void addmenu() {
		if (current instanceof Admin) {
			System.out.print("식단 추가 날짜 입력 :");
			int day = Keybord.sc.nextInt();
			Keybord.sc.nextLine();
			Menu menu = new Menu();
			for (int i = 0; i < 4; i++) {
				System.out.print("메뉴입력 : ");
				menu.getMenu()[i] = Keybord.sc.nextLine();
			}
			mm.addmenu(day, menu);
		}
	}

	public void menumodify() {
		if (current instanceof Admin) {
			System.out.println("변경 날짜 입력 :");
			int day = Keybord.sc.nextInt();
			Keybord.sc.nextLine();

			Menu menu = new Menu();
			for (int i = 0; i < 4; i++) {
				System.out.print("메뉴입력 : ");
				menu.getMenu()[i] = Keybord.sc.nextLine();
			}
			mm.modify(day, menu);
		}
	}

}

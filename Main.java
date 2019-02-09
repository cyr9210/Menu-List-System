package kosta.lunch;

import kosta.baseball.Keybord;

public class Main {

	public static void main(String[] args) {
		Manager manager = new Manager();
		for (;;) {
			System.out.println("1.ȸ������ 2.�α��� 3.����");
			int m = Keybord.sc.nextInt();
			Keybord.sc.nextLine();

			switch (m) {
			case 1:
				try {
					manager.join();
					break;
				} catch (Exception e) {
					System.out.println("�̹� ������ ���̵� �ֽ��ϴ�.");		
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
					// 1.�Ա� 2.�ܾ���ȸ 3.�ıǱ��� 4.�Ĵܰ˻�(��¥) 5.�Ĵܰ˻�(�޴�) 6.��ý�Ĵ� 7.ȸ������ ��ȸ
					// 8.ȸ������ ���� 9.����
					//1.�Ĵ� �Է� 2.�Ĵ� ���� 3.��� ����(�Ĵ� �и�) 4.��ü�Ĵ� ��� 5.���� ���¼� �� ��ȸ 6.���� ���� ��ȸ 7.����
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
							System.out.println("�α׾ƿ�");
							break;
						}
						manager.information();
						continue;
					case 8 :
						manager.modify();
						continue;
						
					case 9:
						if(manager.getCurrent() instanceof Customer){
							System.out.println("�α׾ƿ�");
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

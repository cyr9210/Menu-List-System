package kosta.lunch;

import java.util.Arrays;

public class Menu {
	private String[] menu = new String[4];

	
	public Menu(){}
	
	public Menu(String menu1, String menu2, String menu3, String menu4) {
		menu[0] = menu1;
		menu[1] = menu2;
		menu[2] = menu3;
		menu[3] = menu4;
				
	}


	public void print(){
		for(int i =0; i<4; i++){
			System.out.println(menu[i]);
		}
	}

	@Override
	public String toString() {
		return "Menu [menu=" + menu[0] + "\n" + menu[1] + "\n"+ menu[2] + "\n"+ menu[3] + "]";
	}

	public String[] getMenu() {
		return menu;
	}

	public void setMenu(String[] menu) {
		this.menu = menu;
	}

	
	

}

package kosta.lunch;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MenuManager {
	List<Menu> menulist = new ArrayList<Menu>();
	Calendar cal = Calendar.getInstance();
	int daynum = cal.getActualMaximum(Calendar.DATE);

	public void addmenu(int day, Menu menu) {
		try {
			int n = day%daynum;
			if(n==0){
				n=daynum;
			}
			menulist.remove(n);
			menulist.add(n, menu);			
		} catch (Exception e) {
			for(int i = 0; i <= (32); i++){
				menulist.add(i, new Menu(" ", " ", " ", " "));
			}
			int n = day%daynum;
			if(n==0){
				n=daynum;
			}
			menulist.add(n, menu);
			menulist.remove(32);
		}
	}

	public void modify(int day, Menu menu) {
		menulist.remove(day);
		menulist.get(day).setMenu(menu.getMenu());
	}

	public void remove(int day) {
		menulist.add(day, new Menu("휴일", " ", " ", " "));
		menulist.remove(32);
	}

	public void print(int day) {
		menulist.get(day).print();
	}

	public void printAll()throws Exception{
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int week = cal.get(Calendar.WEEK_OF_MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int dayof = cal.get(Calendar.DAY_OF_WEEK);
		int endofweek =0;
		
		for(int i = 0; i < 7; i++){
			if((dayof+i)%7 == 0){
				endofweek = (day+i);
				break;				
			}
		}
		if(menulist.size() == 0){
			throw new Exception();
		}
		System.out.println(year + "년도 " + month + "월 " + week + "주차 식단" );
		System.out.println("일" + "\t" + "월" + "\t" + "화" + "\t" + "수" + "\t" + "목" + "\t" + "금" + "\t" + "토");
		for(int i =1; i < dayof; i++){
			System.out.print("\t");
		}
		for(int i = day; i <= endofweek; i++){
			int n = i%daynum;
			if(n == 0)
				n = daynum;
			System.out.print("#" + n +"#"+ "\t");
		}
		System.out.println();
		
		for(int j = 0; j < 4; j++){			
			for(int i =1; i < dayof; i++){
				System.out.print("\t");
			}
			for(int i = day; i <= endofweek; i++){
				int n = i%daynum;
				if(n == 0)
					n = daynum;
				System.out.print(menulist.get(n).getMenu()[j] + "\t" );
			}
			System.out.println();
		}
		for(int i = (endofweek+1); i <= (endofweek+7); i++){
			int n = i%daynum;
			if(n == 0)
				n = daynum;
			System.out.print("#" + n + "#" + "\t");
		}
		System.out.println();
		for(int j = 0; j <4; j++){	
			for(int i = (endofweek+1); i <= (endofweek+7); i++){
				int n = i%daynum;
				if(n == 0)
					n = daynum;
				System.out.print(menulist.get(n).getMenu()[j] + "\t");
			}
			System.out.println();
		}
	}

	public List<Menu> getMenulist() {
		return menulist;
	}

	public void setMenulist(List<Menu> menulist) {
		this.menulist = menulist;
	}
	 
}

package library.action.util;

import library.action.BaseAction;
import library.action.console.BookListConsoleImpl;

public class ActionManager {
	
	public static BaseAction defineAction(int action){
		
		BaseAction act = null;
		
		switch(action){
		case 1:
			act = new BookListConsoleImpl();
			break;
		case 2:
			break;
		}
		return act;
	}
}

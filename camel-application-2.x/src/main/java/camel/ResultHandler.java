package camel;

import java.util.List;

public class ResultHandler {

	public void printResult(List list) {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}

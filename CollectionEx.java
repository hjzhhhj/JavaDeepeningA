import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionEx {
	static void printList(LinkedList<String> l) {
		Iterator<String> iterator = l.iterator();
		while(iterator.hasNext()) {
			String e = iterator.next();
			String separator;
			if(iterator.hasNext()) {
				separator = "->";
			}
			else {
				separator = "\n";
			}
			System.out.println(e+separator);
		}
 	}

	public static void main(String[] args) {
		LinkedList<String> myList = new LinkedList<>();
		myList.add("트랜스포머");
		myList.add("스타워즈");
		myList.add("매트릭스");
		myList.add(0,"터미네이터");
		myList.add(2,"아바타");
		
		Collections.sort(myList);
		Collections.reverse(myList);
		
		int index = Collections.binarySearch(myList, "트랜스포머") + 1;
		System.out.println("트랜스포머는 " + index + "번째 요소입니다.");
	}

}
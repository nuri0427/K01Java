package ex17collection;

import java.util.ArrayList;
import java.util.Iterator;
import common.Student;

public class Ex03ArrayList2 {

	public static void main(String[] args) {
		
		/*
		아래 2개의 컬렉션은 내부적인 자료구조만 다르고 구현방법은 모두 동일하다. 
		컬렉션 생성시 Student 형의 타입매개변수를 사용한다.
		*/
		
		// LinkedList<Student> list2 = new LinkedList<Student>();
		ArrayList<Student> list2 = new ArrayList<Student>();
		
		// 개발자가 정의한 인스턴스 생성(외부패키지)
		Student st1 = new Student("정우성" , 10 , "2018");
		Student st2 = new Student("원빈" , 20 , "2017");
		Student st3 = new Student("장동건" , 30 , "2016");
		Student st4 = new Student("공유" , 40 , "2018");
		
		// 컬렉션에 인스턴스 저장
		list2.add(st1); // 인덱스 0
		list2.add(st2);
		list2.add(st3);
		list2.add(st4); // 인덱스 3
		list2.add(st2); // 객체의 중복저장 (위에 st2가 있다.) List 컬렉션은 허용된다.
		
		System.out.println("[중복저장 후]");
		
		for(Student st : list2) {
			st.showInfo();
		}
		
		/*
		 객체 삭제: 인덱스가 아닌 인스턴스의 참조값을 통해 삭제하는 경우 중복 된 객체가 있으면 앞에 있는 객체 하나만 삭제 된다. 
		 (인스턴스의 참조 값을 통해 삭제한다.)
		*/
		list2.remove(st2);
		System.out.println("[중복 저장 된 객체 삭제 후]");
		
		for(Student st : list2) {
			st.showInfo();
		}
		
		System.out.println("[반복자 사용]");
		Iterator<Student> it2 = list2.iterator();
		while(it2.hasNext()) {
			Student student = it2.next();
			student.showInfo();
			
			/*
			위와 동일한 문장이다. next() 를 통해 객체를 가져온 후 
			showInfo() 로 객체의 내용을 출력한다.
			*/
			it2.next().showInfo();
		}
		
		// List 계열의 컬렉션은 인덱스로 접근 가능하다.
		System.out.println("[일반 for문 사용]");
		for(int i = 0; i < list2.size(); i++) {
			// 인덱스로 접근시 get() 메소드를 사용한다.
			list2.get(i).showInfo();
		}
		
		System.out.println("[확장 for문 사용]");
		for(Student st : list2) {
			st.showInfo();
		}
		
		// 인덱스를 통한 삭제 : 삭제 성공시 해당객체가 반환 된다.
		System.out.println("삭제 된 객체의 이름 : " + list2.remove(2).name);
		
		// 인스턴스 참조값을 통한 삭제 : 삭제 성공시 boolean 값이 반환된다.
		System.out.println("인스턴스를 통한 삭제 : " + list2.remove(st1));
		
		System.out.println("[인스턴스 삭제 후");
		for(Student st : list2) {
			st.showInfo();
		}
	}
}
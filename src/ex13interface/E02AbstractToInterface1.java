package ex13interface;

/*
추상클래스
- 상속을 목적으로 제작되므로 객체생성을 허용하지 않는다.
- 추상클래스는 대부분 추상메소드를 포함하고 있으므로 이를 상속받는 클래스는 반드시 추상메소드를 오버라이딩 해야한다.
- 클래스의 상속관계에서의 설계도 역할을 한다.
- 객체생성은 할 수 없으나 그 외 참조변수 , 상속 등의 모든 기능을 가지고 있다.

추상메소드
- 오버라이딩의 목적으로 제작된다.
- 함수의 실행부가 없기 때문에 {} 를 쓰지 않고 함수의 원형에 ; 을 붙여준다.
*/

// 프로젝트 전체에서 기준이 될 수 있는 추상클래스 정의
abstract class PersonalNumberStorageAbs {
	
	public abstract void addPersonalInfo(String juminNum , String name);
	
	public abstract String searchPersonalInfo(String juminNum);
}

/*
한 사람의 정보를 저장하기 위한 DTO 클래스 . 혹은 VO (Value Object) 라고도 한다.
*/
class PersonalInfoDTO {
	
	// 멤버변수 : private 으로 선언
	private String name;
	private String juminNum;
	
	// 생성자
	public PersonalInfoDTO(String name , String juminNum) {
		
		this.name = name;
		this.juminNum = juminNum;
	}
	
	// private 멤버를 반환하는 용도의 getter() 메소드
	String getName() { return name; }
	String getJuminNum() { return juminNum; }
	
}

/*
제공 된 추상클래스를 상속하여 사람의 정보를 저장하는 기능과 
검색의 기능을 구현한 클래스
*/
class PersonalNumberStorageExt extends PersonalNumberStorageAbs {
	
	
	// 멤버변수
	PersonalInfoDTO[] personalArr; // 정보저장용 객체배열
	int numOfPerInfo; // 입력정보 카운트용 변수
	
	public PersonalNumberStorageExt(int arrSize) {
		
		personalArr = new PersonalInfoDTO[arrSize];
		
		numOfPerInfo = 0;
	}
	
	/*
	상속을 통해 추상메소드를 포함하게 되었으므로 반드시 아래와 같이 
	필수적으로 오버라이딩 해야 한다. 
	
	전달 받은 인자를 통해 DTO 객체를 생성한 후 객체배열에 추가한다.
	*/
	@Override
	public void addPersonalInfo(String juminNum , String name) {
		personalArr[numOfPerInfo] = new PersonalInfoDTO(name , juminNum);
		numOfPerInfo++;
	}
	/*
	주민번호를 인자로 전달 받아 객체배열에 저장 된 정보를 검색한 후 일치하는 경우에만 이름을 반환한다.
	*/
	@Override
	public String searchPersonalInfo(String juminNum) {
		
		for (int i = 0; i < numOfPerInfo ; i++) {
			
			//멤버변수가 private 이므로 getter 를 통해 반환 받고 있다.
			if (juminNum.compareTo(personalArr[i].getJuminNum()) == 0) {
				
				// getter 를 통해 이름을 반환한다.
				return personalArr[i].getName();
			}
		}
		
		return null; // 검색결과가 없는 경우 null 반환
	}
}
public class E02AbstractToInterface1 {

	public static void main(String[] args) {
		
		// 객체생성
		PersonalNumberStorageExt storage = new PersonalNumberStorageExt(10);
		
		// 정보 추가
		storage.addPersonalInfo("901234-2222222" , "김태희");
		storage.addPersonalInfo("901234-1111111" , "정지훈");
		
		// 검색
		System.out.println(storage.searchPersonalInfo("901234-2222222"));
		System.out.println(storage.searchPersonalInfo("901234-1111111"));
		System.out.println(storage.searchPersonalInfo("001234-1090333"));
	}

}

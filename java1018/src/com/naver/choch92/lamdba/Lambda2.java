package com.naver.choch92.lamdba;

// 메소드가 1개만 선언되어있는지 확인해주는 어노테이션
// 매개변수가 없는 추상메소드를 가진 인터페이스
@FunctionalInterface
interface Inter1{
	public void method();
}
// 매개변수가 있는 추상메소드를 가진 인터페이스
@FunctionalInterface
interface Inter2{
	public void method(int i);
}
// 리턴이 있는 추상메소드를 가진 인터페이스
@FunctionalInterface
interface Inter3{
	public int method(int i, int j);
}

public class Lambda2 {
	public static void main(String[] args) {
		Inter1 inter1 = () -> {
			System.out.printf("매개변수 없는 람다\n");
		};
		inter1.method();
		
		Inter2 inter2 = i -> {
			for(int x=0; x<i; x=x+1) {
				System.out.printf("매개변수 있는 람다\n");
			}
		};
		inter2.method(3);
		
		Inter3 inter3 = (i,j) -> {
			return (i+j)/2;
		};
		int result = inter3.method(5,8);
		System.out.printf("result:%s\n", result);
		
		Inter3 inter4 = new Inter3() {
			public int method(int i, int j) {
				return (i+j)/2;
			}
		};
	}
}

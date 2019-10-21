package com.naver.choch92.lamdba;

import java.util.ArrayList;
import java.util.List;

public class Lambda3 {

	public static void main(String[] args) {
		// 문자열을 저장하는 List를 생성하고 데이터를 저장
		List<String> list = new ArrayList<>();
		list.add("골든스노우치킨");
		list.add("양념치킨");
		list.add("갈비맛치킨");
		list.add("간장치킨");
		list.add("핫쇼킹치킨");
		list.add("파닭순살치킨");
		// 위의 데이터를 순서대로 하나씩 출력
		// 제일 안좋은 방법(브론즈티어) - for(int i=0; i<list.size(); i=i+1)
		int len = list.size();
		for(int i=0; i<len; i=i+1) {
			System.out.println(list.get(i));
		}
		// 그나마 나은 방법(실버티어) - 빠른열거
		for(String imsi : list) {
			System.out.println(imsi);
		}
		// List에 함수를 매개변수로 대입해서 List의 모든 데이터를 함수의 매개변수로 대입해서 실행
		// 1.8 version에서 부터 가능 - 골드티어(코드간결,속도최강,데이터소모적음)
		// 이 기능은 C언어를 제외한 거의 모든 프로그래밍언어에 존재하는 기능인데 대부분은 map이라고 합니다.
		list.forEach(System.out::println);
	}
}

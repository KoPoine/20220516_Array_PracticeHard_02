package codes;

import java.util.Scanner;

public class MainDrive {
	public static void main(String[] args) {
		
//		1. 컴퓨터의 난수 값 3개를 배열로 받는다.
		int[] testNum = new int[3];
		
		for (int i = 0; i < testNum.length;i++) {
			
			while (true) {
				int randomNum = (int) (Math.random()*9+1);
				
				boolean isRepeat = false;
				
				for (int num : testNum) {
					if (num == randomNum) {
						isRepeat = true;
					}
				}
				
				if(!isRepeat) {
					testNum[i] = randomNum;
					System.out.println(randomNum);
					break;
				}
			}	
		}
				
		Scanner myScanner = new Scanner(System.in);
		

		int totalCount = 0;
		
		while(true) {
			
//			2. 사용자의 3자리 숫자를 받아서 배열로 만들어 준다.
			System.out.print("답안 제출 : ");
			int inputNum = myScanner.nextInt();
			
			totalCount++; 
			
//			2-1 사용자가 입력한 값을 넣을 3칸짜리 배열을 생성 
			int[] myNum = new int[3];
			
//			100의 자리 숫자가 myNum[0]에 들어가도록 역순으로 넣어준다.
			for(int i = myNum.length-1; i >= 0; i--) {			
				myNum[i] = inputNum % 10;
				inputNum /= 10;
				if (inputNum == 0) {
					break;
				}
			}
			
//			3. 컴퓨터가 S / B 계산해주는 로직
			int sCount = 0;
			int bCount = 0;
			
			for (int i = 0; i < myNum.length; i++) {
				for (int j = 0; j < testNum.length; j++) {
					if (myNum[i] == testNum[j]) {
						if (i == j) {
							sCount++;
						}
						else {
							bCount++;
						}
					}
				}
			}
			
			
//			4. S / B 계산값을 출력
			if (sCount == 3) {
				System.out.println("삼진입니다. 축하합니다.");
				break;
			}
			else {
				System.out.println(sCount + "S" + bCount + "B입니다.");
			}
		}		
		System.out.println("총 "+totalCount+"회 만에 맞추었습니다.");
	}
}

package kadai5;

import java.util.Scanner;

public class IntToEng {

	    // メインメソッド
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
	    int input = sc.nextInt();

	    System.out.println(translateEng(input));

	}

	// 数値を英訳する変換するメソッド
	static String translateEng(int n) {
	String ans = "";
	String[] oneR = {"zero ","one ","two ","three ","four ","five ","six ","seven","eight ","nine "};
	String[] tenR1 = {"ten ","eleven ","twelve ","thirteen ","fourteen ","fifteen ","sixteen ","seventeen ","eighteen ","nignteen "};
	String[] tenR2 = {"twenty ","thirty ","fourty ","fifty ","sixty ","seventy ","eighty ","ninety "};
	String hund = "hundred ";
	if(numberOfDigits(n)==1){
		ans = oneR[n];
	}else if(numberOfDigits(n)==2&&n/10==1){
		ans = tenR1[n%10];
	}else if(numberOfDigits(n)==2){
		if(tenZero(n)){	
			ans = tenR2[(n/10)-2];
		}else{
			ans = tenR2[(n/10)-2] + oneR[n%10];
		}
	}else if(numberOfDigits(n)==3){
		if(tenZero(n)&&hundZero(n)){
			ans = oneR[n/100]+hund;
		}else if(!hundZero(n)){
			if(tenZero(n)){
				if(n%100==10){
					ans = oneR[n/100] + hund + tenR1[0];
				}else{
					ans = oneR[n/100] + hund + tenR2[(n%100)/10-2];
				}
			}else{
				ans = oneR[n/100] + hund + tenR2[(n%100)/10-2] + oneR[n%10];
			}
		}
	}
	return ans;
	}
	
	static int numberOfDigits(int n){
		if(String.valueOf(n).length()==1){
			return 1;
		}else if(String.valueOf(n).length()==2){
			return 2;
		}else{
			return 3;
		}
	}
	static boolean tenZero(int n){
		if(n%10 == 0){
			return true;
		}else{
			return false;
		}
	}
	static boolean hundZero(int n){
		if(n%100==0){
			return true;
		}else{
			return false;
		}
	}
}
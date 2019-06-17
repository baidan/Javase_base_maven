package base;

import org.junit.Test;

public class ArrayDemo{
	public static void main(String[] args){
		//System.out.println("ArrayDemo====");
		//求数组中的最大值
		int[] arr= {11,23,2,78,32,-33,88,90,67};
		ArrayDemo ad=new ArrayDemo();
		int max = ad.getArrMax(arr);
		int min = ad.getArrMin(arr);
		System.out.println("max==="+max);
		System.out.println("min==="+min);

		String toSs = ad.toString(arr);
		System.out.println("toSs==="+toSs);

		int num = 60;

		String hex =  ad.getIntToHex(num);
		System.out.println("hex==="+hex);

	}

	@Test
	public  String toString(int arr[]){
		if(arr.length>0){
			String max = arr[0]+"";
			for(int i = 1; i<arr.length;i++){
				max += ","+arr[i];
			}
			return max;
		}
		return null;
	}

	@Test
	public  int getArrMax(int arr[]){
		if(arr.length>0){
			int max = arr[0];
			for(int i = 1; i<arr.length;i++){
				if(arr[i]>max){					
					max = arr[i];
				}
			}
			return max;
		}
		return 0;
	}
	@Test
	public  int getArrMin(int arr[]){
		if(arr.length>0){
			int min = arr[0];
			for(int i = 1; i<arr.length;i++){
				if(arr[i]<min){					
					min = arr[i];
				}
			}
			return min;
		}
		return 0;
	}

	//需求：将十进制转换为十六进制
	/*
		分析：
			1，十进制——>二进制——>十六进制，思路考虑转换成二进制后进制转换
			2，最低4位每次&上二进制的1111（也就是十进制的15），拿到了转换的16进制的四个低位
			3，把二进制的8个8位，拆分成16个4位，及是10进制，需要每次做无符号右移4位后截取；  
	*/
	@Test
	public  String getIntToHex(int num){
		char[] chars = new char[8];
		int index = chars.length;
		while(num != 0){
			int temp = num & 15;
			
			//备注 --index  先减1，再赋值运算，所以第一个就是7，不会角标越界了。
			if(temp >9)
				chars[--index] = (char)(temp - 10 + 'A' );
			else
				chars[--index] = (char)(temp + '0');

			num = num >>> 4;
		}
		return "0x"+getCharToString(chars,index);
	}
	@Test
	public  String getCharToString(char[] arr, int index){
		if(arr.length>0){
			String max = "";
			for(int i = index; i<arr.length;i++){
				max += arr[i];
			}
			return max;
		}
		return null;
	}
}
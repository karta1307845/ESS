import java.util.Arrays;
import java.util.Scanner;
/**
 * UVA 612 - DNA Sorting
 * @author 蘇信嘉
 * @see DNA
 */
public class A410477020_13_1 {
	/**
	 * 程式進入點
	 * @param args 無
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int datasets = input.nextInt();//幾組資料
		for (int i = 0; i < datasets; i++) {
			DNA[] DNAarray = getData(input);//取得存放DNA物件的陣列
			Arrays.sort(DNAarray);//排序DNA物件
			for (DNA j : DNAarray) {//依序印出
				System.out.println(j.getString());
			}
			if (i != datasets - 1) {//不是最後一組資料，需要空一行隔開
				System.out.println();
			}
		}
		input.close();
	}
	/**
	 * 取得存放DNA物件的陣列
	 * @param input Scanner
	 * @return 存放DNA物件的陣列
	 */
	static DNA[] getData(Scanner input) {//傳入Scanner
		input.nextInt();//DNA長度
		int lines = input.nextInt();//DNA行數
		DNA[] DNAarray = new DNA[lines];//產生存放DNA物件的陣列
		input.nextLine();
		for (int i = 0; i < lines; i++) {//產生DNA物件，存入陣列
			DNAarray[i] = new DNA(input.nextLine());
		}
		return DNAarray;//回傳存放DNA物件的陣列
	}
}
/**
 * DNA類別
 * @author 蘇信嘉
 */
class DNA implements Comparable<DNA> {
	/**未排序程度*/
	private int inversions;
	/**DNA字串*/
	private String DNAstring;
	/**
	 * 建立DNA物件，算出未排序程度
	 * @param str DNA資料
	 */
	public DNA(String str) {
		DNAstring = str;
		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) > str.charAt(j)) {
					inversions++;
				}
			}
		}
	}
	/**
	 * 比較DNA物件的未排序程度
	 * @param obj DNA物件
	 * @return 負數、0、正數
	 */
	@Override
	public int compareTo(DNA obj) {
		return this.inversions - obj.inversions;
	}
	/**
	 * 取得DNA字串
	 * @return DNA字串
	 */
	public String getString(){
		return DNAstring;
	}
}
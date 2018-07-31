/**
 * 
 */
package github_project_1;

/**
 * @author ningmengmao
 *
 */
public class hello_world {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		int id[] = new int[10];
		for(int i = 0 ; i < 10; i++)
			id[i] = i;
		for(int i : id)
			System.out.println(i);
		*/
		int nums[][] = new int[5][10];
		for(int i=0; i<5; i++)
			for(int j=0; j<10; j++)
				nums[i][j] = i + j;
		for(int x[]:nums) {
			for(int y:x)
				System.out.print(y+" ");
			System.out.println();
		}
	}
}

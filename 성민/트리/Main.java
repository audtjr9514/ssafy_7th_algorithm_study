import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n=Integer.parseInt(br.readLine());
		
		
		int students[][]=new int[3][5]; //번호,점수count들,총합 구현 할 배열
		
		for(int i=0;i<3;i++) { //후보 번호 1,2,3 (i+1) 을 해준다.
			students[i][0]=i+1;
		}
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<3;j++) {
				students[j][Integer.parseInt(st.nextToken())]++; // 학생별로 해당 점수 배열 증가
			}
		}
		
		for(int i=0;i<3;i++) {
			for(int j=1;j<4;j++) {
				students[i][4]+=students[i][j]*j;  // 개수 * 점수 (총점만들기)
			}
		}
		
		//람다식 이용한 정렬
		Arrays.sort(students,(o1,o2)->{
			if(o1[4]==o2[4]) { // 총점 같다면 
				if(o1[3]==o2[3]) { // 총점이 같은데 3점 개수도 같다면
					if(o1[2]==o1[2]) { //마찬가지로 2점 개수 같은 경우
						return Integer.compare(o1[1], o2[1])*-1; // 1점 개수를 비교해서 역순으로 
					}else {
						return Integer.compare(o1[2], o2[2])*-1;
					}
				}else {
					return Integer.compare(o1[3], o2[3])*-1;
				}
			}else {
				return Integer.compare(o1[4], o2[4])*-1;
			}
		});
		// 정렬을 역순으로 했기 때문에 앞에 나온게 가장 큰 값
		
		boolean same = true;
		for(int i = 4; i >= 1; i--) {
			if(students[0][i] != students[1][i]) { // 앞에 나오는 값이 큰 값이므로 상위 2명만 비교
				same = false;
				break;
			}
		}
			
		if(same) { //same 이라는 건 총점 3점개수 2점개수 1점개수 다 같다는 것이기 때문에 문제조건대로 0 출력
			System.out.println(0+" "+students[0][4]);
		}
		else {
			System.out.println(students[0][0]+" "+students[0][4]);
			
		}
		
	}
		
}

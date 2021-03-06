package math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 소수 구하기
 * 문제 발생 : 에라토스테네스의 체를 사용하지 않고 일반 반복문을 이용해서 풀었을 때 시간 제한에 걸렸다.
 * 해결 : 에라토스테네스의 체(소수를 판별하는 알고리즘) 사용
 * 어떤 수의 소수의 여부를 확인 할 때는, 특정한 숫자의 제곱근 까지만 약수의 여부를 검증하면 된다.
 * 가장 먼저 소수를 판별할 범위만큼 배열을 할당하여, 해당하는 값을 넣어주고, 이후에 하나씩 지워나가는 방법을 이용
 * 예) 3 과 16 사이의 소수를 구해보자 !
 */
public class Joon1929_1 {
    public static boolean prime[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int m = Integer.parseInt(st.nextToken()); // 3
        int n = Integer.parseInt(st.nextToken()); // 16

        prime = new boolean[n+1]; // 17
        get_prime();

        StringBuilder sb = new StringBuilder();
        for (int i = m; i <= n; i++){
            // 만약 prime[i] 가 false 이면?
            if(!prime[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    // 에라토스테네스의 체 알고리즘
    public static void get_prime(){

        // true = 소수아님, false = 소수
        prime[0] = prime[1] = true;
        
        // 제곱근 함수 : Math.sqrt()
        for(int i =2; i <= Math.sqrt(prime.length); i++){ // 2, 3, 4
            if(prime[i]) continue; // 이미 체크된 배열이면 다음 반복문으로 skip
            
            //i 의 배수들을 걸러주기 위한 반복문
            for(int j = i*i; j < prime.length; j += i){
                // 4 < 17, 4,6,8,10,12,14,16
                // 9 < 17, 9,12,15
                // 16 < 17, 16
                prime[j] = true;
            }
        }
    }
}

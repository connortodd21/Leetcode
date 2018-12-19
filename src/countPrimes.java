public class countPrimes {

    public int countPrimesBasic(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if(isPrime(i)){
                count++;
            }
        }
        return count;
    }

    public boolean isPrime(int n){
        for (int i = 2; i*i <= n; i++) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    public int countPrimes(int n){
        if(n <= 2){
            return 0;
        }
        if(n == 3){
            return 1;
        }
        int count = 0;
        boolean[] sieve = new boolean[n+1];
        sieve[n] = true;
        for (int i = 2; i*i <= n; i++) {
            if(!sieve[i]){
                for (int j = i*i; j <= n; j+=i) {
                    sieve[j] = true;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if(!sieve[i]){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        countPrimes c = new countPrimes();
        System.out.println(c.countPrimes(5));
    }
}

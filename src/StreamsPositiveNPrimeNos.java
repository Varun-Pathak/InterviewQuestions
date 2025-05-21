import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsPositiveNPrimeNos {
    // Use this editor to write, compile and run your Java code online


        public static void main(String[] args) {
            /*int[] arr = {1,-1, 2,3,6,7,11,13,14,8,-9};
            int[] array = Arrays.stream(arr)
                    .filter(n -> n >= 0)
                    .filter(Test2::isPrime)
                    .toArray();
            System.out.println(Arrays.toString(array));*/
            List<Integer> list1 = Arrays.asList(1,4,6,12,5);
            List<Integer> list2 = Arrays.asList(22,24,26,212,500);
            //boolean res = list.stream().anyMatch(Main::isPrime);
            List<Integer> list = Stream.concat(list1.stream(), list2.stream())
                    .sorted()
                    .collect(Collectors.toList());

        }

        private static boolean isPrime(int num){
            if (num <= 1)
                return false;
            if (num==2)
                return true;
            if (num%2==0)
                return false;
            for (int i = 3; i <= Math.sqrt(num); i+=2) {
                if (num%i==0)
                    return false;
            }
            return true;

        }
}

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n0 = 1;
        int n1 = 1;
        int n2 ;
        System.out.println("Числа Фібоначчі:");
        System.out.print(n0+" "+n1+" ");
        List <Integer> f = new ArrayList<>();
        f.add(n1);
        for(int i = 3; i <= 10; i++){
            n2=n0+n1;
            System.out.print(n2+" ");
            f.add(n2);
            n0=n1;
            n1=n2;
        }
        System.out.println();
        System.out.println("Трикутні числа:");
        List<Integer> t = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            int triangular = 0;

            for (int j = 1; j <= i; j++) {
                triangular = triangular + j;
            }
            t.add(triangular);
            System.out.print(triangular + " ");

    }
        System.out.println();
        System.out.println("Числа Фібоначчі, які можна задати у формі трикутних чисел: ");
        for(int i = 0; i < f.size(); i++){
            for(int j = 0; j<t.size();j++){
                if(f.get(i)==t.get(j)){
                    System.out.print(f.get(i)+" ");
                    break;
                }
            }
        }

}}
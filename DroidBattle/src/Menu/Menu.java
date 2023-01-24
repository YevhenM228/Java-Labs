package Menu;

import java.util.ArrayList;
import java.util.Scanner;

import Battles.Battles;


import Droids.*;


public class Menu {

    private final ArrayList<BaseDroid> droids = new ArrayList<BaseDroid>();
    private final Scanner input = new Scanner(System.in);

    public void start(){
        while(true) {
            printMenu();
            int choice = safeScanInt(5);
            switch (choice) {

                case 1:
                    droids.add(createDroid());
                    break;
                case 2:
                    printAllDroids();
                    break;
                case 3: {
                    if (droids.size() < 2) {
                        System.out.println("Створена недостання кількість дроїдів!");
                        break;
                    }
                    var droidsParticipants = chooseDroids();

                    Battles.oneVsOne(droidsParticipants[0], droidsParticipants[1]);

                    break;
                }
                case 4: {
                    if (droids.size() < 6) {
                        System.out.println("Створена недостання кількість дроїдів!");
                        break;
                    }
                    var droidsParticipants = chooseDroidsForTeamFight();
                    Battles.threeVsThree(droidsParticipants[0], droidsParticipants[1]);
                    break;
                }
                default:
                    return;
            }
        }
    }

    private void printMenu(){
        System.out.println("\n"+"""
                (1) Створити дроїда
                (2) Показати створених дроїдів
                (3) Бій 1 на 1
                (4) Бій 3 на 3
                (5) Завершити програму""");
    }

    private void printAllDroids(){
        int i = 1;
        System.out.println("Створені дроїди:");
        for (var droid: droids) {
            System.out.printf("#%d. Name = %s\n\tType = %s\n",i++,droid.getName(),droid.getType());
        }
    }

    private int safeScanInt(int end){
        int result;
        while(true){
            try{
                result = input.nextInt();
                if (result < 1 || result > end) throw new Exception();
                return result;
            }catch (Exception e){
                System.out.println("invalid input! try again");
            }
        }
    }
    private BaseDroid createDroid(){
        System.out.println("""
                Оберіть клас дроїда:
                (1) Танк
                (2) Асасин
                (3) Лікар
                (4) Берсерк""");
        int droidType = safeScanInt(4);
        System.out.println("Введіть ім'я дроїда");
        var name = input.next();

        return switch (droidType) {
            case 1 -> new TankDroid(name);
            case 2 -> new AssassinDroid(name);
            case 3 -> new HealerDroid(name);
            default -> new BerserkDroid(name);
        };
    }

    private BaseDroid[] chooseDroids(){
        int[] used = new int[2];
        var result = new BaseDroid[2];
        int maxCount = droids.size();
        printAllDroids();
        for (int i = 0; i < 2; i++){
            int n;
            while (true) {
                n = safeScanInt(maxCount);
                if(!arrayContains(used,n)) break;
                System.out.println("Цей дроїд вже був обратний");
            }
            used[i] = n;
            System.out.println("Дроїда додано");
            result[i] = droids.get(n - 1);
        }
        return result;
    }

    private BaseDroid[][] chooseDroidsForTeamFight (){
        int[] used = new int[2* 3];
        var result = new BaseDroid[2][3];
        int maxCount = droids.size();
        printAllDroids();
        for(int j = 0; j<2;j++ ) {
            System.out.println("Оберіть дроїдів для команди"+(j+1));
            for (int i = 0; i < 3; i++) {
                int n;
                while (true) {
                    n = safeScanInt(maxCount);
                    if (!arrayContains(used, n)) break;
                    System.out.println("Цей дроїд вже був обратний");
                }
                used[i+3*j] = n;
                System.out.println("Дроїда додано");
                result[j][i] = droids.get(n - 1);
            }
        }
        return result;
    }

    private boolean arrayContains(int[] used, int value){
        for (int i : used) {
            if (i == value) return true;
        }
        return false;
    }


}

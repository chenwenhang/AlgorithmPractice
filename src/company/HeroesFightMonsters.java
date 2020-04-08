package company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Wenhang Chen
 * @Description:
 * @Date: Created in 19:38 4/7/2020
 * @Modified by:
 */
public class HeroesFightMonsters {
    static class Monster {
        int defend;
        int attack;

        public Monster(int defend, int attack) {
            this.attack = attack;
            this.defend = defend;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int D = sc.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            // 破防
            a[i][0] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            // 伤害
            a[i][1] = sc.nextInt();
        }
        List<Monster> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Monster(a[i][0], a[i][1]));
        }
        list.sort(new Comparator<Monster>() {
            @Override
            public int compare(Monster o1, Monster o2) {
                if (o1.defend > o2.defend || o1.defend == o2.defend && o1.attack > o2.attack) {
                    return 1;
                } else if (o1.defend == o2.defend && o1.attack == o2.attack) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        long damage = 0;
        for (Monster monster : list) {
            if (monster.defend <= D) {
                D++;
            } else {
                D++;
                damage += monster.attack;
            }
        }
        System.out.println(damage);
    }
}
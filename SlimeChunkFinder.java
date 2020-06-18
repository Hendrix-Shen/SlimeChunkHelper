import java.util.Random;
import java.util.*;
public class SlimeChunkFinder {
    public static void main(String[] args) {
        long seed = ;       //世界种子
        int X_Start = -500; //起始X区块坐标
        int X_Stop = 500;   //终止X区块坐标
        int Z_Start = -500; //起始Z区块坐标
        int Z_Stop = 500;   //终止Z区块坐标
        int X_F = 17;       //史莱姆农场X轴上的长
        int Z_F = 17;       //史莱姆农场Z轴上的长
        System.out.println("使用种子:" + seed);
        for(int a = X_Start; a < X_Stop; a++) {
            for (int b = Z_Start; b < Z_Stop; b++) {
                A(seed, a, X_F, b, Z_F);
            }
        }
    }
    public static void A(long seed, int X_Start, int X_F, int Z_Start, int Z_F) {
        int Counter = 0;
        if (X_F > 0 && Z_F > 0) {
            System.out.println("X起始区块坐标:" + X_Start + "(区域范围:" + X_F + ")");
            System.out.println("Z起始区块坐标:" + Z_Start + "(区域范围:" + Z_F + ")");
            int X_L = X_Start + X_F;
            int Z_L = Z_Start + Z_F;
            String Row = "";
            for (int xPosition = X_Start; xPosition < X_L; xPosition++) {
                for (int zPosition = Z_Start; zPosition < Z_L; zPosition++) {
                    Random rnd = new Random(
                    seed + (int) (xPosition * xPosition * 0x4c1906) + (int) (xPosition * 0x5ac0db) + (int) (zPosition * zPosition) * 0x4307a7L + (int) (zPosition * 0x5f24f) ^ 0x3ad8025f);
                    if (rnd.nextInt(10) == 0) {
                        Row = Row + "■";
                        Counter += 1;
                    } else {
                        Row = Row + "□";
                    }
                }
                Row = Row + "\n";
            }
            if (Counter >= 50) {
                System.out.println(Row);
                System.out.println("发现史莱姆区块:" +  Counter);
            }
        } else {
            System.out.println("请不要使用负探索范围");
        }
    }
}
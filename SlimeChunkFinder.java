import java.util.Random;
import java.util.*;
public class SlimeChunkFinder {
    public static void main(String[] args) {
        long seed = ;       //��������
        int X_Start = -500; //��ʼX��������
        int X_Stop = 500;   //��ֹX��������
        int Z_Start = -500; //��ʼZ��������
        int Z_Stop = 500;   //��ֹZ��������
        int X_F = 17;       //ʷ��ķũ��X���ϵĳ�
        int Z_F = 17;       //ʷ��ķũ��Z���ϵĳ�
        System.out.println("ʹ������:" + seed);
        for(int a = X_Start; a < X_Stop; a++) {
            for (int b = Z_Start; b < Z_Stop; b++) {
                A(seed, a, X_F, b, Z_F);
            }
        }
    }
    public static void A(long seed, int X_Start, int X_F, int Z_Start, int Z_F) {
        int Counter = 0;
        if (X_F > 0 && Z_F > 0) {
            System.out.println("X��ʼ��������:" + X_Start + "(����Χ:" + X_F + ")");
            System.out.println("Z��ʼ��������:" + Z_Start + "(����Χ:" + Z_F + ")");
            int X_L = X_Start + X_F;
            int Z_L = Z_Start + Z_F;
            String Row = "";
            for (int xPosition = X_Start; xPosition < X_L; xPosition++) {
                for (int zPosition = Z_Start; zPosition < Z_L; zPosition++) {
                    Random rnd = new Random(
                    seed + (int) (xPosition * xPosition * 0x4c1906) + (int) (xPosition * 0x5ac0db) + (int) (zPosition * zPosition) * 0x4307a7L + (int) (zPosition * 0x5f24f) ^ 0x3ad8025f);
                    if (rnd.nextInt(10) == 0) {
                        Row = Row + "��";
                        Counter += 1;
                    } else {
                        Row = Row + "��";
                    }
                }
                Row = Row + "\n";
            }
            if (Counter >= 50) {
                System.out.println(Row);
                System.out.println("����ʷ��ķ����:" +  Counter);
            }
        } else {
            System.out.println("�벻Ҫʹ�ø�̽����Χ");
        }
    }
}
package jp.ac.uryukyu.ie.e165748;

/**
 * Created by e165748 on 2/1/17.
 */

import java.util.Scanner;
import java.util.Random;

public class Solver {

    private static final int yoko = 3;
    private static final int tate = 3;
    private static final String naka = " ";
    private String NakaWaku[][] = new String[yoko][tate];
    private String copNakaWaku[][] = new String[yoko][tate];
    private String PlayerName;

    // 基準として一つ客値が順番に配置された行列を作成
    public void InNumber() {

        int a = 1;

        Fill:
        for (int i = 0; i < yoko; i++) {
            for (int j = 0; j < tate; j++) {
                if (i == (yoko - 1) && j == (tate - 1)) {
                    NakaWaku[i][j] = naka;
                    copNakaWaku[i][j] = naka;
                    break Fill;
                }
                NakaWaku[i][j] = Integer.toString(a);
                copNakaWaku[i][j] = Integer.toString(a);
                a++;
            }
        }
    }

    //プレイヤーが相互作用するたび、客数値が変換する行列を作成
    public void RanInNumber() {
        Random random = new Random();
        String temp;//一つのブランクを作成
        for (int i = 0; i < yoko; i++) {
            for (int j = 0; j < tate; j++) {
                int guSu = random.nextInt(3);
                temp = NakaWaku[guSu][guSu];
                NakaWaku[guSu][guSu] = NakaWaku[i][j];
                NakaWaku[i][j] = temp;
            }
        }
    }

    //プレイヤーが相互作用する行列を表示
    public void inWaku() {
        for (int i = 0; i < yoko; i++) {
            for (int j = 0; j < tate; j++) {
                System.out.printf("[%s]", NakaWaku[i][j]);
            }
            System.out.println();
        }
    }

    public void setPlayerName(String PlayerName) {

        this.PlayerName = PlayerName;
    }

    public String getPlayerName() {

        return PlayerName;
    }

    public void inRuRu(String Name) {
        System.out.println("__________________________________");
        System.out.println(" おはよう" + Name);
        System.out.println(" 客キー'A','D','W','S'を使って下さい");
        System.out.println("'A' は左行きキーである");
        System.out.println("'D' は右行きキーである");
        System.out.println("'W' は上行きキーである");
        System.out.println("'S' は下行きキーである");
        System.out.println("ゲームが終わりの時あなたが勝ちます");
        System.out.println("頑張って下さい ");
        System.out.println("------------------------------------");
    }

    //客キーの機能を作成
    //a は左行き機能
    //d は右行き機能
    //w は上行き機能
    //s は下行き機能
    public void play(String InChar){
        String temp = "h";
        Continue:
        for (int i = 0; i < yoko; i++) {
            for (int j = 0; j < tate; j++) {
                if (NakaWaku[i][j].equals(naka)) {
                    if (InChar.equals("s")&& i!=0) {
                        temp = NakaWaku[i - 1][j];
                        NakaWaku[i - 1][j] = naka;
                        NakaWaku[i][j] = temp;
                        break;
                    }
                    if (InChar.equals("w")&&i!=2) {
                        temp = NakaWaku[i + 1][j];
                        NakaWaku[i + 1][j] = naka;
                        NakaWaku[i][j] = temp;
                        break Continue;
                    }
                    if (InChar.equals("a")&&i!=2) {
                        temp = NakaWaku[i][j + 1];
                        NakaWaku[i][j + 1] = naka;
                        NakaWaku[i][j] = temp;
                        break Continue;
                    }
                    if (InChar.equals("d")&&i!=0) {
                        temp = NakaWaku[i][j - 1];
                        NakaWaku[i][j - 1] = naka;
                        NakaWaku[i][j] = temp;
                        break Continue;
                    }
                }
            }
        }

    }

    //プレイヤーが勝つかどうか確認
    public boolean win() {
        for (int i = 0; i < yoko; i++) {
            for (int j = 0; j < tate; j++) {
                if (!(NakaWaku[i][j].equals(copNakaWaku[i][j]))) {
                    return false;
                }
            }
        }
        return true;
    }
}

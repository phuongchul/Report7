package jp.ac.uryukyu.ie.e165748;

/**
 * Created by e165748 on 2/1/17.
 */
import java.util.Scanner;
public class Main {
    Solver p = new Solver();
    Scanner input = new Scanner(System.in);
    public void InName(){

        p.InNumber();
        System.out.print(" あなたの名前を入力して下さい: ");
        String Name = input.next();
        p.setPlayerName(Name);
        p.inRuRu(p.getPlayerName());
        System.out.println("ゲームが始まります ");
    }
    public void Start(){
        p.RanInNumber();
        p.inWaku();
        do{
            System.out.print("客キー 'a' 'd' 'w' 's' を使って下さい: ");
            String keKa = input.next();
            try {
                p.play(keKa);
                p.inWaku();
            }catch(Exception e){
                System.out.println("キーが間違いました");
            }
        }while(p.win()==false);
        System.out.println("\n おめでとうございます、あなたが勝ちました");
    }
    public static void main(String[] args){
        Main m = new Main();
        m.InName();
        m.Start();
    }
}

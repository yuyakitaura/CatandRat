import java.awt.Color;
import java.util.*;
public class CatandRat {
    void run(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        String line;
        Integer count=0;
        ArrayList<Integer>list=new ArrayList<>();
        ArrayList<Integer>list2=new ArrayList<>();
        list.add(20);
        list.add(20);
        list2.add(380);
        list2.add(380);
        EZ.initialize(400,400);
        EZCircle circle1= EZ.addCircle(list.get(0),list.get(1), 20, 20, Color.RED,true);//動かす円の初期位置
        EZCircle circle2= EZ.addCircle(list2.get(0), list2.get(1), 30, 30,Color.BLUE,true);//ランダムで動く円の初期位置
        for(;;){
            for(Integer i=0;i<400;i+=40){
                for(Integer j=0;j<400;j+=40){
                    EZ.addLine(j, i, j, 400, Color.BLACK);
                    EZ.addLine(i, j, 400, j, Color.BLACK);
                }
            }
            line=scan.nextLine();
            keyput(list,line);
            randomput(list2);
            EZ.removeEZElement(circle1);//一つ前のcircleを消す
            EZ.removeEZElement(circle2);//一つ前のcircleを消す
            System.out.println("赤横"+list.get(0)+",縦"+list.get(1));//入力し計算した値をだす
            System.out.println("青横"+list2.get(0)+",縦"+list2.get(1));
            circle1=EZ.addCircle(list2.get(0),list2.get(1),20, 20, Color.BLUE,true);//circleを追加する
            circle2=EZ.addCircle(list.get(0),list.get(1), 30, 30, Color.RED,true);
            count+=1;
            if(list.containsAll(list2)){//二つのlistの値が一緒だった時
                System.out.println(count);
                break;
            }
            scan=new Scanner(System.in);
            Thread.sleep(100);
        }
        EZ.removeAllEZElements();
        System.out.println("オメデトウ");
    }
    ArrayList<Integer> keyput(ArrayList<Integer> list,String line){
        Integer sayuu;
        Integer tateyoko;
        if(line.equals("d")){//dを押した時右に行く
            sayuu=list.get(0);
            if(sayuu==380){
                System.out.println("赤範囲外です");
            }
            else{
                sayuu+=40;
                list.set(0,sayuu);
            }
        }
        else if(line.equals("a")){//aを押した時左に行く
            sayuu=list.get(0);
            if(sayuu==20){
                System.out.println("赤範囲外です");
            }
            else{
                sayuu-=40;
                list.set(0,sayuu);
            }
        }
        else if(line.equals("s")){//sを押した時下に行く
            tateyoko=list.get(1);
            if(tateyoko==380){
                System.out.println("赤範囲外です");
            }
            else{
                tateyoko+=40;
                list.set(1,tateyoko);
            }
        }
        else if(line.equals("w")){//wを押した時上に行く
            tateyoko=list.get(1);
            if(tateyoko==20){
                System.out.println("赤範囲外です");
            }
            else{
                tateyoko-=40;
                list.set(1,tateyoko);
            }
        }
        return list;
    }
    ArrayList<Integer>randomput(ArrayList<Integer>list2){
        Random rand=new Random();
        Integer sayuu;
        Integer tateyoko;
        Integer ran=rand.nextInt(4);//ランダムを０~3をだす
        if(ran==0){//0になった時右に行く
            sayuu=list2.get(0);
            if(sayuu==380){
                System.out.println("青範囲外です");
            }
            else{
                sayuu+=40;
                list2.set(0,sayuu);
            }
        }
        else if(ran==1){//1になった時左に行く
            sayuu=list2.get(0);
            if(sayuu==20){
                System.out.println("青範囲外です");
            }
            else{
                sayuu-=40;
                list2.set(0,sayuu);
            }
        }
        else if(ran==2){//2になった時下に行く
            tateyoko=list2.get(1);
            if(tateyoko==380){
                System.out.println("青範囲外です");
            }
            else{
                tateyoko+=40;
                list2.set(1,tateyoko);
            }
        }
        else if(ran==3){//3になった時上に行く
            tateyoko=list2.get(1);
            if(tateyoko==20){
                System.out.println("青範囲外です");
            }
            else{
                tateyoko-=40;
                list2.set(1,tateyoko);
            }
        }
        return list2;
    }
    public static void main(String[] args) throws InterruptedException{
        CatandRat printer= new CatandRat();
        printer.run(args);
    }
}
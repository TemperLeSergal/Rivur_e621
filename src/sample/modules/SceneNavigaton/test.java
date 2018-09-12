package sample.modules.SceneNavigaton;/*
package sample.modules.SceneNavigaton;

import javafx.scene.layout.AnchorPane;

import java.lang.reflect.Array;
import java.util.*;

public class test {
    static Random rand = new Random();
    static List<Object> rgbVal = new ArrayList<>() {};
    static List<Integer> percentages = new ArrayList<>() {};

    public static void main(String[] args){
        System.out.println("percentages: " + percentageListGenerator());
        System.out.println("Sequence: " + bitRandomizer());
        System.out.println("test" + linearGradientAsStringGenerator());
    }

    public static List<Object> bitRandomizer(){
        rand = new Random();
        ArrayList<Object> bitSequence;
        int zeros;
        int ones;
        do {
            bitSequence = new ArrayList<>();
            zeros = 0;
            ones = 0;
            for (int index = 0; index < 4; index++) {
                Boolean bool = Math.random() < 0.5;
                if(bool){
                    ones++;
                    bitSequence.add(1);
                }else{
                    zeros++;
                    bitSequence.add(0);
                }
                System.out.println(bool);

            }
            System.out.println("zeros: " + zeros);
            System.out.println("ones: " + ones);
        } while (zeros == 4 || ones == 4);
        return bitSequence;
    }

    public static List<Object> rgbListGenerator(){
        rgbVal = new ArrayList<>() {
            {
                add(80 + rand.nextInt(30));
                add(100 + rand.nextInt(50));
            }
        };
        return rgbVal;
    }

    public static List<Object> percentageListGenerator(){
        modPer = new ArrayList<>() {
            {
                add(rand.nextInt(20));
                add(70 + rand.nextInt(30));
            }
        };
        return Collections.singletonList(rgbVal);
    }

    public static ArrayList<List<Object>> linearGradientAsValuesGenerator(){
        return new ArrayList<>() {{
            add(bitRandomizer());
            add(rgbListGenerator());
            add(percentageListGenerator());
        }};

    }

    public static String linearGradientAsStringGenerator(ArrayList<List<Object>> array){
        if(array == null) {
            array = linearGradientAsValuesGenerator();
        }
        System.out.println("--");
        for(Object num : array.get(0)){
            System.out.println(num);
        }
        System.out.println("--");
        return "-fx-background-color: linear-gradient(from " + array.get(2).get((int)array.get(0).get(0)) + "% " +
                array.get(2).get((int)array.get(0).get(1)) + "% to " + array.get(2).get((int)array.get(0).get(2)) + "% " +
                array.get(2).get((int)array.get(0).get(3)) + "%, rgb(0," + array.get(1).get(0) + "," + array.get(1).get(0) +
                ") 0%, rgb(" + array.get(1).get(1) + ",0," + array.get(1).get(1) + ") 100%)";
    }
    public static String linearGradientAsStringGenerator(){
        var array = linearGradientAsValuesGenerator();

        System.out.println("--");
        for(Object num : array.get(0)){
            System.out.println(num);
        }
        System.out.println("--");
        int[] test = (int[]) array.get(0).get(0);
        for(int num : test){
            System.out.println("BLOOP + " +  num);
        }
        System.out.println("blep" + array.get(0).get(0));
        //System.out.println("blep" + array.get(0).get(1));
        return "-fx-background-color: linear-gradient(from " + array.get(2).get((int)array.get(0).get(0)) + "% " +
                array.get(2).get((int)array.get(0).get(1)) + "% to " + array.get(2).get((int)array.get(0).get(2)) + "% " +
                array.get(2).get((int)array.get(0).get(3)) + "%, rgb(0," + array.get(1).get(0) + "," + array.get(1).get(0) +
                ") 0%, rgb(" + array.get(1).get(1) + ",0," + array.get(1).get(1) + ") 100%)";
    }

    public static void animateBackground(double duration, Object node){
        ArrayList<Object> modRGB = new ArrayList<>();
        ArrayList<Object> modPer = new ArrayList<>();
        var from = new ArrayList<List<Integer>>() {{
            add(new ArrayList<>() {{
                add(0);
                add(0);
                add(1);
                add(1);
            }});
            add(new ArrayList<>() {{
                add(102);
                add(204);
            }});
            add(new ArrayList<>(){{
                add(15);
                add(100);
            }});
        }};
        var to = linearGradientAsValuesGenerator();
        for(int i = 0; i < 1; i++) {
            for (int index = 0; index < 4; index++) {
                double fromInt = from.get(2).get(from.get(0).get(index));
                double toInt = (double) to.get(2).get((Integer) to.get(0).get(index));

                System.out.println("From: " + fromInt + " || To: " + toInt + " || Compare: " + (fromInt > toInt));
                if(fromInt > toInt){
                    System.out.println("We need to subtract!");
                    double sub = (fromInt - toInt)/(duration/10);
                    System.out.println(sub);
                    modPer.add(sub);
                }else if(fromInt < toInt){
                    System.out.println("We need to add!");
                    double add = (toInt - fromInt)/(duration/10);
                    System.out.println(add);
                    modPer.add(add);
                }else{
                    System.out.println("We don't need to do anything!");
                    modPer.add(fromInt);
                }
                */
/*if (from.get(2).get(from.get(0).get(index)) > to.get(2).get(from.get(0).get(index))) {
                    int newInt = (from.get(2).get(from.get(0).get(index))) - (to.get(2).get(from.get(0).get(index))) / duration;
                    modPer.add((from.get(2).get(from.get(0).get(index))) - newInt);
                } else if (to.get(2).get(from.get(0).get(index)) > from.get(2).get(from.get(0).get(index))) {
                    int newInt = ((to.get(2).get(from.get(0).get(index))) - from.get(2).get(from.get(0).get(index))) / duration;
                    modPer.add((from.get(2).get(from.get(0).get(index))) + newInt);
                } else {
                    modPer.add(from.get(2).get(from.get(0).get(index)));
                }*//*

            }
            for(int index2 = 0; index2 < 2; index2++){
                double fromInt = from.get(1).get(index2);
                double toInt = (double) to.get(1).get(index2);
                if(fromInt > toInt){
                    System.out.println("We need to subtract!");
                    double sub = (fromInt - toInt)/(duration/10);
                    System.out.println(sub);
                    modRGB.add(sub);
                }else if(fromInt < toInt){
                    System.out.println("We need to add!");
                    double add = (toInt - fromInt)/(duration/10);
                    System.out.println(add);
                    modRGB.add(add);
                }else{
                    System.out.println("We don't need to do anything!");
                    modRGB.add(fromInt);
                }
                */
/*if(from.get(1).get(index2) > to.get(1).get(index2)){
                    int newRGB = (from.get(1).get(index2) - to.get(1).get(index2)) / duration;
                    modRGB.add(from.get(1).get(index2) - newRGB);
                }else if(from.get(1).get(index2) < to.get(1).get(index2)){
                    int newRGB = (to.get(1).get(index2) - from.get(1).get(index2)) / duration;
                    modRGB.add(from.get(1).get(index2) + newRGB);
                }else{
                    modRGB.add(from.get(1).get(index2));
                }*//*

            }
            if(node instanceof AnchorPane) {
                String newBackground = linearGradientAsStringGenerator(new ArrayList<>() {{
                    addAll(Collections.singleton(to.get(0)));
                    addAll(Collections.singleton(modRGB));
                    addAll(Collections.singleton(modPer));
                }});
                System.out.println(newBackground);
                ((AnchorPane) node).styleProperty().setValue(newBackground);

            }
        }

    }

}
*/

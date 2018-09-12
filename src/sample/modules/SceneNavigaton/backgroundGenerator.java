package sample.modules.SceneNavigaton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class backgroundGenerator {
    static Random rand = new Random();

    static ArrayList<List<Object>> prevColor;
    static ArrayList<List<Object>> newColor;

    public backgroundGenerator() {

    }

    public static void main(String[] args) {

    }

    public static List<Object> bitRandomizer() {
        return null;
    }

    public static List<Object> rgbValueGenerator() {
        return null;
    }

    public static List<Object> percentageValueGenerator() {
        return null;
    }

    public static void updateBackground() {

    }

    public static void linearGradientAsValuesGenerator() {

    }

    public static String linearGradientAsStringGenerator(ArrayList<List<Object>> linearAsVal) {

        return null;
    }

    class createLinearBackground {
        public ArrayList<List<Object>> linearAsVal;
        public List<Object> sequence;
        public List<Object> rgb;
        public List<Object> percent;

        public void addRGBVal(int rgbVal) {
            rgb.add(rgbVal);
        }

        public void addPerVal(int percentVal) {
            percent.add(percentVal);
        }

        public String getBg() {
            if (rgb.size() < 2 || percent.size() < 2) {

            }
            linearAsVal = new ArrayList<>() {{
                add(new ArrayList<>() {{
                    add(0);
                    add(0);
                    add(1);
                    add(1);
                }});
                add(rgb);
                add(percent);
            }};
            return linearGradientAsStringGenerator(linearAsVal);
        }
    }

    class animate {
        ArrayList<List<Object>> linearAsVal;
        List<Object> rgb;
        List<Object> percent;

        public void setRgbVal(ArrayList<Object> listOfRGBVals) {

        }
    }

}

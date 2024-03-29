import java.io.*;

public class Loader {
    /**/
    static int lineCount = 1;
    String filename;
    static int cycles = 0;
    static String[] tokens;
    static String line;
    String delimiter = " ";
    static File fileObjIn;
    static File fileObjOut;
    static FileReader fr;
    static FileWriter fw;
    static BufferedReader br;
    static BufferedWriter bw;
    static boolean gotCycles;
    final static String outputFile = "./output.txt";

    Loader() {
    }

    public static int openFile(String progArg) {
        try {
            // writing
            fileObjOut = new File(outputFile);
            fileObjOut.delete();

            // reading
            fileObjIn = new File(progArg);
            fr = new FileReader(fileObjIn);
            br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                tokens = line.split(" ", 0);
                if (tokens.length == 1 && gotCycles == false) {
                    getCycles(tokens[0]);
                    gotCycles = true;
                } else if (tokens.length == 5) {
                    getFlyable(tokens);
                } else {
                    throw new RuntimeException("Invalid line format: line " + lineCount);
                }
                lineCount++;
                //System.out.println(line); // debug
            }

            br.close();
        } catch (Exception e) {
            System.out.println("Oops something when wrong: " + e);
            System.exit(1);
        }
        return (cycles);
    }

    public static int getCycles(String line1) {
        if (!isNumber(line1)) {
            throw new RuntimeException("Invalid number of iterations. You should feel bad.");
        }
        cycles = Integer.parseInt(line1);
        if (cycles < 0)
            return (cycles);
        return (0);
    }

    public static boolean isNumber(String iterations) {
        char[] cArray = iterations.toCharArray();
        int index = 0;

        while (index < cArray.length) {
            if (!Character.isDigit(cArray[index])) {
                return (false);
            }
            index++;
        }
        return (true);
    }

    public static void getFlyable(String[] flyable) {
        if (!(flyable[0].equals("Baloon")) && !(flyable[0].equals("JetPlane")) && !(flyable[0].equals("Helicopter"))) {
            throw new RuntimeException("Invalid craft type. You should feel bad: " + flyable[0]);
        } else if (!isNumber(flyable[2]) || !isNumber(flyable[3]) || !isNumber(flyable[4])) {
            throw new RuntimeException("Invalid coordinates. You should feel bad: " + flyable[2] + " " + flyable[3] + " " + flyable[4]);
        }
        //System.out.println("LOADER::: " + flyable[0] + ": height = " + flyable[4]); debug
        Flyable craft = AircraftFactory.newAircraft(flyable[0], flyable[1], Integer.parseInt(flyable[2]), Integer.parseInt(flyable[3]), Integer.parseInt(flyable[4]));
        craft.registerTower(Simulator.wt);
    }

    public static void writeToFile(String msg) {
        try {
            //System.out.println("msg: " + msg); // debug
            try {
                FileWriter fw = new FileWriter(outputFile ,true);
                fw.append(msg + "\n");
                fw.close();
            } catch (Exception e){}
        } catch (Exception e) {
            System.out.println("Oops something when wrong: " + e);
            System.exit(1);
        }
    }
}

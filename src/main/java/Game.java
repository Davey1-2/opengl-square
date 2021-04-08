

import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL33;
import org.lwjgl.system.CallbackI;
import org.lwjgl.system.MemoryUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;

public class Game {


    private static ArrayList<Square> squares = new ArrayList<Square>();



    public static void init(long window) throws IOException {

        Shaders.initShaders();

        BufferedReader br = new BufferedReader(new FileReader("maze1 (1).txt"));
        ArrayList<String> arr = new ArrayList<>();
        int countVertical = 0;
        int countHorizontal;
        String line;

        Shaders.initShaders();



        while ((line = br.readLine()) != null) {
            arr.add(line);

            countVertical++;
        }
        br.close();
        countHorizontal = arr.get(1).length();

        float pieceX = 2.0f / countHorizontal;
        float pieceY = 2.0f / countVertical;


        for (int y = 0; y < countVertical; y++) {
            line = arr.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == '0'){
                    squares.add(new Square(x*pieceX-1,(y*pieceY)* -1+1,pieceX,pieceY));
                }
            }

        }
    }


    public static void render(long window) {

        for (Square square : squares){
            square.draw();
        }

    }

    public static void update(long window) {
    }


}
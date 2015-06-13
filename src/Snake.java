/**
 * Created by Vlad on 13.06.2015.
 */
public class Snake {
    public int direction = 1;// управление змейкой
    public int length = 5; // длина змейки = 2 клетки = 2 СНАЙКА

    public int snakeX[] = new int[100]; // максимальное число элементов змеи 100
    public int snakeY[] = new int[100];


    public Snake(int x0, int y0, int x1, int y1) { // принимает стартовые позиции первых двух элементов массива
        snakeX[0] = x0;
        snakeY[0] = y0;

        snakeX[1] = x1;
        snakeY[1] = y1;
    }

    public void move() {
        for (int i = length; i > 0; i--) {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }
        if (direction == 0) snakeX[0]++;// вправо
        if (direction == 1) snakeY[0]++;// вниз

        if (direction == 2) snakeX[0]--;// влево
        if (direction == 3) snakeY[0]--;//вверх


        for (int i = length - 1; i > 0; i--) {
            if ((snakeX[0] == snakeX[i]) & (snakeY[0] == snakeY[i])) length = i - 2;
        }
        if (length < 2) length = 2;



    }

}

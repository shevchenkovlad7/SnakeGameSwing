import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Vlad on 13.06.2015.
 */
public class SnakeGame extends JPanel implements ActionListener {
    // создаем сетку
    public static final int SCALE = 32; // розмер одной клетки
    public static final int WIDTH = 20; // ширена измеряем в SCALE
    public static final int HEIGHT = 20; // высота
    public static final int SPEED = 5; //  клеток в секунду скорость змеи

    Snake snake = new Snake(10, 10, 9, 10);
    Timer timer = new Timer(1000/SPEED,this);

    public SnakeGame(){
        timer.start();// запускаем змейку , движение
        addKeyListener(new Keybord());
        setFocusable(true);

    }

    public void paint(Graphics g){
        g.setColor(color(15,75,75));
        g.fillRect(0,0,WIDTH*SCALE,HEIGHT*SCALE);
        g.setColor(color(255,216,0));

        for(int xx = 0; xx <=WIDTH*SCALE; xx+=SCALE){
            g.drawLine(xx,0,xx,WIDTH*SCALE);
        }
        for(int yy = 0; yy <=HEIGHT*SCALE; yy+=SCALE){
            g.drawLine(0,yy,HEIGHT*SCALE,yy);
        }
        for(int i = 0; i < snake.length; i++ ){
            g.setColor(color(30,50,250));
            g.fillRect(snake.snakeX[i]*SCALE+1, snake.snakeY[i]*SCALE+1, SCALE-1, SCALE-1);
        }


    }
    public Color color(int red, int green, int blue){
        return new Color(red,green,blue);
    }



    public static void main(String[] args){
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setSize(WIDTH*SCALE+7,HEIGHT*SCALE+30);//устанавлеваем размер
        f.setLocationRelativeTo(null);// благодаря этому окошко будет розмещаться чисто по центру
        f.add(new SnakeGame());// добавляем в класс маин нашу Снейк панель
        f.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();

        repaint();
    }
    private class Keybord extends KeyAdapter {
        public void keyPressed(KeyEvent keyEvent){ // метод клавиша нажата
            int key = keyEvent.getKeyCode();//  присваеваем каждой клавише какой то код

            if((key == KeyEvent.VK_RIGHT)&& snake.direction !=2) snake.direction = 0;
            if((key == KeyEvent.VK_DOWN)&& snake.direction!=3) snake.direction = 1;
            if((key == KeyEvent.VK_LEFT)&& snake.direction !=0) snake.direction = 2;
            if((key == KeyEvent.VK_UP) && snake.direction!=1) snake.direction = 3;






        }
    }
}

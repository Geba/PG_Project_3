package teste.gabi;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;

import com.jogamp.opengl.util.*;


public class GabiTeste implements GLEventListener {

	//points matrix that will represent our house map
    int[][] plantaBaixa = {
    		{50, 50},
    		{50, 0},
    		{0,0},
    		{0, 50}
    		
 		//{},
    };
    

    public static void main(String[] args) {
        GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        GLCanvas canvas = new GLCanvas(caps);
        

        Frame frame = new Frame("Home Sweet Home");
        frame.setSize(800, 600);
        frame.add(canvas);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        canvas.addGLEventListener(new GabiTeste());//Mesmo nome da classe
        FPSAnimator animator = new FPSAnimator(canvas, 60);
       // animator.add(canvas);
        animator.start();
        
       

    }

    @Override
    public void display(GLAutoDrawable drawable) {
        update();
        createApt(drawable);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }

    @Override
    public void init(GLAutoDrawable drawable) {
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
    }

    private void update() {
        //theta += 0.01;
        //s = Math.sin(theta);
        //c = Math.cos(theta);
        //executada a cada att de tela
    }

    private void createApt(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        // draw a triangle filling the window
        gl.glBegin(gl.GL_LINE_LOOP);
        gl.glColor3f(1, 0, 0);
        gl.glVertex2i(25, 25);
        gl.glVertex2i(-25, 25);
        gl.glVertex2i(-25, -25);
        gl.glVertex2i(25, -25);
        gl.glEnd();
    }

//QUERO SETAR O TAMANHO DA JANELA 
        //glutInitWindowSize(400,350); 


}
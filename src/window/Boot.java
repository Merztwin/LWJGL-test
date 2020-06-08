package window;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;


public class Boot {

	public static void main(String[] args){
		
		if(!glfwInit()){
			
			throw new IllegalStateException("Failed to initialize GLFW!");
			
		}
		
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		long window = glfwCreateWindow(640, 480, "window", 0, 0);
		
		if (window == 0) {
			
			throw new IllegalStateException("Failed to create window!");
			
		}
		
		GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(window, (videoMode.width() - 640)/2, (videoMode.height() - 480)/2);
		
		glfwShowWindow(window);
		
		glfwMakeContextCurrent(window);
		
		GL.createCapabilities();
		
		glEnable(GL_TEXTURE_2D);
		
		Texture tex = new Texture("./res/pack.png");
		
		while(!glfwWindowShouldClose(window)) {
			
			
			if(glfwGetKey(window, GLFW_KEY_ESCAPE) == GL_TRUE){
				
				glfwSetWindowShouldClose(window, true);
			}
			
			glfwPollEvents();
			
			glClear(GL_COLOR_BUFFER_BIT);
			
			tex.Bind();
			
			glBegin(GL_QUADS);
			
				glTexCoord2f(0,0);
				glVertex2f(-0.5f, 0.5f);
				
				glTexCoord2f(0,1);
				glVertex2f(0.5f, 0.5f);
				
				glTexCoord2f(1,1);
				glVertex2f(0.5f, -0.5f);
				
				glTexCoord2f(1,0);
				glVertex2f(-0.5f, -0.5f);
			
			glEnd();
			
			glfwSwapBuffers(window);
		}
		
		glfwTerminate();
	}
	
}

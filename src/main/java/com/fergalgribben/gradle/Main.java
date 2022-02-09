package com.fergalgribben.gradle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.util.vector.Matrix4f;

public class Main{

  private final String WINDOW_TITLE = "The Quad: Moving";
  private final int WIDTH = 800;
  private final int HEIGHT = 600;
  private final double PI = 3.14159265358979323846;

  public static void main (String [] args){
    new Main();
  }

  public Main(){
    setupOpenGL();
  }

  private void setupOpenGL(){
    // Setup an OpenGL context with API version 3.2
    try {
      PixelFormat pixelFormat = new PixelFormat();
      ContextAttribs contextAtrributes = new ContextAttribs(3, 2)
        .withForwardCompatible(true)
        .withProfileCore(true);
      
      Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
      Display.setTitle(WINDOW_TITLE);
      Display.create(pixelFormat, contextAtrributes);
      
      GL11.glViewport(0, 0, WIDTH, HEIGHT);
    } catch (LWJGLException e) {
      e.printStackTrace();
      System.exit(-1);
    }
    
    // Setup an XNA like background color
    GL11.glClearColor(0.4f, 0.6f, 0.9f, 0f);
    
    // Map the internal OpenGL coordinate system to the entire screen
    GL11.glViewport(0, 0, WIDTH, HEIGHT);
    
  }

}

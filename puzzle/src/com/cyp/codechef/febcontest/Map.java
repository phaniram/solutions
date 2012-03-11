/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cyp.codechef.febcontest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
 
public class Map {
 
	private int finishx, finishy;
	private boolean found = false;
	private Scanner mazeFile;
	private char[][] maze;
 
	private void loadMap(){
		maze = new char[Integer.parseInt(mazeFile.nextLine())][Integer.parseInt(mazeFile.nextLine())];
		for(int i = 0; i < maze.length; i++)
			maze[i] = mazeFile.nextLine().toCharArray();
	}
 
	private void traverseMap(int y, int x, char Finish){
		if(maze[y][x] != '#'){
			finishx = finishy = -1;
			return;
		}
		if(x != 0){
			if(maze[y][x-1] == '#' || maze[y][x-1] == '$'){
				if(maze[y][x-1] == '$'){
					finishy = y;
					finishx = x-1;
					found = true;
					maze[y][x] = '%';
					return;
				}else{
					maze[y][x] = '%';
					traverseMap(y, x-1, Finish);
				}
			}
		}
		if(found) return;
 
		if(y != 0){
			if(maze[y-1][x] == '#' || maze[y-1][x] == '$'){
				if(maze[y-1][x] == '$'){
					finishy = y-1;
					finishx = x;
					found = true;
					maze[y][x] = '%';
					return;
				}else{
					maze[y][x] = '%';
					traverseMap(y-1, x, Finish);
				}
			}
		}
		if(found) return;
 
		if(x != maze.length-1){
			if(maze[y][x+1] == '#' || maze[y][x+1] == '$'){
				if(maze[y][x+1] == '$'){
					finishy = y;
					finishx = x+1;
					found = true;
					maze[y][x] = '%';
					return;
				}else{
					maze[y][x] = '%';
					traverseMap(y, x+1, Finish);
				}
			}
		}
		if(found) return;
 
		if(y != maze[0].length-1){
			if(maze[y+1][x] == '#' || maze[y+1][x] == '$'){
				if(maze[y+1][x] == '$'){
					finishy = y+1;
					finishx = x;
					found = true;
					maze[y][x] = '%';
					return;
				}else{
					maze[y][x] = '%';
					traverseMap(y+1, x, Finish);
				}
			}
		}
		if(found) return;
	}
 
	public Map(String File){
		try{
			mazeFile = new Scanner(new FileReader(File));
		}catch(FileNotFoundException fnfe){ System.err.println(fnfe.getMessage()); }
                
		loadMap();
                System.out.println(Arrays.deepToString(maze));
                
		traverseMap(1, 1, '$');
                System.out.println(Arrays.deepToString(maze));
		System.out.println("Value at maze["+finishy+"]["+finishx+"]: "+maze[finishy][finishx]);
	}
 
	public static void main(String[] args) {
		new Map("D:\\Maze.txt");
	}
}
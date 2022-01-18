package saper;

import java.util.Random;
import java.util.Scanner;

public class Tworzenie_tablic {
	public static void main(String[] args) {

		Random r = new Random();
		Scanner klaw = new Scanner(System.in);
		Boolean czyWygrana = false;
		int x, y;
		String wartośćWybrana;
		char oznaCzySpr='a';
		
		String gracza[][]= new String[10][10];
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				gracza[i][j]="\u25FB";
			}
		}
		
		String bomb[][]= new String[10][10];
		
		for(int i=0;i<10;i++) {
			for(int j=0, rn;j<10;j++) {
				rn = r.nextInt(10);							//określanie procentowej ilości bomb
				if(rn==0) bomb[i][j]="*";
				else bomb[i][j]="\u25E6";
			}
		}
			
		for(int i=0;i<10;i++) {								//nanoszenie podpowiedzi 
			for(int j=0;j<10;j++) {
				if(bomb[i][j]=="*") {
					if(i!=0) {
						if(bomb[i-1][j]=="*");
						else if(bomb[i-1][j]=="\u25E6") bomb[i-1][j]="1"; 
						else bomb[i-1][j]=Integer.toString(Integer.parseInt(bomb[i-1][j])+1);
						if(j!=0) {
							if(bomb[i-1][j-1]=="*");
							else if(bomb[i-1][j-1]=="\u25E6") bomb[i-1][j-1]="1"; 
							else bomb[i-1][j-1]=Integer.toString(Integer.parseInt(bomb[i-1][j-1])+1);
							}
						if(j!=9) {
							if(bomb[i-1][j+1]=="*");
							else if(bomb[i-1][j+1]=="\u25E6") bomb[i-1][j+1]="1"; 
							else bomb[i-1][j+1]=Integer.toString(Integer.parseInt(bomb[i-1][j+1])+1);
							}
						}
					if(i!=9) {
						if(bomb[i+1][j]=="*");
						else if(bomb[i+1][j]=="\u25E6") bomb[i+1][j]="1"; 
						else bomb[i+1][j]=Integer.toString(Integer.parseInt(bomb[i+1][j])+1);
						if(j!=0) {
							if(bomb[i+1][j-1]=="*");
							else if(bomb[i+1][j-1]=="\u25E6") bomb[i+1][j-1]="1"; 
							else bomb[i+1][j-1]=Integer.toString(Integer.parseInt(bomb[i+1][j-1])+1);
							}
						if(j!=9) {
							if(bomb[i+1][j+1]=="*");
							else if(bomb[i+1][j+1]=="\u25E6") bomb[i+1][j+1]="1"; 
							else bomb[i+1][j+1]=Integer.toString(Integer.parseInt(bomb[i+1][j+1])+1);
							}
						}
					if(j!=0) {
						if(bomb[i][j-1]=="*");
						else if(bomb[i][j-1]=="\u25E6") bomb[i][j-1]="1"; 
						else bomb[i][j-1]=Integer.toString(Integer.parseInt(bomb[i][j-1])+1);
						}
					if(j!=9) {
						if(bomb[i][j+1]=="*");
						else if(bomb[i][j+1]=="\u25E6") bomb[i][j+1]="1"; 
						else bomb[i][j+1]=Integer.toString(Integer.parseInt(bomb[i][j+1])+1);
						}
				}
			}
		}
		System.out.println("Witaj w saperze!\n wpisując najpierw podawaj x potem y\n  jako trzecią wartość podaj \n\t"
				+ "'s' -> sprawdzam\t'x' -> oznaczania bomby");
		while(czyWygrana==false){						//main
		for(int i=0;i<10;i++) System.out.print(i+1+" ");
		System.out.println("");
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				System.out.print(gracza[i][j]+" ");
			}
			System.out.print(i+1+"\n");
		}
		x = klaw.nextInt()-1;
		y = klaw.nextInt()-1;
		do oznaCzySpr = klaw.next().charAt(0);
		while(oznaCzySpr!='s' && oznaCzySpr!='x');
		wartośćWybrana = bomb[y][x];
		if(wartośćWybrana == "*") {System.out.println("przegrana"); break;}
		
		if(oznaCzySpr=='s')gracza[y][x]=wartośćWybrana;
		else gracza[y][x]="\u25B2";
		}
		if(czyWygrana==false) System.out.println("niestety przegrałeś\n");
		for(int i=0;i<10;i++) System.out.print(i+1+" ");
		System.out.print("\t");
		for(int i=0;i<10;i++) System.out.print(i+1+" ");
		System.out.println("");
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				System.out.print(gracza[i][j]+" ");
			}
			System.out.print(i+1+"\t");
			for(int j=0;j<10;j++) {
				System.out.print(bomb[i][j]+" ");
			}
			System.out.print(i+1+"\n");
		}
		klaw.close();
	}
}
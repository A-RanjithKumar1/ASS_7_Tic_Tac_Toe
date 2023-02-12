package org.example;
import java.util.*;
import java.util.logging.*;
public class AssinArr{
    private static final Logger LOGGER = Logger.getLogger("InfoLogging");
    int row;
    int col;
    int control=0;
    String p1="";
    public void input(int r, int c, char userinp,char[][] ar1){
        row=r;
        col=c;
        if(ar1[row][col]==0){
            ar1[row][col]=userinp;
            control+=1;
        }
        else{
            LOGGER.info("Element is already present");
        }
    }
    public void disp1(char[][] ar2,int d1){
        StringBuilder bld = new StringBuilder();
        bld.append("|");
        for(int i=0;i<d1;i++) {
            for (int j = 0; j < d1; j++) {
                bld.append(ar2[i][j] + " |");
            }
            bld.append(" "+"\n"+" ");
        }
        String s= bld.toString();
        LOGGER.info(s);
    }
    public  boolean getConfrm(int rv, int cv,char[][] ar2){
        if(ar2[rv][cv] == 0){
            return true;
        }
        return false;
    }
    public int rowCheck(int r,int dim,char[][] gameArr,char inp1){
        int count=0;
        for(int i=0;i<dim;i++){
            if(gameArr[r][i]==inp1){
                count+=1;
            }
            else{
                break;
            }
        }
        return count;
    }
    public int colCheck(int c,int dim,char[][] gameArr,char inp2){
        int count=0;
        for(int i=0;i<dim;i++){
            if(gameArr[i][c]==inp2){
                count+=1;
            }
            else{
                break;
            }
        }
        return count;
    }
    public int digLCheck(int dim,char[][] gameArr,char inp3){
        int count=0;
        for(int i=0;i<dim;i++){
            if(gameArr[i][i]==inp3){
                count+=1;
            }
            else{
                break;
            }
        }
        return count;
    }
    public int digRCheck(int dim,char[][] gameArr,char inp4){
        int count=0;
        int dump=dim-1;
        for(int i=0;i<dim;i++){
            if(gameArr[i][dump]==inp4){
                count+=1;
                dump-=1;
            }
            else{
                break;
            }
        }
        return count;
    }
    public void player1(int d, char[][] ar, char p){
        Scanner sc=new Scanner(System.in);
        LOGGER.info("Player1 Turn");
        LOGGER.info("Enter the row value");
        int rv=sc.nextInt();
        LOGGER.info("Enter the col value");
        int cv=sc.nextInt();
        if(getConfrm(rv,cv,ar)){
            input(rv,cv,p,ar);
            disp1(ar,d);
            if((rowCheck(rv,d,ar,p)==d || colCheck(cv,d,ar,p)==d || digLCheck(d,ar,p)==d || digRCheck(d,ar,p)==d)){
                LOGGER.info("Hurray! Player1 Won");
                p1 = "p1w";
            }
        }
        else{
            LOGGER.info("Invalid Input");
            player1(d,ar,p);
            p1 = "0";
        }
    }
    public  void player2(int dim,char[][] ar2,char p){
        Scanner sc=new Scanner(System.in);
        LOGGER.info("Player2 Turn");
        LOGGER.info("Enter the row value");
        int rv=sc.nextInt();
        LOGGER.info("Enter the col value");
        int  cv=sc.nextInt();
        if(getConfrm(rv,cv,ar2)){
            input(rv,cv,p,ar2);
            disp1(ar2,dim);
            if((rowCheck(rv,dim,ar2,p)==dim || colCheck(cv,dim,ar2,p)==dim || digLCheck(dim,ar2,p)==dim || digRCheck(dim,ar2,p)==dim) ){
                LOGGER.info("Hurray! Player2 Won");
                p1 =  "p2w";
            }
        }
        else{
            LOGGER.info("Invalid ");
            player2(dim,ar2,p);
            p1 =  "0";
        }
    }
    public int check(int dimension){
        if(control ==(dimension*dimension)){
            LOGGER.info("Game Drawn");
            return 2;
        }
        else if(p1.equals("p1w") || p1.equals("p2w")){
            control = dimension*dimension;
            return 1;
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        LOGGER.info("Enter the number of dimensions of the game");
        int dimension=sc.nextInt();
        char[][] disp=new char[dimension][dimension];
        LOGGER.info("Enter the Player1 choice to choose X or O");
        char player1=Character.toUpperCase(sc.next().charAt(0));
        char player2;
        if(player1=='X'){
            player2='O';
        }
        else{
            player2='X';
        }
        AssinArr a = new AssinArr();
        while(a.control<(dimension*dimension)){
            if(a.check(dimension) == 0){
                a.player1(dimension,disp,player1);
                if(a.check(dimension) == 0){
                    a. player2(dimension,disp,player2);
                }
            }
        }
    }
}
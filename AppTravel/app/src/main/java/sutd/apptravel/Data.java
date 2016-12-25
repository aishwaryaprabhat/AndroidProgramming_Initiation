package sutd.apptravel;

import java.util.*;

public class Data {

    private static ArrayList<String> result;

    public static void ENUM(List<String> input, double travelcost) {
        List<String> places = new ArrayList<String>();
        //travel attractions
        places.add("Marina Bay Sands");
        places.add("Singapore Flyer");
        places.add("Vivo City");
        places.add("Resorts World Sentosa");
        places.add("Buddha Tooth Relic Temple");
        places.add("Zoo");

        int[][][] Time = new int[6][6][3];
        //foot is 0, Pt is 1, taxi is 2
        //From MBS
        Time[0][0][0] = 0;
        Time[0][1][0] = 14;
        Time[0][2][0] = 69;
        Time[0][3][0] = 76;
        Time[0][4][0] = 28;
        Time[0][5][0] = 269;
        Time[0][0][1] = 0;
        Time[0][1][1] = 17;
        Time[0][2][1] = 26;
        Time[0][3][1] = 35;
        Time[0][4][1] = 19;
        Time[0][5][1] = 84;
        Time[0][0][2] = 0;
        Time[0][1][2] = 3;
        Time[0][2][2] = 14;
        Time[0][3][2] = 19;
        Time[0][4][2] = 8;
        Time[0][5][2] = 30;
        //From Flyer
        Time[1][0][0] = 14;
        Time[1][1][0] = 0;
        Time[1][2][0] = 81;
        Time[1][3][0] = 88;
        Time[1][4][0] = 39;
        Time[1][5][0] = 264;
        Time[1][0][1] = 17;
        Time[1][1][1] = 0;
        Time[1][2][1] = 31;
        Time[1][3][1] = 38;
        Time[1][4][1] = 24;
        Time[1][5][1] = 85;
        Time[1][0][2] = 6;
        Time[1][1][2] = 0;
        Time[1][2][2] = 13;
        Time[1][3][2] = 18;
        Time[1][4][2] = 8;
        Time[1][5][2] = 29;
        //Vivo City
        Time[2][0][0] = 69;
        Time[2][1][0] = 81;
        Time[2][2][0] = 0;
        Time[2][3][0] = 12;
        Time[2][4][0] = 47;
        Time[2][5][0] = 270;
        Time[2][0][1] = 24;
        Time[2][1][1] = 29;
        Time[2][2][1] = 0;
        Time[2][3][1] = 10;
        Time[2][4][1] = 18;
        Time[2][5][1] = 85;
        Time[2][0][2] = 12;
        Time[2][1][2] = 14;
        Time[2][2][2] = 0;
        Time[2][3][2] = 9;
        Time[2][4][2] = 11;
        Time[2][5][2] = 31;
        //RWS
        Time[3][0][0] = 76;
        Time[3][1][0] = 88;
        Time[3][2][0] = 12;
        Time[3][3][0] = 0;
        Time[3][4][0] = 55;
        Time[3][5][0] = 285;
        Time[3][0][1] = 33;
        Time[3][1][1] = 38;
        Time[3][2][1] = 10;
        Time[3][3][1] = 0;
        Time[3][4][1] = 27;
        Time[3][5][1] = 92;
        Time[3][0][2] = 13;
        Time[3][1][2] = 14;
        Time[3][2][2] = 4;
        Time[3][3][2] = 0;
        Time[3][4][2] = 12;
        Time[3][5][2] = 32;
        //Buddha Relic Temple
        Time[4][0][0] = 28;
        Time[4][1][0] = 39;
        Time[4][2][0] = 47;
        Time[4][3][0] = 55;
        Time[4][4][0] = 0;
        Time[4][5][0] = 264;
        Time[4][0][1] = 18;
        Time[4][1][1] = 23;
        Time[4][2][1] = 19;
        Time[4][3][1] = 28;
        Time[4][4][1] = 0;
        Time[4][5][1] = 83;
        Time[4][0][2] = 7;
        Time[4][1][2] = 8;
        Time[4][2][2] = 9;
        Time[4][3][2] = 14;
        Time[4][4][2] = 0;
        Time[4][5][2] = 30;
        //Zoo
        Time[5][0][0] = 269;
        Time[5][1][0] = 264;
        Time[5][2][0] = 270;
        Time[5][3][0] = 285;
        Time[5][4][0] = 264;
        Time[5][5][0] = 0;
        Time[5][0][1] = 86;
        Time[5][1][1] = 87;
        Time[5][2][1] = 86;
        Time[5][3][1] = 96;
        Time[5][4][1] = 84;
        Time[5][5][1] = 0;
        Time[5][0][2] = 32;
        Time[5][1][2] = 29;
        Time[5][2][2] = 32;
        Time[5][3][2] = 36;
        Time[5][4][2] = 30;
        Time[5][5][2] = 0;

        double[][][] Cost = new double[6][6][3];
        Cost[0][0][0] = 0;
        Cost[0][1][0] = 0;
        Cost[0][2][0] = 0;
        Cost[0][3][0] = 0;
        Cost[0][4][0] = 0;
        Cost[0][5][0] = 0;
        Cost[0][0][1] = 0;
        Cost[0][1][1] = 0.83;
        Cost[0][2][1] = 1.18;
        Cost[0][3][1] = 4.03;
        Cost[0][4][1] = 0.88;
        Cost[0][5][1] = 1.96;
        Cost[0][0][2] = 0;
        Cost[0][1][2] = 3.22;
        Cost[0][2][2] = 6.96;
        Cost[0][3][2] = 8.50;
        Cost[0][4][2] = 4.98;
        Cost[0][5][2] = 18.4;
        //From Flyer
        Cost[1][0][0] = 0;
        Cost[1][1][0] = 0;
        Cost[1][2][0] = 0;
        Cost[1][3][0] = 0;
        Cost[1][4][0] = 0;
        Cost[1][5][0] = 0;
        Cost[1][0][1] = 0.83;
        Cost[1][1][1] = 0;
        Cost[1][2][1] = 1.26;
        Cost[1][3][1] = 4.03;
        Cost[1][4][1] = 0.98;
        Cost[1][5][1] = 1.89;
        Cost[1][0][2] = 4.32;
        Cost[1][1][2] = 0;
        Cost[1][2][2] = 7.84;
        Cost[1][3][2] = 9.38;
        Cost[1][4][2] = 4.76;
        Cost[1][5][2] = 18.18;
        //Vivo City
        Cost[2][0][0] = 0;
        Cost[2][1][0] = 0;
        Cost[2][2][0] = 0;
        Cost[2][3][0] = 0;
        Cost[2][4][0] = 0;
        Cost[2][5][0] = 0;
        Cost[2][0][1] = 1.18;
        Cost[2][1][1] = 1.26;
        Cost[2][2][1] = 0;
        Cost[2][3][1] = 2.00;
        Cost[2][4][1] = 0.98;
        Cost[2][5][1] = 1.99;
        Cost[2][0][2] = 8.30;
        Cost[2][1][2] = 7.96;
        Cost[2][2][2] = 0;
        Cost[2][3][2] = 4.54;
        Cost[2][4][2] = 6.42;
        Cost[2][5][2] = 22.58;
        //RWS
        Cost[3][0][0] = 0;
        Cost[3][1][0] = 0;
        Cost[3][2][0] = 0;
        Cost[3][3][0] = 0;
        Cost[3][4][0] = 0;
        Cost[3][5][0] = 0;
        Cost[3][0][1] = 1.18;
        Cost[3][1][1] = 1.26;
        Cost[3][2][1] = 0.00;
        Cost[3][3][1] = 0;
        Cost[3][4][1] = 0.98;
        Cost[3][5][1] = 1.99;
        Cost[3][0][2] = 8.74;
        Cost[3][1][2] = 8.40;
        Cost[3][2][2] = 3.22;
        Cost[3][3][2] = 0;
        Cost[3][4][2] = 6.64;
        Cost[3][5][2] = 22.80;
        //Buddha Relic Temple
        Cost[4][0][0] = 0;
        Cost[4][1][0] = 0;
        Cost[4][2][0] = 0;
        Cost[4][3][0] = 0;
        Cost[4][4][0] = 0;
        Cost[4][5][0] = 0;
        Cost[4][0][1] = 0.88;
        Cost[4][1][1] = 0.98;
        Cost[4][2][1] = 0.98;
        Cost[4][3][1] = 3.98;
        Cost[4][4][1] = 0;
        Cost[4][5][1] = 1.91;
        Cost[4][0][2] = 5.32;
        Cost[4][1][2] = 4.76;
        Cost[4][2][2] = 4.98;
        Cost[4][3][2] = 6.52;
        Cost[4][4][2] = 0;
        Cost[4][5][2] = 18.4;
        //Zoo
        Cost[5][0][0] = 0;
        Cost[5][1][0] = 0;
        Cost[5][2][0] = 0;
        Cost[5][3][0] = 0;
        Cost[5][4][0] = 0;
        Cost[5][5][0] = 0;
        Cost[5][0][1] = 1.88;
        Cost[5][1][1] = 1.96;
        Cost[5][2][1] = 2.11;
        Cost[5][3][1] = 4.99;
        Cost[5][4][1] = 1.91;
        Cost[5][5][1] = 0;
        Cost[5][0][2] = 22.48;
        Cost[5][1][2] = 19.40;
        Cost[5][2][2] = 21.48;
        Cost[5][3][2] = 23.68;
        Cost[5][4][2] = 21.60;
        Cost[5][5][2] = 0;
        // identify attractions in database
        ArrayList<Integer> x = new ArrayList<Integer>();
        for (int i = 0; i < input.size(); i++) {

            for (int a = 0; a < 6; a++) {
                if (input.get(i) == places.get(a)) {
                    x.add(a);
                    break;
                }
            }
        }


        //combinations for all path
        int[][] pathlist = new int[720][8];
        int h=0;
        for (int b = 0; b < x.size(); b++) {
            for (int c = 0; c < x.size(); c++) {
                if (c != b) {
                    if (x.size() - 1 == 1) {
                        pathlist[h][0]=0;
                        pathlist[h][1]=x.get(b);
                        pathlist[h][2]=x.get(c);
                        pathlist[h][3]=0;
                        h+=1;
                    }
                    else{
                        for (int d = 0; d < x.size(); d++) {
                            if (d != b && d != c) {
                                if (x.size() - 2 == 1) {
                                    pathlist[h][0]=0;
                                    pathlist[h][1] = x.get(b);
                                    pathlist[h][2] = x.get(c);
                                    pathlist[h][3] = x.get(d);
                                    pathlist[h][4]=0;
                                    h += 1;
                                } else {
                                    for (int e = 0; e < x.size(); e++) {
                                        if (e != b && e != c && e != d) {
                                            if (x.size() - 3 == 1) {
                                                pathlist[h][0]=0;
                                                pathlist[h][1] = x.get(b);
                                                pathlist[h][2] = x.get(c);
                                                pathlist[h][3] = x.get(d);
                                                pathlist[h][4] = x.get(e);
                                                pathlist[h][5]=0;
                                                h += 1;
                                            } else {
                                                for (int f = 0; f < x.size(); f++) {
                                                    if (f != b && f != c && f != d && f != e) {
                                                        if (x.size() - 4 == 1) {
                                                            pathlist[h][0]=0;
                                                            pathlist[h][1] = x.get(b);
                                                            pathlist[h][2] = x.get(c);
                                                            pathlist[h][3] = x.get(d);
                                                            pathlist[h][4] = x.get(e);
                                                            pathlist[h][5] = x.get(f);
                                                            pathlist[h][6]=0;
                                                            h += 1;
                                                        } else {
                                                            for (int g = 0; g < x.size(); g++) {
                                                                if (g != b && g != c && g != d && g != e && g != f) {
                                                                    pathlist[h][0]=0;
                                                                    pathlist[h][1] = x.get(b);
                                                                    pathlist[h][2] = x.get(c);
                                                                    pathlist[h][3] = x.get(d);
                                                                    pathlist[h][4] = x.get(e);
                                                                    pathlist[h][5] = x.get(f);
                                                                    pathlist[h][6] = x.get(g);
                                                                    pathlist[h][7]=0;
                                                                    h += 1;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        int [][] timelist=new int [720][2187];
        double [][] costlist=new double [720][2187];
        int[][][] transportlist = new int[720][2187][7];
        int Trouteno =1;
        //permutate with public transport
        for(int j=0; j<h;j++){
            Trouteno=0;
            for(int k=0;k<3;k++){
                for(int l=0;l<3;l++){
                    for (int m=0;m<3;m++){
                        if (x.size() == 2) {
                            int p0 = pathlist[j][0];
                            int p1 = pathlist[j][1];
                            int p2 = pathlist[j][2];
                            int p3 = pathlist[j][3];
                            transportlist[j][Trouteno][0] = k;
                            transportlist[j][Trouteno][1] = l;
                            transportlist[j][Trouteno][2] = m;
                            costlist[j][Trouteno] = Cost[p0][p1][k] + Cost[p1][p2][l] + Cost[p2][p3][m];
                            timelist[j][Trouteno] = Time[p0][p1][k] + Time[p1][p2][l] + Time[p2][p3][m];
                            Trouteno += 1;
                        }
                        else {
                            for (int o = 0; o < 3; o++) {
                                if (x.size() == 3) {
                                    int p0=pathlist[j][0];
                                    int p1=pathlist[j][1];
                                    int p2=pathlist[j][2];
                                    int p3=pathlist[j][3];
                                    int p4=pathlist[j][4];
                                    transportlist[j][Trouteno][0] = k;
                                    transportlist[j][Trouteno][1] = l;
                                    transportlist[j][Trouteno][2] = m;
                                    transportlist[j][Trouteno][3] = o;
                                    costlist[j][Trouteno]=Cost[p0][p1][k]+Cost[p1][p2][l]+Cost[p2][p3][m]+Cost[p3][p4][o];
                                    timelist[j][Trouteno]=Time[p0][p1][k]+Time[p1][p2][l]+Time[p2][p3][m]+Time[p3][p4][o];
                                    Trouteno += 1;
                                } else {
                                    for (int n = 0; n < 3; n++) {
                                        if (x.size() == 4) {
                                            int p0=pathlist[j][0];
                                            int p1=pathlist[j][1];
                                            int p2=pathlist[j][2];
                                            int p3=pathlist[j][3];
                                            int p4=pathlist[j][4];
                                            int p5=pathlist[j][5];
                                            transportlist[j][Trouteno][0] = k;
                                            transportlist[j][Trouteno][1] = l;
                                            transportlist[j][Trouteno][2] = m;
                                            transportlist[j][Trouteno][3] = o;
                                            transportlist[j][Trouteno][4] = n;
                                            costlist[j][Trouteno]=Cost[p0][p1][k]+Cost[p1][p2][l]+Cost[p2][p3][m]+Cost[p3][p4][o]+Cost[p4][p5][n];
                                            timelist[j][Trouteno]=Time[p0][p1][k]+Time[p1][p2][l]+Time[p2][p3][m]+Time[p3][p4][o]+Time[p4][p5][n];
                                            Trouteno += 1;
                                        }
                                        else{
                                            for (int n1 = 0; n1 < 3; n1++){
                                                if (x.size() == 5) {
                                                    int p0 = pathlist[j][0];
                                                    int p1 = pathlist[j][1];
                                                    int p2 = pathlist[j][2];
                                                    int p3 = pathlist[j][3];
                                                    int p4 = pathlist[j][4];
                                                    int p5 = pathlist[j][5];
                                                    int p6 = pathlist[j][6];
                                                    transportlist[j][Trouteno][0] = k;
                                                    transportlist[j][Trouteno][1] = l;
                                                    transportlist[j][Trouteno][2] = m;
                                                    transportlist[j][Trouteno][3] = o;
                                                    transportlist[j][Trouteno][4] = n;
                                                    transportlist[j][Trouteno][5] = n1;
                                                    costlist[j][Trouteno] = Cost[p0][p1][k] + Cost[p1][p2][l] + Cost[p2][p3][m] + Cost[p3][p4][o] + Cost[p4][p5][n] + Cost[p5][p6][n1];
                                                    timelist[j][Trouteno] = Time[p0][p1][k] + Time[p1][p2][l] + Time[p2][p3][m] + Time[p3][p4][o] + Time[p4][p5][n] + Time[p5][p6][n1];
                                                    Trouteno += 1;
                                                }
                                                else{
                                                    for (int n2 = 0; n2 < 3; n2++) {
                                                        if (x.size() == 6) {
                                                            int p0 = pathlist[j][0];
                                                            int p1 = pathlist[j][1];
                                                            int p2 = pathlist[j][2];
                                                            int p3 = pathlist[j][3];
                                                            int p4 = pathlist[j][4];
                                                            int p5 = pathlist[j][5];
                                                            int p6 = pathlist[j][6];
                                                            int p7 = pathlist[j][7];
                                                            transportlist[j][Trouteno][0] = k;
                                                            transportlist[j][Trouteno][1] = l;
                                                            transportlist[j][Trouteno][2] = m;
                                                            transportlist[j][Trouteno][3] = o;
                                                            transportlist[j][Trouteno][4] = n;
                                                            transportlist[j][Trouteno][5] = n1;
                                                            costlist[j][Trouteno] = Cost[p0][p1][k] + Cost[p1][p2][l] + Cost[p2][p3][m] + Cost[p3][p4][o] + Cost[p4][p5][n] + Cost[p5][p6][n1] + Cost[p6][p7][n2];
                                                            timelist[j][Trouteno] = Time[p0][p1][k] + Time[p1][p2][l] + Time[p2][p3][m] + Time[p3][p4][o] + Time[p4][p5][n] + Time[p5][p6][n1] + Time[p6][p7][n2];
                                                            Trouteno += 1;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        ArrayList<Integer> timewithinbudget= new ArrayList<Integer>();
        ArrayList<Integer> getq=new ArrayList<Integer>();
        ArrayList<Integer> getr=new ArrayList<Integer>();
        int q=1;
        int r=1;
        for(q=0; q<h;q++){//q=pathlist
            for( r=0; r<Trouteno;r++){ //r=Trouteno
                if (costlist[q][r]<=travelcost){
                    timewithinbudget.add(timelist[q][r]);
                    getq.add(q);
                    getr.add(r);
                }
            }
        }
//        int timemin=Collections.min(timewithinbudget);
//        int indexmin=timewithinbudget.indexOf(timemin);
        int indexmin=0;
        int w=timewithinbudget.get(0);
        for(int u=1;u<timewithinbudget.size();u++){
            if(timewithinbudget.get(u)<w){
                w=timewithinbudget.get(u);
                indexmin=u;
            }
        }
        int getminpathlist=getq.get(indexmin);
        int getminTrouteno=getr.get(indexmin);
        ArrayList<String>optimalpath=new ArrayList<>();
        for(int s=0; s<x.size()+2;s++){
            optimalpath.add(places.get(pathlist[getminpathlist][s]));
        }
        ArrayList<String>Transportmode=new ArrayList<>();
        for(int t=0;t<x.size()+1;t++){
            if(transportlist[getminpathlist][getminTrouteno][t]==0){
                Transportmode.add("Travel on Foot");
            }
            if(transportlist[getminpathlist][getminTrouteno][t]==1){
                Transportmode.add("Travel by Public Transport");
            }
            if(transportlist[getminpathlist][getminTrouteno][t]==2){
                Transportmode.add("Travel by Taxi");
            }
        }
        result = new ArrayList<String>();
        for(int z=0;z<Transportmode.size();z++){
            result.add(optimalpath.get(z));
            result.add(Transportmode.get(z));
        }
        result.add(optimalpath.get(Transportmode.size()));
        result.add("Total Cost: S$"+Double.toString((costlist[getminpathlist][getminTrouteno])));

        result.add("Total Time: "+Integer.toString(timelist[getminpathlist][getminTrouteno])+" mins");
    }

    public static ArrayList<String> getResult(){
        return result;
    }


    public static void main(String[] args) {
        /*
        ArrayList<String> arg= new ArrayList<>();
        arg.add("Vivo City");
        arg.add("Singapore Flyer");
        arg.add("Zoo");
        ENUM(arg,Integer.parseInt("2"));
        System.out.println(getResult());
        */

    }
}


package com.shekspeare.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HttpRequests {

	static class IThread implements Runnable{

        static double timing(String url) {
            try {
                URL myUrl = new URL(url);
                long l = System.currentTimeMillis();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(myUrl.openStream()));
                while ((in.readLine()) != null);
                in.close();
                double spentMS = System.currentTimeMillis()  - l;
                return spentMS/1000;
            }catch (Throwable t){
                return Double.MAX_VALUE ;
            }
        }

        static List<IThread> makePool(int times, String url){
            List<IThread> pool = new ArrayList<>(times);
            for ( int i = 0 ; i < times; i++ ){
                IThread it = new IThread(url);
                Thread t = new Thread( it);
                pool.add(it);
                t.start();
            }
            return pool;
        }

        double timing;

        final String url;

        Thread myThread;

        IThread(String url){
            this.url = url;
            timing = Double.MAX_VALUE ;

        }

        @Override
        public void run() {
            this.myThread = Thread.currentThread();
            timing = timing(url);
        }
    }

    public static void analyze(int times, String url){
        List<IThread> pool = IThread.makePool(times,url);
        // wait for all to complete execution :: poll()
        while ( true ){
            boolean oneAlive = false ;
            for ( IThread t : pool ){
            	if(null!=t.myThread){
            		oneAlive |= t.myThread.isAlive();
            	}
            }
            if ( !oneAlive ){ break; }
        }
        List<Double> data = new ArrayList<>();
        for ( IThread t : pool ){
            data.add(t.timing);
        }
        
/*        data.add(5.0);
        data.add(1.0);
        data.add(9.0);
        data.add(3.0);
        data.add(14.0);
        data.add(9.0);
        data.add(7.0);
        */
       
        // now we have the data, do mean, sd, what not...
        Collections.sort(data);
        
        int _90 = (int)((times * 90)/100 +0.5);
        System.out.printf("90p is : %f", data.get(_90 ) );
    }

    public static void main(String[] args){
        analyze(7, "https://en.wikipedia.org/wiki/Main_Page" );
    }

}

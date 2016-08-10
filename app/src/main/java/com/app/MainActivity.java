package com.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    private TextView  tv1 , tv2 ,tv3 ,tv4 ,tv5 ,tv6 ,tv7 ,tv8 ,tv9 ,tv10 ,tv11 ,tv12   ;
    private MyTask myTask1 ,  myTask2 , myTask3 , myTask4 , myTask5, myTask6, myTask7 ,
            myTask8  , myTask9 , myTask10  , myTask11 , myTask12 ;

    static  int i = 0 ;
    Executor executor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById( R.id.tv1 );
        tv2 = (TextView) findViewById( R.id.tv2 );
        tv3 = (TextView) findViewById( R.id.tv3 );
        tv4 = (TextView) findViewById( R.id.tv4 );
        tv5 = (TextView) findViewById( R.id.tv5 );
        tv6 = (TextView) findViewById( R.id.tv6 );
        tv7 = (TextView) findViewById( R.id.tv7 );
        tv8 = (TextView) findViewById( R.id.tv8 );
        tv9 = (TextView) findViewById( R.id.tv9 );
        tv10 = (TextView) findViewById( R.id.tv10 );
        tv11 = (TextView) findViewById( R.id.tv11 );
        tv12 = (TextView) findViewById( R.id.tv12 );

        initTask();

        //创建缓冲队列 队列长度：100
        BlockingQueue<Runnable> sPoolWorkQueue =
                new LinkedBlockingQueue<Runnable>(3);

        //创建线程池 核心线程：5  最大线程：10 线程空闲存活：1秒
        executor = new ThreadPoolExecutor(  6 , 8 , 1 , TimeUnit.SECONDS,
                sPoolWorkQueue, new DefaultThreadFactory() ) ;

        //添加任务到缓冲队列
        myTask1.executeOnExecutor( executor , "" ) ;
        myTask2.executeOnExecutor( executor , "" ) ;
        myTask3.executeOnExecutor( executor , "" ) ;
        myTask4.executeOnExecutor( executor , "" ) ;
        myTask5.executeOnExecutor( executor , "" ) ;
        myTask6.executeOnExecutor( executor , "" ) ;
        myTask7.executeOnExecutor( executor , "" ) ;
        myTask8.executeOnExecutor( executor , "" ) ;
        myTask9.executeOnExecutor( executor , "" ) ;
        myTask10.executeOnExecutor( executor , "" ) ;
        myTask11.executeOnExecutor( executor , "" ) ;
      //  myTask12.executeOnExecutor( executor , "" ) ;

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTask9.executeOnExecutor( executor , "" ) ;
                //   myTask10.executeOnExecutor( executor , "" ) ;
                //      myTask11.executeOnExecutor( executor , "" ) ;
                //     myTask12.executeOnExecutor( executor , "" ) ;
            }
        });

    }

    /**
     * The default thread factory
     */
    static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        DefaultThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = "pool-" +
                    poolNumber.getAndIncrement() +
                    "-thread-";
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            Log.d( "thread--", "创建线程了"  + ( ++i)) ;
            return t;
        }
    }



    public void  initTask( ){
        myTask1 = new MyTask().setTaskListener(new MyTask.TaskListener() {
            @Override
            public void start() {

            }

            @Override
            public void update(int progress) {
                tv1.setText( "" + progress );
            }

            @Override
            public Object doInBackground(Object o) {
                try {
                    for ( int j = 0 ; j< 50 ; j++ ){
                        Thread.sleep( 100 );
                        myTask1.updateProgress( j );
                    }

                }catch ( Exception e){

                }
                return null;
            }

            @Override
            public void result(Object o) {

            }
        }) ;

        myTask2 = new MyTask().setTaskListener(new MyTask.TaskListener() {
            @Override
            public void start() {

            }

            @Override
            public void update(int progress) {
                tv2.setText( "" + progress );
            }

            @Override
            public Object doInBackground(Object o) {
                try {
                    for ( int j = 0 ; j< 100 ; j++ ){
                        Thread.sleep( 100 );
                        myTask2.updateProgress( j );
                    }

                }catch ( Exception e){

                }
                return null;
            }

            @Override
            public void result(Object o) {

            }
        }) ;

        myTask3 = new MyTask().setTaskListener(new MyTask.TaskListener() {
            @Override
            public void start() {

            }

            @Override
            public void update(int progress) {
                tv3.setText( "" + progress );
            }

            @Override
            public Object doInBackground(Object o) {
                try {
                    for ( int j = 0 ; j< 100 ; j++ ){
                        Thread.sleep( 100 );
                        myTask3.updateProgress( j );
                    }

                }catch ( Exception e){

                }
                return null;
            }

            @Override
            public void result(Object o) {

            }
        }) ;

        myTask4 = new MyTask().setTaskListener(new MyTask.TaskListener() {
            @Override
            public void start() {

            }

            @Override
            public void update(int progress) {
                tv4.setText( "" + progress );
            }

            @Override
            public Object doInBackground(Object o) {
                try {
                    for ( int j = 0 ; j< 100 ; j++ ){
                        Thread.sleep( 100 );
                        myTask4.updateProgress( j );
                    }

                }catch ( Exception e){

                }
                return null;
            }

            @Override
            public void result(Object o) {

            }
        }) ;

        myTask5 = new MyTask().setTaskListener(new MyTask.TaskListener() {
            @Override
            public void start() {

            }

            @Override
            public void update(int progress) {
                tv5.setText( "" + progress );
            }

            @Override
            public Object doInBackground(Object o) {
                try {
                    for ( int j = 0 ; j< 100 ; j++ ){
                        Thread.sleep( 100 );
                        myTask5.updateProgress( j );
                    }

                }catch ( Exception e){

                }
                return null;
            }

            @Override
            public void result(Object o) {

            }
        }) ;

        myTask6 = new MyTask().setTaskListener(new MyTask.TaskListener() {
            @Override
            public void start() {

            }

            @Override
            public void update(int progress) {
                tv6.setText( "" + progress );
            }

            @Override
            public Object doInBackground(Object o) {
                try {
                    for ( int j = 0 ; j< 100 ; j++ ){
                        Thread.sleep( 100 );
                        myTask6.updateProgress( j );
                    }

                }catch ( Exception e){

                }
                return null;
            }

            @Override
            public void result(Object o) {

            }
        }) ;

        myTask7 = new MyTask().setTaskListener(new MyTask.TaskListener() {
            @Override
            public void start() {

            }

            @Override
            public void update(int progress) {
                tv7.setText( "" + progress );
            }

            @Override
            public Object doInBackground(Object o) {
                try {
                    for ( int j = 0 ; j< 100 ; j++ ){
                        Thread.sleep( 100 );
                        myTask7.updateProgress( j );
                    }

                }catch ( Exception e){

                }
                return null;
            }

            @Override
            public void result(Object o) {

            }
        }) ;

        myTask8 = new MyTask().setTaskListener(new MyTask.TaskListener() {
            @Override
            public void start() {

            }

            @Override
            public void update(int progress) {
                tv8.setText( "" + progress );
            }

            @Override
            public Object doInBackground(Object o) {
                try {
                    for ( int j = 0 ; j< 100 ; j++ ){
                        Thread.sleep( 100 );
                        myTask8.updateProgress( j );
                    }

                }catch ( Exception e){

                }
                return null;
            }

            @Override
            public void result(Object o) {

            }
        }) ;

        myTask9 = new MyTask().setTaskListener(new MyTask.TaskListener() {
            @Override
            public void start() {

            }

            @Override
            public void update(int progress) {
                tv9.setText( "" + progress );
            }

            @Override
            public Object doInBackground(Object o) {
                try {
                    for ( int j = 0 ; j< 100 ; j++ ){
                        Thread.sleep( 100 );
                        myTask9.updateProgress( j );
                    }

                }catch ( Exception e){

                }
                return null;
            }

            @Override
            public void result(Object o) {

            }
        }) ;

        myTask10 = new MyTask().setTaskListener(new MyTask.TaskListener() {
            @Override
            public void start() {

            }

            @Override
            public void update(int progress) {
                tv10.setText( "" + progress );
            }

            @Override
            public Object doInBackground(Object o) {
                try {
                    for ( int j = 0 ; j< 100 ; j++ ){
                        Thread.sleep( 100 );
                        myTask10.updateProgress( j );
                    }

                }catch ( Exception e){

                }
                return null;
            }

            @Override
            public void result(Object o) {

            }
        }) ;

        myTask11 = new MyTask().setTaskListener(new MyTask.TaskListener() {
            @Override
            public void start() {

            }

            @Override
            public void update(int progress) {
                tv11.setText( "" + progress );
            }

            @Override
            public Object doInBackground(Object o) {
                try {
                    for ( int j = 0 ; j< 100 ; j++ ){
                        Thread.sleep( 100 );
                        myTask11.updateProgress( j );
                    }

                }catch ( Exception e){

                }
                return null;
            }

            @Override
            public void result(Object o) {

            }
        }) ;

        myTask12 = new MyTask().setTaskListener(new MyTask.TaskListener() {
            @Override
            public void start() {

            }

            @Override
            public void update(int progress) {
                tv12.setText( "" + progress );
            }

            @Override
            public Object doInBackground(Object o) {
                try {
                    for ( int j = 0 ; j< 100 ; j++ ){
                        Thread.sleep( 100 );
                        myTask12.updateProgress( j );
                    }

                }catch ( Exception e){

                }
                return null;
            }

            @Override
            public void result(Object o) {

            }
        }) ;
    }
}

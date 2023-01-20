package com.example.socketprogramming;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyService extends Service {
    public MyService() {
    }

    Socket socket;
    ServerSocket serversocket;
    Socket socket2;
    DataInputStream is;
    DataOutputStream os;
    BufferedReader input;
    String msg = "@RA 0 0\r";
    StringBuffer sb = new StringBuffer();

    BufferedReader br;
    BufferedWriter bw;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String str = intent.getStringExtra("str");


        if (str.equals("start")) {
            try {
                ServerSocketOpen();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (str.equals("send")) {
            msg = "@RA 23913 11097\r";
            SendMessage(msg);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            msg = "@RA 0 0\r";

        }
        return super.onStartCommand(intent, flags, startId);
    }


    public void ServerSocketOpen() throws IOException {

        //Android API14버전이상 부터 네트워크 작업은 무조건 별도의 Thread에서 실행 해야함.
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    //서버소켓 생성.
                    serversocket = new ServerSocket(12345);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                try {
                    //서버에 접속하는 클라이언트 소켓 얻어오기(클라이언트가 접속하면 클라이언트 소켓 리턴)
                    socket = serversocket.accept(); //서버는 클라이언트가 접속할 때까지 여기서 대기 접속하면 다음으로 코드로 넘어감
                    //클라이언트와 데이터를 주고 받기 위한 통로구축
                    is = new DataInputStream(socket.getInputStream()); //클라이언트로 부터 메세지를 받기 위한 통로
                    os = new DataOutputStream(socket.getOutputStream()); //클라이언트로 메세지를 보내기 위한 통로

                    br = new BufferedReader(new InputStreamReader(is));
                    bw = new BufferedWriter(new OutputStreamWriter(os));


//                        os.writeBytes("@RA 23913 11097\n");
////                    os.writeChars(msg);
//                        //클라이언트로 메세지 보내기.UTF 방식으로 한글 전송 가능하게함
//                        os.flush();

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                send();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                while (socket.isConnected()) {

                    System.out.println("게속 read!!");
                    try {
                        char c = (char) is.read();
                        sb.append(c);


                        System.out.println(sb.toString());
                        if (c == '\r') {
                            Log.i("read", sb.toString());
                            String[] s = sb.toString().split(" ");
                            System.out.println("result");
                            System.out.println(sb.toString());
                            if (s[0].equals("$TA")) {
                                sb.replace(0, 1, "+");

                                msg = sb.toString();
                                Thread.sleep(1000);
                                sb.replace(0, 3, "@RA");
                                msg = sb.toString();
                                System.out.println("MSG -> "+sb.toString());

                                String aaa = "@RA "+sb.toString().substring(4)+"\r";
                                System.out.println("232323232");
                                System.out.println(aaa);
                                        SendMessage(aaa);

                            }else{

                            }

                            sb.replace(0, sb.toString().length(), "");

                        }

                    } catch (IOException | InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        break;
                    }
                    //클라이언트로부터 읽어들인 메시지msg를 TextView에 출력한다. 안드로이드는 메인스레드가 아니면 UI변경 불가하므로 다음과같이 해줌.(토스트메세지도 마찬가지)

                }//while..

                //클라이언트가 접속을 끊을 때까지 무한반복하면서 클라이언트의 메세지 수신

            }//run method...
        }).start(); //Thread 실행..
    }
    public void SendMessage(String a) {

        if(os==null) return; //클라이언트와 연결되어 있지 않다면 전송불가

        System.out.println("여기들어옴");

        //네트워크 작업이므로 Thread 생성
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                //클라이언트로 보낼 메세지 EditText로 부터 얻어오기

                try {
                    System.out.println(a);
                    bw.write(a);
                    bw.flush();



//                    os.writeBytes(msg);
////                    os.writeChars(msg);
//                                    //클라이언트로 메세지 보내기.UTF 방식으로 한글 전송 가능하게함
//                    os.flush();   //다음 메세지 전송을 위해 연결통로의 버퍼를 지워주는 메소드
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start(); //Thread 실행..
    }

    public void send() throws InterruptedException {


//                while (true) {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {


                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            //클라이언트로 보낼 메세지 EditText로 부터 얻어오기

                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                 ;
                                    try {

                                        bw.write(msg);
                                        bw.flush();
                                        Thread.sleep(500);
                                    } catch (IOException | InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                }
                            }).start();


//                    os.writeBytes(msg);
////                    os.writeChars(msg);
//                                    //클라이언트로 메세지 보내기.UTF 방식으로 한글 전송 가능하게함
//                    os.flush();   //다음 메세지 전송을 위해 연결통로의 버퍼를 지워주는 메소드
                        }
                    }, 0);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


//    }
}



package com.example.socketprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class MainActivity extends AppCompatActivity {
    private Handler mHandler;
    InetAddress serverAddr;
    Socket socket;
    PrintWriter sendWriter;
    private String ip = "192.168.0.3";
    private String port = "333";
    JSONObject jsonObject ;
    TextView textView;
    String UserID;
    Button connectbutton;
    Button chatbutton;
    TextView chatView;
    EditText message;
    EditText r1;
    EditText r2;
    Button r1Button;
    Button r2Button;

    String sendmsg;
    String read;
    EditText signal2;
    Button signal2Send;

    ServerSocket serversocket;
    Socket socket2;
    DataInputStream is;
    DataOutputStream os;
    BufferedReader input;
    String msg ="";
    StringBuffer sb = new StringBuffer();

    BufferedReader br;
    BufferedWriter bw;

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHandler = new Handler();

        txt = findViewById(R.id.txt);
        message = (EditText) findViewById(R.id.Ip);
        message.setText("101 1 1 01 01 1 0 10 01");
        chatView = findViewById(R.id.chatView);
        signal2 = findViewById(R.id.content);
        signal2.setText("@RA 22576 8192\r");
        signal2Send = findViewById(R.id.contentButton);
        Intent intent = getIntent();
        UserID = intent.getStringExtra("username");
        chatbutton = (Button) findViewById(R.id.ipButton);

        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r1Button = findViewById(R.id.r1Send);
        r2Button = findViewById(R.id.r2Send);

        r1.setText("@RA 23913 11097\r");
        r2.setText("@R2 11097\r");

        jsonObject = new JSONObject();
//        ClientSocketOpen();

        try {
            message.setText(getLocalIpAddress());
//            ServerSocketOpen();


        } catch (IOException e) {
            e.printStackTrace();
        }
        Intent intent1 = new Intent(this , MyService.class);
        intent1.putExtra("str","start");
        startService(intent1);



        chatbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                go();


            }
        });

        signal2Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendmsg = signal2.getText().toString();
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {

                            go();

//                            SendMessage();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();


            }
        });


        r1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(){
                    @Override
                    public void run() {
                        try {
                            go();
//                            send(r1.getText().toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }

        });


        r2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(){
                    @Override
                    public void run() {
                        try {

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();

            }
        });


    }


public void go(){
    Intent intent1 = new Intent(this , MyService.class);
    intent1.putExtra("str","send");
    startService(intent1);
}
//    public void send(String str){
//        while (true){
//            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
//
//                @Override
//                public void run() {
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            // TODO Auto-generated method stub
//                            //클라이언트로 보낼 메세지 EditText로 부터 얻어오기
//
//                            try {
//                                System.out.println(str);
//                                bw.write(str);
//                                bw.flush();
//                                runOnUiThread(new Runnable() {
//                                    @Override
//                                    public void run() {
//
//                                        // TODO Auto-generated method stub
//                                        chatView.setText("[SEND]" +msg);
//                                    }
//                                });
//
//
//
////                    os.writeBytes(msg);
//////                    os.writeChars(msg);
////                                    //클라이언트로 메세지 보내기.UTF 방식으로 한글 전송 가능하게함
////                    os.flush();   //다음 메세지 전송을 위해 연결통로의 버퍼를 지워주는 메소드
//                            } catch (IOException e) {
//                                // TODO Auto-generated catch block
//                                e.printStackTrace();
//                            }
//                        }
//                    }).start(); //Thread 실행..
//                }
//            },100);
//        }
//
//    }
//
//    //클라이언트 소켓 열고 서버 소켓에 접속
//    public void ClientSocketOpen() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//                try {
//                    ip= message.getText().toString();//IP 주소가 작성되어 있는 EditText에서 서버 IP 얻어오기
//                    port = "333";
//                    if(ip.isEmpty() || port.isEmpty()){
//                        MainActivity.this.runOnUiThread(new Runnable() {
//                            public void run() {
//                                Toast.makeText(MainActivity.this, "ip주소와 포트번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                    }else {
//                        //서버와 연결하는 소켓 생성..
//                        socket = new Socket(InetAddress.getByName("192.168.0.7"), Integer.parseInt("12345"));
//                        //여기까지 왔다는 것을 예외가 발생하지 않았다는 것이므로 소켓 연결 성공..
//
//                        //서버와 메세지를 주고받을 통로 구축
//                        is = new DataInputStream(socket.getInputStream());
//                        os = new DataOutputStream(socket.getOutputStream());
//
//
//                        br = new BufferedReader(new InputStreamReader(is));
//                        bw = new BufferedWriter(new OutputStreamWriter(os));
//
//
//                        MainActivity.this.runOnUiThread(new Runnable() {
//                            public void run() {
//                                Toast.makeText(MainActivity.this, "Connected With Server", Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                    }
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//
//                //서버와 접속이 끊길 때까지 무한반복하면서 서버의 메세지 수신
//                while(socket.isConnected()){
//                    try {
//                        msg= is.readUTF(); //서버 부터 메세지가 전송되면 이를 UTF형식으로 읽어서 String 으로 리턴
//                        //runOnUiThread()는 별도의 Thread가 main Thread에게 UI 작업을 요청하는 메소드이다
//
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                // TODO Auto-generated method stub
//                                chatView.setText("[RECV]" +msg);
//                                signal2.setText("");
//                                signal2.setText("+"+msg.substring(1,msg.length()));
//                                System.out.println("+"+msg.substring(1,msg.length()));
//                            }
//                        });
//                    } catch (IOException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }//while
//            }//run method...
//        }).start();//Thread 실행..
//
//    }
//
//    public void ServerSocketOpen() throws IOException {
//        final String port = message.getText().toString();
//        if(port.isEmpty()){
//            Toast.makeText(this, "포트번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
//        }else {
//            Toast.makeText(this, "Socket Open", Toast.LENGTH_SHORT).show();
//            //Android API14버전이상 부터 네트워크 작업은 무조건 별도의 Thread에서 실행 해야함.
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    // TODO Auto-generated method stub
//                    try {
//                        //서버소켓 생성.
//                        serversocket = new ServerSocket(12345);
//                    } catch (IOException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                    try {
//                        //서버에 접속하는 클라이언트 소켓 얻어오기(클라이언트가 접속하면 클라이언트 소켓 리턴)
//                        socket = serversocket.accept(); //서버는 클라이언트가 접속할 때까지 여기서 대기 접속하면 다음으로 코드로 넘어감
//                        //클라이언트와 데이터를 주고 받기 위한 통로구축
//                        is = new DataInputStream(socket.getInputStream()); //클라이언트로 부터 메세지를 받기 위한 통로
//                        os = new DataOutputStream(socket.getOutputStream()); //클라이언트로 메세지를 보내기 위한 통로
//
//                        br = new BufferedReader(new InputStreamReader(is));
//                        bw = new BufferedWriter(new OutputStreamWriter(os));
//
////                        os.writeBytes("@RA 23913 11097\n");
//////                    os.writeChars(msg);
////                        //클라이언트로 메세지 보내기.UTF 방식으로 한글 전송 가능하게함
////                        os.flush();
//
//                        MainActivity.this.runOnUiThread(new Runnable() {
//                            public void run() {
//                                Toast.makeText(MainActivity.this, "Connected With Client Socket", Toast.LENGTH_SHORT).show();
//                            }
//                        });
//
//
//                    } catch (IOException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                    //클라이언트가 접속을 끊을 때까지 무한반복하면서 클라이언트의 메세지 수신
//                    while (socket.isConnected()) {
//                        try {
//                            char c = (char)is.read();
//
//                        sb.append(c);
//
//                                if(c=='\r'){
//                                    runOnUiThread(new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            // TODO Auto-generated method stub
//                                            msg = sb.toString();
//                                chatView.setText("[RECV]" +msg);
//                                signal2.setText("+"+msg.substring(1,msg.length()));
//                                System.out.println("+"+msg.substring(2,msg.length()));
//                                sb.replace(0,sb.toString().length(),"");
//
//                                txt.setText(msg);
//                                        }
//                                    });
//                                }
//
//                        } catch (IOException e) {
//                            // TODO Auto-generated catch block
//                            e.printStackTrace();
//                            break;
//                        }
//                        //클라이언트로부터 읽어들인 메시지msg를 TextView에 출력한다. 안드로이드는 메인스레드가 아니면 UI변경 불가하므로 다음과같이 해줌.(토스트메세지도 마찬가지)
//
//                    }//while..
//                }//run method...
//            }).start(); //Thread 실행..
//        }
//    }
//
//    public void SendMessage() {
//
//        if(os==null) return; //클라이언트와 연결되어 있지 않다면 전송불가
//
//        final String msg= signal2.getText().toString();
//
//        //네트워크 작업이므로 Thread 생성
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//                //클라이언트로 보낼 메세지 EditText로 부터 얻어오기
//
//                try {
//                    System.out.println(msg);
//                    bw.write(msg);
//                    bw.flush();
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//
//                            // TODO Auto-generated method stub
//                            chatView.setText("[SEND]" +msg);
//                        }
//                    });
//
//
//
////                    os.writeBytes(msg);
//////                    os.writeChars(msg);
////                                    //클라이언트로 메세지 보내기.UTF 방식으로 한글 전송 가능하게함
////                    os.flush();   //다음 메세지 전송을 위해 연결통로의 버퍼를 지워주는 메소드
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//        }).start(); //Thread 실행..
//    }
//
//
//    public void SendMessage(String exit) {
//
//        if(os==null) return; //클라이언트와 연결되어 있지 않다면 전송불가
//
//        final String msg= signal2.getText().toString();
//
//        //네트워크 작업이므로 Thread 생성
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//                //클라이언트로 보낼 메세지 EditText로 부터 얻어오기
//
//                try {
//                    bw.write(exit);
//                    bw.flush();
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//
//                            // TODO Auto-generated method stub
//                            chatView.setText("[SEND]" +msg);
//                        }
//                    });
//
//
//
////                    os.writeBytes(msg);
//////                    os.writeChars(msg);
////                                    //클라이언트로 메세지 보내기.UTF 방식으로 한글 전송 가능하게함
////                    os.flush();   //다음 메세지 전송을 위해 연결통로의 버퍼를 지워주는 메소드
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//        }).start(); //Thread 실행..
//    }
//

    private String getLocalIpAddress() throws UnknownHostException {
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        assert wifiManager != null;
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int ipInt = wifiInfo.getIpAddress();
        return InetAddress.getByAddress(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(ipInt).array()).getHostAddress();
    }
}
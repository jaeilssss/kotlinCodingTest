import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class testSocket {

    static DataInputStream is;
    static DataOutputStream os;

    public static void main(String [] args){

        try {
            InetSocketAddress isa = new InetSocketAddress("127.0.0.1", 12345);
            Socket socket = new Socket();

            socket.setReuseAddress(true);
            socket.connect(isa);

            //서버와 메세지를 주고받을 통로 구축
            is = new DataInputStream(socket.getInputStream());
            os = new DataOutputStream(socket.getOutputStream());
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true){
                String msg = input.readLine();
                if(msg!=null){
                    System.out.println(msg);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

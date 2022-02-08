import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class test2 {
    static DataInputStream is;
    static DataOutputStream os;
    public static void main(String [] args){

        try {
            Socket socket = new Socket(args[0],1234);
            //서버와 메세지를 주고받을 통로 구축
            is = new DataInputStream(socket.getInputStream());
            os = new DataOutputStream(socket.getOutputStream());

            while (true){
                String msg = is.readUTF();
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

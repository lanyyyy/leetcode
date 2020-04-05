package learn.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("服务器你好".getBytes());
        InputStream inputStream = socket.getInputStream();

        byte[] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        System.out.println(new String(bytes, 0, read));

        socket.close();

    }
}

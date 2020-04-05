package learn.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        byte[] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        System.out.println("获取到了： " + new String(bytes, 0 , read));

        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("小子，等等".getBytes());

        accept.close();
        serverSocket.close();
    }
}

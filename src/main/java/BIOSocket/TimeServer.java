package main.java.BIOSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 时间服务器-服务端代码
 */
public class TimeServer {

    public static void main(String[] args) throws IOException {
        int port = 8080;

        if (args != null && args.length > 0) {
            port = Integer.valueOf(args[0]);
        }

        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start at port :" + port);

            Socket socket = null;
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50, 10000);

            while (true) {
                socket = server.accept();
                singleExecutor.execute(new TimeServerHandler(socket));
            }
        } finally {
            if (server != null) {
                System.out.println("The time server close");
                server.close();
                server = null;
            }
        }
    }
}

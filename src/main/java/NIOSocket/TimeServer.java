package main.java.NIOSocket;

/**
 *  NIO服务端 socket通信
 */
public class TimeServer {

    public static void main(String[] args) {

        int port = 8080;

        if (args != null && args.length > 0) {
            port = Integer.valueOf(args[0]);
        }

        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);

        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}

package main.java.NIOSocket;

/**
 * NIO 客户端
 */
public class TimeClient {

    public static void main(String[] args) {

        int port = 8080;
        new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient-001").start();
    }
}

package main.java.AIOSocket;

/**
 * NIO 2.0 引入了新的异步通道的概念，并提供了异步文件通道和异步套接字通道的实现
 * NIO 2.0的异步套接字通道是真正的异步非阻塞IO， 对应于UNIX网络编程中的事件驱动IO，他不需要通过多路复用器（Selector）对注册的通道
 * 进行轮询操作即可实现异步读写，从而简化了NIO的编程模型。
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 8080;

        AsyncTimeServerHandler timeServerHandle = new AsyncTimeServerHandler(port);

        new Thread(timeServerHandle, "AIO-AsyncTimeServerHandler-001").start();

    }
}

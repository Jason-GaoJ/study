package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.LineEncoder;
import io.netty.handler.codec.string.LineSeparator;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Jason
 * @date 2020/5/11 17:43
 * @description
 */
public class EchoServer {

    private final String host;
    private final int port;

    public EchoServer(String host, int port) {
        this.port = port;
        this.host = host;
    }

    public void start() throws Exception {

        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup woker = new NioEventLoopGroup();
        ServerBootstrap b = new ServerBootstrap();
        b.group(boss, woker)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline()
                                .addLast(new LineBasedFrameDecoder(1024))//添加换行解码器，解决TCP粘包/拆包问题
                                .addLast(new StringDecoder(CharsetUtil.UTF_8))//添加字符串解码器，将接收对象转换为字符串
                                .addLast(new StringEncoder(CharsetUtil.UTF_8))//添加字符串编码器
                                .addLast(new LineEncoder(LineSeparator.UNIX,CharsetUtil.UTF_8))//添加换行编码码器，解决TCP粘包/拆包问题
                                .addLast(new ChannelInboundHandler() {
                                    @Override
                                    public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {

                                    }

                                    @Override
                                    public void channelUnregistered(ChannelHandlerContext channelHandlerContext) throws Exception {

                                    }

                                    @Override
                                    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
                                        channelHandlerContext.channel().writeAndFlush("你已经连上了");
                                    }

                                    @Override
                                    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {

                                    }

                                    @Override
                                    public void channelRead(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
                                        //Thread.sleep(2000);
                                        System.out.println("收到了: "+o+"..."+Thread.currentThread().getName());
                                    }

                                    @Override
                                    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {

                                    }

                                    @Override
                                    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

                                    }

                                    @Override
                                    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {

                                    }

                                    @Override
                                    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {

                                    }

                                    @Override
                                    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {

                                    }

                                    @Override
                                    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {

                                    }
                                });
                    }
                });
    ChannelFuture f = b.bind(host, port);
}

    public static void main(String[] args) {
        try {
            LinkedBlockingQueue queue=new LinkedBlockingQueue<>();
            
            new EchoServer("127.0.0.1", 9002).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

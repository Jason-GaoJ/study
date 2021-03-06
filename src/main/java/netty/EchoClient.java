package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.LineEncoder;
import io.netty.handler.codec.string.LineSeparator;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jason
 * @date 2020/5/11 17:43
 * @description
 */
public class EchoClient {

    private final String host;
    private final int port;

    private Channel channel;

    public EchoClient(String host, int port) {
        this.port = port;
        this.host = host;
    }

    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(group)
                .channel(NioSocketChannel.class)
                .remoteAddress(new InetSocketAddress(host, port))
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline()
                                .addLast(new LineBasedFrameDecoder(1024))//添加换行解码器，解决TCP粘包/拆包问题
                                .addLast(new StringDecoder(CharsetUtil.UTF_8))//添加字符串解码器，将接收对象转换为字符串
                                .addLast(new StringEncoder(CharsetUtil.UTF_8))//添加字符串编码器
                                .addLast(new LineEncoder(LineSeparator.UNIX, CharsetUtil.UTF_8))//添加换行编码码器，解决TCP粘包/拆包问题
                                .addLast(new ChannelInboundHandler() {
                                    @Override
                                    public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {

                                    }

                                    @Override
                                    public void channelUnregistered(ChannelHandlerContext channelHandlerContext) throws Exception {

                                    }

                                    @Override
                                    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
                                        channel = channelHandlerContext.channel();
                                    }

                                    @Override
                                    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {

                                    }

                                    @Override
                                    public void channelRead(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

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
        ChannelFuture f = b.connect().sync();

    }

    private Channel getChannel(){
        return this.channel;
    }

    public static void main(String[] args) {
        try {
            EchoClient client=new EchoClient("127.0.0.1", 9002);
            client.start();
            for (int i = 0; i < 10; i++) {
                Thread t = new Thread(() -> {
                    while (true) {
                        client.getChannel().writeAndFlush(Thread.currentThread().getName());
                    }

                }, "t" + i);
                t.start();
            }
            /*Thread.sleep(2000);
            while (true){
                channel.writeAndFlush(Thread.currentThread().getName());
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

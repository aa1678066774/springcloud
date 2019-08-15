package com.tww.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.util.Scanner;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-08-07 09:18
 */
public class WebSocketHandler  extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("与客户端建立连接，通道开启！");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("与客户端断开连接，通道关闭！");
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        System.out.println("客户端收到服务器数据:" + msg.text());
        Scanner s = new Scanner(System.in);
        System.out.println("服务器推送：");
        while(true) {
            String line = s.nextLine();
            if(line.equals("exit")) {
                ctx.channel().close();
                break;
            }
            String resp= "(" +ctx.channel().remoteAddress() + ") ：" + line;
            ctx.writeAndFlush(new TextWebSocketFrame(resp));
        }
    }
}

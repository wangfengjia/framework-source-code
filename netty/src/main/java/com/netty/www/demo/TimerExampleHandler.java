package com.netty.www.demo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TimerExampleHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

        ScheduledFuture<?> future = ctx.executor().schedule(() -> {
            ctx.channel().write("hello, world");
        },3, TimeUnit.SECONDS);

        Timer timer = new HashedWheelTimer();
        Timeout timeout1 = timer.newTimeout(timeout -> System.out.println("5s后执行该任务"), 5, TimeUnit.SECONDS);

        //取消任务
//        timeout1.cancel();
    }
}

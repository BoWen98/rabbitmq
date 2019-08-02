package com.bowen.rabbitmq.start;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @ProjectName: rabbitmq
 * @Package: com.bowen.rabbitmq.start
 * @ClassName: Consumer
 * @Author: Bowen
 * @Description: 服务消费者
 * @Date: 2019/8/1 17:11
 * @Version: 1.0.0
 */
public class Consumer {


    public static void main(String[] args) throws Exception {
        //1.创建一个ConnectionFactory
        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("192.168.5.144");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("rabbit");
        connectionFactory.setPassword("123456");

        //2.通过ConnectionFactory常见链接
        Connection connection = connectionFactory.newConnection();

        //3.通过Connection创建Channel
        Channel channel = connection.createChannel();

        //4.声明一个队列
        String queueName = "test001";
        channel.queueDeclare(queueName, true, false, false, null);

        //5.设置Channel
        channel.basicConsume(queueName, true, new MyConsumer(channel));

    }
}

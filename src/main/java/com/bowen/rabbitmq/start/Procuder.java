package com.bowen.rabbitmq.start;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @ProjectName: rabbitmq
 * @Package: com.bowen.rabbitmq.start
 * @ClassName: Procuder
 * @Author: Bowen
 * @Description: 服务生产者
 * @Date: 2019/8/1 17:12
 * @Version: 1.0.0
 */
public class Procuder {

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

        String msg = "Hello RabbitMQ!";
        channel.basicPublish("", "test001", null, msg.getBytes());

        channel.close();
        connection.close();
    }
}

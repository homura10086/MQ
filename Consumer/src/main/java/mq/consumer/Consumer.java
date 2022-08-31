package mq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;

@Component
@Slf4j
@RocketMQMessageListener(consumerGroup = "springBootGroup", topic = "topic")
public class Consumer implements RocketMQListener {

    final static String concurrency = "1";

    /**activeMQ监听器*/
    @JmsListener(destination = "topicSingle")
    public void receiveSingle(TextMessage textMessage) throws Exception{
        log.info("single接收到的消息为：" + textMessage.getText());
    }

    @JmsListener(destination = "topicMulti")
    public void receiveMulti1(TextMessage textMessage) throws Exception{
        log.info("multi01接收到的消息为：" + textMessage.getText());
    }

    @JmsListener(destination = "topicMulti")
    public void receiveMulti2(TextMessage textMessage) throws Exception{
        log.info("multi02接收到的消息为：" + textMessage.getText());
    }

    @JmsListener(destination = "topicMulti")
    public void receiveMulti3(TextMessage textMessage) throws Exception{
        log.info("multi03接收到的消息为：" + textMessage.getText());
    }

    @JmsListener(destination = "topicMulti")
    public void receiveMulti4(TextMessage textMessage) throws Exception{
        log.info("multi04接收到的消息为：" + textMessage.getText());
    }

    @JmsListener(destination = "topicMulti")
    public void receiveMulti5(TextMessage textMessage) throws Exception{
        log.info("multi05接收到的消息为：" + textMessage.getText());
    }

    @JmsListener(destination = "topicMulti")
    public void receiveMulti6(TextMessage textMessage) throws Exception{
        log.info("multi06接收到的消息为：" + textMessage.getText());
    }

    @JmsListener(destination = "topicMulti")
    public void receiveMulti7(TextMessage textMessage) throws Exception{
        log.info("multi07接收到的消息为：" + textMessage.getText());
    }

    @JmsListener(destination = "topicMulti")
    public void receiveMulti8(TextMessage textMessage) throws Exception{
        log.info("multi08接收到的消息为：" + textMessage.getText());
    }

    /**rabbitMQ监听器*/
    @RabbitListener(queues = "queueSingle", concurrency = concurrency)
    public void receiveMsgSingle(Message message){
        log.info("single接收到的消息为：" + new String(message.getBody()));
    }

    @RabbitListener(queues = "queueMulti1")
    public void receiveMsgMulti1(Message message){
        log.info("multi01接收到的消息为：" + new String(message.getBody()));
    }

    @RabbitListener(queues = "queueMulti2")
    public void receiveMsgMulti2(Message message){
        log.info("multi02接收到的消息为：" + new String(message.getBody()));
    }

    @RabbitListener(queues = "queueMulti3")
    public void receiveMsgMulti3(Message message){
        log.info("multi03接收到的消息为：" + new String(message.getBody()));
    }

    @RabbitListener(queues = "queueMulti4")
    public void receiveMsgMulti4(Message message){
        log.info("multi04接收到的消息为：" + new String(message.getBody()));
    }

    @RabbitListener(queues = "queueMulti5")
    public void receiveMsgMulti5(Message message){
        log.info("multi05接收到的消息为：" + new String(message.getBody()));
    }

    @RabbitListener(queues = "queueMulti6")
    public void receiveMsgMulti6(Message message){
        log.info("multi06接收到的消息为：" + new String(message.getBody()));
    }

    @RabbitListener(queues = "queueMulti7")
    public void receiveMsgMulti7(Message message){
        log.info("multi07接收到的消息为：" + new String(message.getBody()));
    }

    @RabbitListener(queues = "queueMulti8")
    public void receiveMsgMulti8(Message message){
        log.info("multi08接收到的消息为：" + new String(message.getBody()));
    }

    @KafkaListener(topics = "first")
    public void consumerTopic(String msg){
        log.info("kafka接收到的消息为：" + msg);
    }

    @Override
    public void onMessage(Object message) {
        log.info("rocketMQ接收到的消息为：" + message);
    }
}

package mq.produce;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Topic;
import java.util.Date;
import java.util.UUID;

@RestController
@Slf4j
public class Produce {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Resource(name = "single")
    private Topic topicSingle;
    @Resource(name = "multi")
    private Topic topicMulti;
    @Resource
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/activeSingle")
    public void produceTopicSingle() throws JMSException {
        log.info("当前时间: " + new Date() + "，发送一条消息给" + topicSingle.getTopicName());
        jmsMessagingTemplate.convertAndSend(topicSingle,
                UUID.randomUUID() + "，消息来自：" + topicSingle.getTopicName());
    }

    @GetMapping("/activeMulti")
    public void produceTopicMulti() throws JMSException {
        log.info("当前时间: " + new Date() + "，发送一条消息给" + topicMulti.getTopicName());
        jmsMessagingTemplate.convertAndSend(topicMulti,
                UUID.randomUUID() + "，消息来自：" + topicMulti.getTopicName());
    }

    @GetMapping("/rabbitSingle")
    public void sendMsgSingle() {
        log.info("当前时间: " + new Date() + "，发送一条消息给" + "queueSingle");
        String msg = UUID.randomUUID() + "，消息来自：" + "queueSingle";
        /*设置非持久化消息*/
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT);
        Message message = new Message(msg.getBytes(), messageProperties);
        rabbitTemplate.send("X", "single", message);
    }

    @GetMapping("/rabbitMulti")
    public void sendMsgMulti() {
        log.info("当前时间: " + new Date() + "，发送一条消息给" + "queueMulti");
        String msg = UUID.randomUUID() + "，消息来自：" + "queueMulti";
        /*设置非持久化消息*/
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT);
        Message message = new Message(msg.getBytes(), messageProperties);
        rabbitTemplate.send("X", "multi", message);
    }
}

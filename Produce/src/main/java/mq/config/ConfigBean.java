package mq.config;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import javax.jms.Topic;

@Configuration
@EnableJms
public class ConfigBean {

    /**activeMQ配置*/
    @Bean("single")
    public Topic topicSingle() {
        return new ActiveMQTopic("topicSingle");
    }

    @Bean("multi")
    public Topic topicMulti() {
        return new ActiveMQTopic("topicMulti");
    }

    /**rabbitMQ配置*/
    @Bean("xExchange")
    public DirectExchange xDirectExchange() {
        return new DirectExchange("X", false, false);
    }

    @Bean("Single")
    public Queue queueSingle() {
        return QueueBuilder.nonDurable("queueSingle").build();
    }

    @Bean("Multi1")
    public Queue queueMulti1() {
        return QueueBuilder.nonDurable("queueMulti1").build();
    }

    @Bean("Multi2")
    public Queue queueMulti2() {
        return QueueBuilder.nonDurable("queueMulti2").build();
    }

    @Bean("Multi3")
    public Queue queueMulti3() {
        return QueueBuilder.nonDurable("queueMulti3").build();
    }

    @Bean("Multi4")
    public Queue queueMulti4() {
        return QueueBuilder.nonDurable("queueMulti4").build();
    }

    @Bean("Multi5")
    public Queue queueMulti5() {
        return QueueBuilder.nonDurable("queueMulti5").build();
    }

    @Bean("Multi6")
    public Queue queueMulti6() {
        return QueueBuilder.nonDurable("queueMulti6").build();
    }

    @Bean("Multi7")
    public Queue queueMulti7() {
        return QueueBuilder.nonDurable("queueMulti7").build();
    }

    @Bean("Multi8")
    public Queue queueMulti8() {
        return QueueBuilder.nonDurable("queueMulti8").build();
    }

    @Bean
    public Binding queueSingleBindingX(@Qualifier("Single") Queue queueA,
                                       @Qualifier("xExchange") Exchange xExchange) {
        return BindingBuilder.bind(queueA).to(xExchange).with("single").noargs();
    }

    @Bean
    public Binding queueMulti1BindingX(@Qualifier("Multi1") Queue queueA,
                                       @Qualifier("xExchange") Exchange xExchange) {
        return BindingBuilder.bind(queueA).to(xExchange).with("multi").noargs();
    }

    @Bean
    public Binding queueMulti2BindingX(@Qualifier("Multi2") Queue queueA,
                                       @Qualifier("xExchange") Exchange xExchange) {
        return BindingBuilder.bind(queueA).to(xExchange).with("multi").noargs();
    }

    @Bean
    public Binding queueMulti3BindingX(@Qualifier("Multi3") Queue queueA,
                                       @Qualifier("xExchange") Exchange xExchange) {
        return BindingBuilder.bind(queueA).to(xExchange).with("multi").noargs();
    }

    @Bean
    public Binding queueMulti4BindingX(@Qualifier("Multi4") Queue queueA,
                                       @Qualifier("xExchange") Exchange xExchange) {
        return BindingBuilder.bind(queueA).to(xExchange).with("multi").noargs();
    }

    @Bean
    public Binding queueMulti5BindingX(@Qualifier("Multi5") Queue queueA,
                                       @Qualifier("xExchange") Exchange xExchange) {
        return BindingBuilder.bind(queueA).to(xExchange).with("multi").noargs();
    }

    @Bean
    public Binding queueMulti6BindingX(@Qualifier("Multi6") Queue queueA,
                                       @Qualifier("xExchange") Exchange xExchange) {
        return BindingBuilder.bind(queueA).to(xExchange).with("multi").noargs();
    }

    @Bean
    public Binding queueMulti7BindingX(@Qualifier("Multi7") Queue queueA,
                                       @Qualifier("xExchange") Exchange xExchange) {
        return BindingBuilder.bind(queueA).to(xExchange).with("multi").noargs();
    }

    @Bean
    public Binding queueMulti8BindingX(@Qualifier("Multi8") Queue queueA,
                                       @Qualifier("xExchange") Exchange xExchange) {
        return BindingBuilder.bind(queueA).to(xExchange).with("multi").noargs();
    }
}

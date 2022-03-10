package org.apache.rocketmq.client.producer;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.netty.NettyRemotingClient;
import org.junit.Test;

/**
 * @author liuguangxin <liuguangxin@kuaishou.com>
 * Created on 2022-03-10
 */
public class DefaultMQProducerTestV2 {

    @Test
    public void testSetCallbackExecutor() throws Exception {

        String producerGroupTemp = "topic_unit_test";
        DefaultMQProducer producer = new DefaultMQProducer(producerGroupTemp);
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();

        Message message = createMessage();
        SendResult send = producer.send(message);
        System.out.println(send);

        producer.shutdown();
    }


    private Message createMessage() {
        Message message = new Message();
        message.setBody("HelloWorld".getBytes(StandardCharsets.UTF_8));
        message.setTopic("UnitTest");
        return message;
    }
}

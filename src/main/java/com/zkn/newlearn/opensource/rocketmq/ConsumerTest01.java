package com.zkn.newlearn.opensource.rocketmq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * Created by zkn on 2016/10/27.
 */
public class ConsumerTest01 {

    /**
     * 当前例子是PushConsumer用法，使用方式给用户感觉是消息从RocketMQ服务器推到了应用客户端。<br>
     * 但是实际PushConsumer内部是使用长轮询Pull方式从MetaQ服务器拉消息，然后再回调用户Listener方法<br>
     */
    public static void main(String[] args) {

        /**
         * 注意：ConsumerGroupName需要由应用来保证唯一
         */
        DefaultMQPushConsumer pushConsumer = new DefaultMQPushConsumer("ProducerGroupName");
        //pushConsumer.setNamesrvAddr("192.168.180.1:9876");
        pushConsumer.setNamesrvAddr("192.168.180.133:9876");
        pushConsumer.setInstanceName("Consumer");
        try {
            /**
             * 订阅指定topic下tags分别等于TagA或TagC或TagD
             * 两个参数：第一个参数是topic第二个参数是tags
             */
            pushConsumer.subscribe("TopicTest1", "TagA || TagC || TagD");
            /**
            * 订阅指定topic下所有消息<br>
            * 注意：一个consumer对象可以订阅多个topic
            */
            //pushConsumer.subscribe("TopicTest2", "*");
            pushConsumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                                ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                    System.out.println(Thread.currentThread().getName() + " Receive New Messages: " + msgs.size());
                    MessageExt messageExt = msgs.get(0);
                    if("TopicTest1".equals(messageExt.getTopic())){
                        // 执行TopicTest1的消费逻辑
                        if (messageExt.getTags() != null && "TagA".equals(messageExt.getTags())) {
                            // 执行TagA的消费
                            System.out.println(new String(messageExt.getBody()));
                        }else if(messageExt.getTags() != null && "TagB".equals(messageExt.getTags())){
                            System.out.println(new String(messageExt.getBody()));
                        }else if(messageExt.getTags() != null && "TagC".equals(messageExt.getTags())) {
                            System.out.println(new String(messageExt.getBody()));
                        }
                    }else if("TopicTest2".equals(messageExt.getTopic())){
                        System.out.println(new String(messageExt.getBody()));
                    }
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        /**
         * Consumer对象在使用之前必须要调用start初始化，初始化一次即可<br>
         */
        try {
            pushConsumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        System.out.println("Consumer Started.");
    }
}

package jms;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.*;

import java.util.List;

public class mas {
    public static void main(String[] args) throws InterruptedException {
        //建立AWS链接
        String ak = "ak";
        String ac = "ac";
        AmazonSQS sqs = new AmazonSQSClient(new BasicAWSCredentials(ak,ac));
        //获取一个队列句柄
        String url = sqs.createQueue(new CreateQueueRequest("a_queue")).getQueueUrl();
        // 通过SQS发送消息
        sqs.sendMessage( new SendMessageRequest(url,"It's a wonderful life"));

        //读取消息
        while (true) {
            List<Message> msgs = sqs.receiveMessage(
                    new ReceiveMessageRequest(url).withMaxNumberOfMessages(1)).getMessages();

            if (msgs.size() > 0) {
                Message message = msgs.get(0);
                System.out.println("The message is " + message.getBody());
                sqs.deleteMessage(new DeleteMessageRequest(url, message.getReceiptHandle()));
            } else {
                System.out.println("nothing found, trying again in 30 seconds");
                Thread.sleep(3000);
            }
        }
    }
}

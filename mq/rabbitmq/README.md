队列参数：
Name
Durable（消息代理重启后，队列依旧存在）
Exclusive（只被一个连接（connection）使用，而且当连接关闭后队列即被删除）
Auto-delete（当最后一个消费者退订后即被删除）
Arguments（一些消息代理用他来完成类似与TTL的某些额外功能）



本文介绍两种延时队列：

1.TTL延时队列
RabbitMQ的Queue可以配置
x-dead-letter-exchange 
和x-dead-letter-routing-key（可选）两个参数，
如果队列内出现了dead letter，则按照这两个参数重新路由转发到指定的队列。
2.插件式延时队列








消息确认机制：手动 
https://www.cnblogs.com/milicool/p/9662447.html
















博客参考文献：
https://www.cnblogs.com/mfrank/p/11260355.html
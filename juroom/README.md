
聚落智慧公寓项目

项目框架
springboot+mybatisplus+redis+rabbitMQ+JWT+xxl-job

xxxApi 模块，微服务划分模块，后续改造需要提供给其他模块使用


服务，由于人数不多可以表的模块来区分

juroom
    -juroom-biz   商户端模块服务
        --bizApi    商户端公共API
        --bizCore   商户端web应用入口
    -juroom-common  商户公共common
    -juroom-user  用户端
        --userApi   用户端公共API
        --userCore  用户端应用入口
    -juroom-admin  运营端
        --adminApi   运营端公共API
        --adminCore  运营端应用入口



集成spring-quartz 集群任务调度
集成 报错预警email发送
集成EasyExcel  简单易用  https://easyexcel.opensource.alibaba.com/docs/current/

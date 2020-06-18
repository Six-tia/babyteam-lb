# Nginx

*Nginx*

---

## 负载均衡（Load Balance）
- 任务分配到多个服务器执行，进而达到提高执行效率，缩短执行时间的目的。
- 两种：硬负载均衡（硬件），软负载均衡（软件）
## Nginx六种负载均衡策略
1. Default-轮询策略
2. Weughted-权重策略
3. Least Connected-最少连接策略（即选择最空闲服务器）
4. Fair-按响应时间（第三方插件进行监控）
5. IP Hash-IP绑定策略(即按照ip地址分发，适合低并发)
6. Url_Hash-按url分配策略（第三方，类IP Hash）

## Nginx心跳检查机制
- server 127.0.0.1:8080 max_fails=3 fail_timeout=30s;
    - max_fails 表示最大失败次数
    - fail_timeout 表示单次连接超时时间

## Nginx Session同步问题
### Nginx环境下存在Session不同步的问题
#### 解决方法：
- 将Session转存到Redis中实现Session“共享访问”
- Spring Session
##### Spring Session
- 把servlet容器实现的httpSession替换为spring-session
- 提供了管理用户Session的API实现
- 可用于Spring/SpringBoot环境
- SpringBoot提供了对应的Starter集成
- 专注于解决 session管理问题，Session信息存储在Redis中，可简单快速且无缝的集成到我们的应用中
## 项目实现步骤：
1. 在一台电脑模拟4个服务器（通过端口不同识别）
    - 设置VM options: DServer.port=8001/8002/8003/8004
2. 在Nginx.conf文件中配置相关信息
3. 加上Spring Session的依赖，修改yml文件
4. 在启动的main函数加上@EnableRedisHttpSession,项目会自动检测加入到session的信息，并存储在redis中（默认有效时间：30mins）
5. 重置session有效时长（1h）：
- @EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600)

## Nginx静态资源缓存
- 降低Tomcat压力
- 将原本需要发往Tomcat的css,js等（静态）资源请求，通过Nginx拦截，转为已缓存的文件位置。
- 配置nginx的conf文件

## Nginx资源压缩
- 利用浏览器支持的Gzip压缩，nginx打包压缩并传输css，js等静态资源，可将带宽压力降低30%-70%
- 100mbps=102400kbmps=12800kb/s, 若jquery.js=100kb,并发量约为128，带宽价格昂贵，在高并发环境难以维持
- 配置nginx的conf配置文件




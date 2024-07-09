# Micro-service API Implement Method

- **RESTful API**: HTTP Protocol using CURD (GET、POST、PUT、DELETE).
- **GraphQL**: Highly flexible CURD with much more accurate data.
- **Message Queue**: Support hight concurrency and asynchronous request.
- **WebSockets**: Provide realtime data and low latency data.
- **Hybrid**: Combine above data flow will be ↓↓↓↓↓↓↓↓
```text
+------------------+    +------------------+    +------------------+    +------------------+
|    RESTful API   |    |   Message Queue  |    |    WebSocket     |    |     GraphQL      |
|    (HTTP/HTTPS)  |    |    (MQ System)   |    |   (Real-Time)    |    |   (Non-Relation) |
+------------------+    +------------------+    +------------------+    +------------------+
         |                       |                      |                      |
         v                       v                      v                      v
+------------------------------------------------------------------------------------------+
|                      API Gateway or Load Balancer (External Access)                      |
+------------------------------------------------------------------------------------------+
         |                       |                      |                      |
         v                       v                      v                      v
+------------------+    +------------------+    +------------------+    +------------------+
|   Microservice   |    |   Microservice   |    |   Microservice   |    |   Microservice   |
|      (Java)      |    |     (Python)     |    |     (Node.js)    |    |      (Ruby)      |
+------------------+    +------------------+    +------------------+    +------------------+
         |                       |                      |                      |
         v                       v                      v                      v
+------------------------------------------------------------------------------------------+
|                      Shared Database or Microservice-Specific Database                   |
+------------------------------------------------------------------------------------------+
```
  

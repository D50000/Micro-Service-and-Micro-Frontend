# Micro Service and Micro Frontend

## Micro-service Architecture

#### 1. Technology Stack

- **Service Language:** Java Spring Boot
- **Database:** PostgreSQL or MongoDB
- **Message Queue:** Kafka or RabbitMQ (For Support Long Job API)
- **Service Discovery:** [Nacos](https://github.com/alibaba/nacos/wiki), [Eureka](https://github.com/Netflix/eureka/wiki), [Consul](https://github.com/hashicorp/consul), [Zookeeper](https://github.com/apache/zookeeper).
- **API Gateway:** [Spring Cloud Gateway](https://github.com/spring-cloud/spring-cloud-gateway), [Kong](https://github.com/qianyugang/kong-docs-cn), [Netflix Zuul](https://github.com/Netflix/zuul/wiki)
- **Monitor and Logs:** Kibana with Elasticsearch, Logstash (ELK) or Grafana + Prometheus

#### 2. [API Service Implement](https://github.com/D50000/Micro-Service-and-Micro-Frontend/blob/main/Micro-service%20Architecture/README.md) with Restful and integrate with MQ structure.

#### 3. Setup up service discovery and api gateway

Install **Eureka** for service discovery and **Spring Cloud Gateway** for api gateway into `pom.xml`.And setup the configuration according to the official guideline.

#### 4. Collect and monitor log data with ELK tool stack
- Elasticsearch for complex data search syntax and data analyze feature.
- Logstash collect real time log and archived for query.
- Kibana provide diverse data visualization tools.

## Micro-frontend Architecture

#### 1. Develop frontend project using Angular framework with **Domain Driven Design structure (DDD)**.

```text
# Project structure example:
src/
├── app/
│   ├── app.component.ts
│   ├── app-routing.module.ts
│   ├── app.module.ts
│   ├── shared/
│   │   ├── components/
│   │   │   ├── header/
│   │   │   └── footer/
│   │   └── shared.module.ts
│   ├── core/
│   │   ├── services/
│   │   ├── interceptors/
│   │   └── core.module.ts
│   ├── user/
│   │   ├── models/
│   │   │   └── user.model.ts
│   │   ├── services/
│   │   │   └── user.service.ts
│   │   ├── components/
│   │   │   ├── user-list/
│   │   │   │   ├── user-list.component.ts
│   │   │   │   └── user-list.component.html
│   │   │   ├── user-detail/
│   │   │   │   ├── user-detail.component.ts
│   │   │   │   └── user-detail.component.html
│   │   ├── user-routing.module.ts
│   │   └── user.module.ts
│   ├── order/
│   │   ├── models/
│   │   ├── services/
│   │   │   └── order.model.ts
│   │   │   └── order.service.ts
│   │   ├── components/
│   │   │   ├── order-list/
│   │   │   │   ├── order-list.component.ts
│   │   │   │   └── order-list.component.html
│   │   │   ├── order-detail/
│   │   │   │   ├── order-detail.component.ts
│   │   │   │   └── order-detail.component.html
│   │   ├── order-routing.module.ts
│   │   └── order.module.ts
│   └── inventory/
│       ├── models/
│       │   └── inventory.model.ts
│       ├── services/
│       │   └── inventory.service.ts
│       ├── components/
│       │   ├── inventory-list/
│       │   │   ├── inventory-list.component.ts
│       │   │   └── inventory-list.component.html
│       │   ├── inventory-detail/
│       │   │   ├── inventory-detail.component.ts
│       │   │   └── inventory-detail.component.html
│       ├── inventory-routing.module.ts
│       └── inventory.module.ts
```

#### 2. Build and Packaging

Run angular cli in your angular project. **"Order module"** for example generate library for it.

```shell
ng generate library order-library
```

Then move all files from `src/app/order` into `projects/order-library/src/lib`.

```text
├── order/
│    ├── models/
│    │   └── order.model.ts
│    ├── services/
│    │   └── order.service.ts
│    ├── components/
│    │   ├── order-list/
│    │   │   ├── order-list.component.ts
│    │   │   └── order-list.component.html
│    │   ├── order-detail/
│    │   │   ├── order-detail.component.ts
│    │   │   └── order-detail.component.html
│    ├── order-routing.module.ts
│    └── order.module.ts
projects/
├── order-library/
│   ├── src/
│   │   ├── lib/
│   │   │   ├── components/
│   │   │   │   ├── order-list/
│   │   │   │   │   ├── order-list.component.ts
│   │   │   │   │   └── order-list.component.html
│   │   │   │   ├── order-detail/
│   │   │   │   │   ├── order-detail.component.ts
│   │   │   │   │   └── order-detail.component.html
│   │   │   ├── models/
│   │   │   │   └── order.model.ts
│   │   │   ├── services/
│   │   │   │   └── order.service.ts
│   │   │   ├── order.module.ts
│   │   │   ├── order-routing.module.ts
│   │   └── public-api.ts
```

Configure and export features in `projects/order-library/src/public-api.ts` (Include Component/Service/Module). Complete the library module and build it with `ng build order-library`. The artifact will archived in `dist/order-library` folder.

#### 3. Deploy NPM server

Configure the **npm server** in `.npmrc`. And push to deploy the library.

```shell
cd dist/order-library
npm publish
```

#### 4. Import and Integrate library

Install the **order-library** with command `npm install order-library`. And setup it in the app.module.ts.

```ts
import { OrderModule } from "order-library";

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    OrderModule, // Add in import property.
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
```

Use the component:

```html
<h1>My App</h1>
<order-list></order-list>
<!-- order list component in order-library -->
```

Use the service:

```ts
import { Component, OnInit } from "@angular/core";
import { OrderService } from "order-library"; // Import the order.service

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
})
export class AppComponent implements OnInit {
  orders: any[] = [];

  constructor(private orderService: OrderService) {} // Inject the service

  ngOnInit() {
    // Invoke the api data by rx.js
    // getOrders() is declare in the order-library. And implement in it's service.
    this.orderService.getOrders().subscribe((data) => {
      this.orders = data;
    });
  }
}
```

# Micro Service and Micro Frontend

## Micro-service/frontend Architecture

## Micro-frontend Architecture

1. Develop frontend project using Angular framework with **Domain Driven Design structure (DDD)**.
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
│   │   │   └── order.model.ts
│   │   ├── services/
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

2. Build and Packaging
Run angular cli in your angular project. **"Order module"** for example generate library for it.
```shell
ng generate library order-library
```

Then move all files from `src/app/order` into `projects/order-library/src/lib`
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
1. Deploy NPM server
2. Import and Integrate library
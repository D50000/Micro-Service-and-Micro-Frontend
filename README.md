# Micro Service and Micro Frontend

## Micro-service/frontend Architecture

## Micro-frontend Architecture

1. Use Angular framework with **Domain Driven Design structure (DDD)**.
```text
# Project structure example:
src/app/
  ├── app-routing.module.ts
  ├── app.module.ts
  ├── shared/
  │   ├── components/
  │   │   ├── header/
  │   │   └── footer/
  │   └── shared.module.ts
  ├── core/
  │   ├── services/
  │   ├── interceptors/
  │   └── core.module.ts
  ├── user/
  │   ├── models/
  │   │   └── user.model.ts
  │   ├── services/
  │   │   └── user.service.ts
  │   ├── components/
  │   │   ├── user-list/
  │   │   │   ├── user-list.component.ts
  │   │   │   └── user-list.component.html
  │   │   ├── user-detail/
  │   │   │   ├── user-detail.component.ts
  │   │   │   └── user-detail.component.html
  │   ├── user-routing.module.ts
  │   └── user.module.ts
  ├── order/
  │   ├── models/
  │   │   └── order.model.ts
  │   ├── services/
  │   │   └── order.service.ts
  │   ├── components/
  │   │   ├── order-list/
  │   │   │   ├── order-list.component.ts
  │   │   │   └── order-list.component.html
  │   │   ├── order-detail/
  │   │   │   ├── order-detail.component.ts
  │   │   │   └── order-detail.component.html
  │   ├── order-routing.module.ts
  │   └── order.module.ts
  └── inventory/
      ├── models/
      │   └── inventory.model.ts
      ├── services/
      │   └── inventory.service.ts
      ├── components/
      │   ├── inventory-list/
      │   │   ├── inventory-list.component.ts
      │   │   └── inventory-list.component.html
      │   ├── inventory-detail/
      │   │   ├── inventory-detail.component.ts
      │   │   └── inventory-detail.component.html
      ├── inventory-routing.module.ts
      └── inventory.module.ts
```

2. Build and Packaging
3. Deploy NPM server
4. Import and Integrate library
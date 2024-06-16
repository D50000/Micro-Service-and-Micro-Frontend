export interface Order {
  id: string;
  customerName: string;
  orderDate: Date;
  items: OrderItem[];
  totalAmount: number;
}

export interface OrderItem {
  productId: string;
  productName: string;
  quantity: number;
  price: number;
}

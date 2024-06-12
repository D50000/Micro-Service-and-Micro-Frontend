import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderLibraryComponent } from './order-library.component';

describe('OrderLibraryComponent', () => {
  let component: OrderLibraryComponent;
  let fixture: ComponentFixture<OrderLibraryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrderLibraryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderLibraryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

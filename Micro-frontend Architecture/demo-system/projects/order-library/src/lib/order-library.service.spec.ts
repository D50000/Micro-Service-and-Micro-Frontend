import { TestBed } from '@angular/core/testing';

import { OrderLibraryService } from './order-library.service';

describe('OrderLibraryService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: OrderLibraryService = TestBed.get(OrderLibraryService);
    expect(service).toBeTruthy();
  });
});

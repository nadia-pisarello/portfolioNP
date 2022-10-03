import { TestBed } from '@angular/core/testing';

import { InterceptorProviderService } from './interceptor-provider.service';

describe('InterceptorProviderService', () => {
  let service: InterceptorProviderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InterceptorProviderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

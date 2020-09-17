import { TestBed } from '@angular/core/testing';

import { AuthenateGaurdService } from './authenate-gaurd.service';

describe('AuthenateGaurdService', () => {
  let service: AuthenateGaurdService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthenateGaurdService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

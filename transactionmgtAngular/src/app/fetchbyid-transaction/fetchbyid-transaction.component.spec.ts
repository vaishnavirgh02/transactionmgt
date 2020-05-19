import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FetchbyidTransactionComponent } from './fetchbyid-transaction.component';

describe('FetchbyidTransactionComponent', () => {
  let component: FetchbyidTransactionComponent;
  let fixture: ComponentFixture<FetchbyidTransactionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FetchbyidTransactionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FetchbyidTransactionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

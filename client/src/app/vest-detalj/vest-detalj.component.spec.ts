import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VestDetaljComponent } from './vest-detalj.component';

describe('VestDetaljComponent', () => {
  let component: VestDetaljComponent;
  let fixture: ComponentFixture<VestDetaljComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VestDetaljComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VestDetaljComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

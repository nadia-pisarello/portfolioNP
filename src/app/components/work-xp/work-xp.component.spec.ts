import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkXpComponent } from './work-xp.component';

describe('WorkXpComponent', () => {
  let component: WorkXpComponent;
  let fixture: ComponentFixture<WorkXpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WorkXpComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WorkXpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

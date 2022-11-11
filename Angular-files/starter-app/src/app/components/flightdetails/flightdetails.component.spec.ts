import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlightdetailsComponent } from './flightdetails.component';

describe('FlightdetailsComponent', () => {
  let component: FlightdetailsComponent;
  let fixture: ComponentFixture<FlightdetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FlightdetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FlightdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

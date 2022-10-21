import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BildKulComponent } from './bild-kul.component';

describe('BildKulComponent', () => {
  let component: BildKulComponent;
  let fixture: ComponentFixture<BildKulComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BildKulComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BildKulComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

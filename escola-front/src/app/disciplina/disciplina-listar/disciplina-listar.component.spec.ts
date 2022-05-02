import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisciplinaListarComponent } from './disciplina-listar.component';

describe('DisciplinaListarComponent', () => {
  let component: DisciplinaListarComponent;
  let fixture: ComponentFixture<DisciplinaListarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisciplinaListarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DisciplinaListarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

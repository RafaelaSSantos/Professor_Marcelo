import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TurmaListarComponent } from './turma-listar.component';

describe('TurmaListarComponent', () => {
  let component: TurmaListarComponent;
  let fixture: ComponentFixture<TurmaListarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TurmaListarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TurmaListarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

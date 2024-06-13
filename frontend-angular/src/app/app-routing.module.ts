import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BienvenidaComponent } from './pages/bienvenida/bienvenida.component';
import { InformacionComponent } from './pages/informacion/informacion.component';
import { TecnologiasComponent } from './pages/tecnologias/tecnologias.component';
import { ObjetoListaComponent } from './pages/objeto/objeto-lista/objeto-lista.component';
import { AgregarObjetoComponent } from './pages/objeto/agregar-objeto/agregar-objeto.component';
import { EditarObjetoComponent } from './pages/objeto/editar-objeto/editar-objeto.component';
import { LoginComponent } from './pages/login/login.component';
import { SignupComponent } from './pages/signup/signup.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'bienvenida', component: BienvenidaComponent },
  { path: 'informacion', component: InformacionComponent },
  { path: 'tecnologias', component: TecnologiasComponent },
  { path: 'objetos', component: ObjetoListaComponent },
  { path: 'agregar-objeto', component: AgregarObjetoComponent },
  { path: 'editar-objeto/:id', component: EditarObjetoComponent },
  { path: '**', redirectTo: 'login', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

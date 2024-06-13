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
import { AuthGuard } from './auth.guard';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'bienvenida', component: BienvenidaComponent, canActivate: [AuthGuard] },
  { path: 'informacion', component: InformacionComponent, canActivate: [AuthGuard] },
  { path: 'tecnologias', component: TecnologiasComponent, canActivate: [AuthGuard] },
  { path: 'objetos', component: ObjetoListaComponent, canActivate: [AuthGuard] },
  { path: 'agregar-objeto', component: AgregarObjetoComponent, canActivate: [AuthGuard] },
  { path: 'editar-objeto/:id', component: EditarObjetoComponent, canActivate: [AuthGuard] },
  { path: '**', redirectTo: 'login', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

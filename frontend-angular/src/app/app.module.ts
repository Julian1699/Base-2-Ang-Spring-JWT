import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { BienvenidaComponent } from './pages/bienvenida/bienvenida.component';
import { InformacionComponent } from './pages/informacion/informacion.component';
import { TecnologiasComponent } from './pages/tecnologias/tecnologias.component';
import { ObjetoListaComponent } from './pages/objeto/objeto-lista/objeto-lista.component';
import { AgregarObjetoComponent } from './pages/objeto/agregar-objeto/agregar-objeto.component';
import { EditarObjetoComponent } from './pages/objeto/editar-objeto/editar-objeto.component';
import { LoginComponent } from './pages/login/login.component';
import { SignupComponent } from './pages/signup/signup.component';
import { authInterceptorProviders } from './services/auth.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    BienvenidaComponent,
    InformacionComponent,
    TecnologiasComponent,
    ObjetoListaComponent,
    AgregarObjetoComponent,
    EditarObjetoComponent,
    LoginComponent,
    SignupComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }

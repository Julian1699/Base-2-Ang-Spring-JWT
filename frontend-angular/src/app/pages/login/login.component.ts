import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../../services/login.service';
import { LoginDto } from '../../models/login-dto'; 

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginData: LoginDto = {
    username: '',
    password: ''
  };

  constructor(private loginService: LoginService, private router: Router) {}

  formSubmit() {
    if (this.loginData.username.trim() === '' || this.loginData.password.trim() === '') {
      return;
    }
  
    this.loginService.generateToken(this.loginData).subscribe(
      (response: any) => {
        this.loginService.loginUser(response.token);
        this.loginService.setUsername(this.loginData.username);
        this.router.navigate(['/bienvenida']); // Redirige a una página de bienvenida o dashboard después de iniciar sesión
      },
      (error) => {
        console.error('Error al iniciar sesión', error);
      }
    );
  }  
}

import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  user: any = {
    username: '',
    password: '',
    email: '',
    nombre: '',
    apellido: '',
    telefono: ''
  };

  constructor(private userService: UserService, private router: Router, private snackBar: MatSnackBar) {}

  formSubmit() {
    this.userService.addUser(this.user).subscribe(
      (response: any) => {
        this.snackBar.open('Usuario registrado con éxito', 'Cerrar', { duration: 3000 });
        this.router.navigate(['/login']);
      },
      (error) => {
        if (error.status === 409) {
          this.snackBar.open('El nombre de usuario ya está registrado', 'Cerrar', { duration: 3000 });
        }
      }
    );
  }
}

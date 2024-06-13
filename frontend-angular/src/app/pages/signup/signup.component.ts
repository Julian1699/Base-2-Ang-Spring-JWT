import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';
import { UserEntity } from '../../models/user-entity';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  user: UserEntity = {
    username: '',
    password: '',
    email: '',
    nombre: '',
    apellido: '',
    telefono: ''
  };

  constructor(private userService: UserService, private router: Router) {}

  formSubmit() {
    if (this.user.username.trim() === '' || this.user.password.trim() === '' || this.user.email.trim() === '') {
      return;
    }

    this.userService.addUser(this.user).subscribe(
      (response: any) => {
        this.router.navigate(['/login']);
      },
      (error) => {
        console.error('Error al registrar usuario', error);
      }
    );
  }
}

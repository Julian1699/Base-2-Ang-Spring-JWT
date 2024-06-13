import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  username: string | null = '';

  constructor(private loginService: LoginService, private router: Router) {}

  ngOnInit(): void {
    this.username = this.loginService.getUsername();
  }

  logout(): void {
    this.loginService.logout();
    this.router.navigate(['/login']);
  }
}

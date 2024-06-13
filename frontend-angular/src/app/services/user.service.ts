import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserEntity } from '../models/user-entity'; // Asegúrate de definir este modelo

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = 'http://localhost:8080/api/v1/users';  // URL de la API

  constructor(private httpClient: HttpClient) { }

  // Añadir usuario
  public addUser(user: UserEntity): Observable<UserEntity> {
    return this.httpClient.post<UserEntity>(this.baseUrl, user);
  }

}

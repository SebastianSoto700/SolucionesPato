import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class ProductoService {
  private baseUrl = 'http://localhost:1218/Productos/clientes'; // Ajusta si usas otro endpoint

  constructor(private http: HttpClient) {}

  getProductos(): Observable<any[]> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Accept': 'application/json'
    });

    return this.http.get<any[]>(this.baseUrl, { headers }).pipe(
      catchError(error => {
        console.error('Error en ProductoService:', error);
        return throwError(() => error);
      })
    );
  }
}
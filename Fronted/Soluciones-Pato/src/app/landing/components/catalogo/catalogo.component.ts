import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgFor } from '@angular/common';
import { FooterComponent } from "../footer/footer.component";
import { NavbarComponent } from "../navbar/navbar.component";

@Component({
  selector: 'app-catalogo',
  standalone: true,
  imports: [NgFor, FooterComponent, NavbarComponent],
  templateUrl: './catalogo.component.html',
})
export class CatalogoComponent {
  productos = [
    {
      id: 1,
      nombre: 'Silla de Madera',
      descripcion: 'Hecha a mano con madera maciza y acabados finos.',
      precio: 'Desde S/150',
      imagen: 'assets/images/catalogo/silla.jpg'
    },
    {
      id: 2,
      nombre: 'Mesa de Comedor',
      descripcion: 'Mesa para 6 personas en roble, diseño elegante.',
      precio: 'Desde S/850',
      imagen: 'assets/images/catalogo/mesa.jpg'
    },
    {
      id: 3,
      nombre: 'Armario',
      descripcion: 'Armario de dos puertas con divisiones personalizadas.',
      precio: 'Desde S/1200',
      imagen: 'assets/images/catalogo/armario.jpg'
    }
  ];

  constructor(private router: Router) {}

  cotizar(producto: any) {
    this.router.navigate(['/cotizaciones'], { queryParams: { producto: producto.nombre } });
  }
}

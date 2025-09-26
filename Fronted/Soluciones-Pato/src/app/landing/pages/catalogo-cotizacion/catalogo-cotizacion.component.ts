import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NavbarComponent } from "../../components/navbar/navbar.component";
import { FooterComponent } from "../../components/footer/footer.component";
import { NgIf, NgForOf } from "@angular/common";
import { ProductoService } from '../../../services/producto.service';
import { HttpClientModule } from '@angular/common/http';

@Component({
  standalone: true,
  selector: 'app-catalogo-cotizacion',
  templateUrl: './catalogo-cotizacion.component.html',
  imports: [FormsModule, NavbarComponent, FooterComponent, NgIf, NgForOf, HttpClientModule],
})
export class CatalogoCotizacionComponent implements OnInit {
  productos: any[] = [];
  productoSeleccionado: any = null;
  mostrarFormulario = false;
  nombre = '';
  email = '';
  telefono = '';
  mensaje = '';

  constructor(private productoService: ProductoService) {}

  ngOnInit() {
    this.productoService.getProductos().subscribe((data) => {
      this.productos = data;
    });
  }

  verDetalle(producto: any) {
    this.productoSeleccionado = producto;
    this.mostrarFormulario = false;
  }

  cotizar() {
    this.mostrarFormulario = true;
  }

  enviarWhatsApp() {
    const numeroEmpresa = '51940356043';
    const texto = `Hola, me interesa cotizar el producto/servicio: ${this.productoSeleccionado.nombre}.
Mis datos:
- Nombre: ${this.nombre}
- Email: ${this.email}
- Teléfono: ${this.telefono}
- Mensaje: ${this.mensaje}`;
    const url = `https://wa.me/${numeroEmpresa}?text=${encodeURIComponent(texto)}`;
    window.open(url, '_blank');
  }
}
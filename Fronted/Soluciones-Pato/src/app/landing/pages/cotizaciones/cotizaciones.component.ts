import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { NavbarComponent } from "../../components/navbar/navbar.component";
import { FooterComponent } from "../../components/footer/footer.component";
import { NgIf } from "@angular/common";

@Component({
  selector: 'app-cotizaciones',
  standalone: true,
  imports: [FormsModule, NavbarComponent, FooterComponent, NgIf],
  templateUrl: './cotizaciones.component.html',
})
export class CotizacionesComponent {
  productoSeleccionado: string = '';
  nombre = '';
  email = '';
  telefono = '';
  mensaje = '';

  constructor(private route: ActivatedRoute) {
    // Capturamos el producto que llega desde el catálogo
    this.route.queryParams.subscribe(params => {
      this.productoSeleccionado = params['producto'] || '';
    });
  }

  enviarWhatsApp() {
    const numeroEmpresa = '51987654321'; // tu número con código de país (+51 si es Perú)
    const texto = `Hola, me interesa cotizar el producto/servicio: ${this.productoSeleccionado}.
    
Mis datos:
- Nombre: ${this.nombre}
- Email: ${this.email}
- Teléfono: ${this.telefono}
- Mensaje: ${this.mensaje}`;

    const url = `https://wa.me/${numeroEmpresa}?text=${encodeURIComponent(texto)}`;
    window.open(url, '_blank');
  }
}

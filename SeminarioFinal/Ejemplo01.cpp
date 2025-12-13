#include <iostream>
using namespace std;

int main() {
	// Variables
	string cliente;
	char producto;
	int cantidad;
	double precio, subtotal, porcDcto, descuento, total;
	// Datos o lectura
	cout << "LECTURA DE DATOS DE LA VENTA\n";
	cout << "Cliente: "; cin >> cliente;
	do{
		cout << "Tipo de producto (A|B|C): "; cin >> producto;
		if(producto != 'A' && producto != 'B' && producto != 'C'){
			cout << "Tipo de producto invalido.\n";
		}
	} while(producto != 'A' && producto != 'B' && producto != 'C');
	cout << "Cantidad: "; cin >> cantidad;	
	// Proceso
	switch(producto){
		case 'A':
			precio = 2.5;
			break;
		case 'B':
			precio = 4.7;
			break;
		case 'C':
			precio = 16.4;
			break;
		default:
			precio = 0.0;
	}
	subtotal = precio * cantidad;
	switch(producto){
		case 'A':
			porcDcto = (cantidad<=30?7:15);
			break;
		case 'B':
			porcDcto = (cantidad<=20?5:(cantidad>100?35:25));
			break;
		case 'C':
			porcDcto = 2;
			break;
		default:
			porcDcto = 0;
	}
	descuento = subtotal * porcDcto / 100.0;
	total = subtotal - descuento;
	// Reporte
	cout << "\n\n";
	cout << "REPORTE\n";
	cout << "Cliente: " << cliente << endl;
	cout << "Subtotal: " << subtotal << endl;
	cout << "Descuento (" << porcDcto << "%): " << descuento << endl;
	cout << "Total: " << total << endl;
	return 0;
}

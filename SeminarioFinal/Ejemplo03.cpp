#include <iostream>
#include <string>
#include <ctime>
#include <cstdlib>
using namespace std;

// Variables
const int NOTAS = 100;
int notas[NOTAS] = {};
int frecuencia[21] = {};
double promedio;
int cantMayorPromedio, moda;

void generarDatos(){
	srand(time(NULL));
 	for(int i=0;i<NOTAS;i++){
 		notas[i] = rand()%21;
	 }
}

void calculos(){
	promedio = 0;
	for(int i=0; i<NOTAS; i++){
		promedio += notas[i];
	}
	promedio = promedio / NOTAS;
	cantMayorPromedio = 0;
	for(int i=1; i<NOTAS; i++){
		if(notas[i] > promedio) cantMayorPromedio++;
	}
}

void determinarModa(){
	for(int i=0; i<NOTAS; i++){
		frecuencia[notas[i]]++;
	}
	moda = 0;
	int frec = frecuencia[moda];
	for(int i=1; i<21; i++){
		if(frecuencia[i] > frec){
			moda = i;
			frec = frecuencia[i];
		}
	}
}


int main() {

	// Datos o lectura
	generarDatos();
	// Proceso
	calculos();
	determinarModa();
	// Reporte
	cout << "\n\n";
	cout << "REPORTE\n";
	cout << "Nota promedio: " << promedio << endl;
	cout << "Cantidad alumnos mayor al promedio: " << cantMayorPromedio << endl;
	cout << "Moda: " << moda << endl;
	cout << "NOTA -> FRECUENCIA\n";
	for(int i=0; i<21; i++){
		cout << i << "\t" << frecuencia[i] << endl;
	}
	return 0;
}

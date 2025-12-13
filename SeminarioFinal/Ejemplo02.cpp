#include <iostream>
#include <string>
using namespace std;

bool esPrimo(int n){
	if(n<=1) return false;
	if(n<=3) return true;
	for(int i=2;i<n;i++){
		if(n%i==0) return false;
	}
	return true;
}

int main() {
	// Variables
	int numero;
	string divisores;
	int primos;
	// Datos o lectura
	cout << "LECTURA DE DATOS\n";
	do{
		cout << "Numero entero entre 1 y 1000: "; cin >> numero;
		if(numero<=1 || numero>=100){
			cout << "Numero fuera de rango.\n";
		}
	} while (numero<=1 || numero>=1000);
	// Proceso
	divisores = "";
	primos = 0;
	for(int i=1; i<=numero; i++){
		if(numero%i == 0){
			if(divisores!="") divisores = divisores + ",";
			divisores = divisores + to_string(i);
			if(esPrimo(i)) primos++;
		}
	}
	// Reporte
	cout << "\n\n";
	cout << "REPORTE\n";
	cout << "Numero: " << numero << endl;
	cout << "Divisores: " << divisores << endl;
	cout << "Cantidad de primos: " << primos << endl;
	return 0;
}

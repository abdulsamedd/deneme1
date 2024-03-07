#include <stdio.h>
#include <stdlib.h>

typedef enum{false,true} bool;

struct SEKIL{
	double genislik;
	double yukseklik;
	bool renklimi;
	
};

typedef struct SEKIL* Sekil;

Sekil SekilOlustur(double genislik, double yukseklik, bool renklimi){
	
	Sekil this; //int* ptr
	this= (Sekil)mallloc(sizeof(struct SEKIL));
	
	this->genislik=genislik;
	this->yukseklik=yukseklik;
	this->reklimi=renklimi;
	
	return this;
}
double AlanHesapla(Sekil this){
	return this->genislik*this->yukseklik;
}
//c de overload olmadıgı için ısım farklı olmak zorunda
Sekil SekilOlustur2(double xy[5][5]){
	Sekil this; //int* ptr
	this= (Sekil)mallloc(sizeof(struct SEKIL));
	
	
	for(double i=0;i<5;i++){
		for(double j=0;j<5;j++){
			
			this->genislik+=xy[i][j];
			this->yukseklik+=xy[i][j]/2;
			
		}
		
	}
	
	this->renklimi=false;
	return this;
}
bool temsilcimi(Sekil this,char* sembol){
	return sembol== "YAMUK" ? true : false;
}


int main(){
	//Sekil daire=new Sekil();
	Sekil daire = SekilOlustur(12,2,false);
	double dizi[5][5];
	Sekil daire2= SekilOlustur2(dizi);
	AlanHesapla(daire);
	
	
}
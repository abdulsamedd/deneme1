#include "stdio.h"
#include "conio.h"//getc() function
typedef enum{yanlis,dogru}tur_adi;//0--> yanlıs 1-->dogru
int main(){
   const double a=9.8;
   double m=100;
   printf("m:%lf\n",m);
   printf("a:%lf\n",a);
   printf("F=m*a-->%lf",m*a);
   

   return 0 ;

   
   /*  double pi=3.14;
     int a=pi;
     printf("a: %d",a);
   */
//int %d   ecimal
//double %lf   longfloat
//float %f

 /*float x=10;
 double a=10;
 float y=3;
 double b=3;
 float z=x/y;
 double c=a/b;
 if(z==c) 
 printf("esit");
 else
 printf("esit degil.\n");

 printf("z:%f ,c:%lf",z,c);
return 0 ;
*/


 
 /*
     int x=100;
     printf("size of x: %d, x: %x\n", sizeof(x), x);
     printf("size of x: %d, x: %d", sizeof(x), x);
 
 */
 //############################ tür tanımlama

   /*  tur_adi kontrol;

     kontrol=dogru;

     if(kontrol)
     printf("dogru");
     else
     printf("yanlis.");
     getch();
     return 0 ;
     
     */

//############################
   /*char c;
   printf("karakter giriniz: ");
   c=getch();
   if(c=='\r' && '\n')//enter
    {
     printf("Enter'a basildi: ");

    }
    else{
         printf("%c basildi:%c",c,c);
    }
    return 0;

   *///############################3
   /* char c='\n';//satır sonrasına atla
    printf("merhaba%c%c",c,c);
    getch();*/


    return 0; 
}